package com.organOld.service.thread;

import com.organOld.dao.entity.oldman.HealthSelect;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanKey;
import com.organOld.dao.repository.OldmanDao;
import com.organOld.dao.repository.OldmanKeyDao;
import com.organOld.service.enumModel.HealthEnum;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OldmanKeyService;
import com.organOld.service.util.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 分布式按周期更新重点老人
 * 每个线程获取一定数量（ROUND）的实体 进行更新
 * 以老人ID最大值为终止条件
 */
@Service
public class KeyAutoUpdate implements FullUpdater{

    @Autowired
    OldmanKeyService oldmanKeyService;
    @Autowired
    OldmanDao oldmanDao;
    @Autowired
    OldmanKeyDao oldmanKeyDao;
    @Autowired
    CommonService commonService;

    Lock lock = new ReentrantLock();

    private static final Logger log = LoggerFactory.getLogger(KeyAutoUpdate.class);

    private static final long LONG_POLLING_EXECUTOR_DELAY = 2 * 1000;

    /**
     * The distributed lock's name.
     */
    private final String lockName=getClass().getSimpleName().toLowerCase();

    /**
     * The timeout for loading data once.
     */
    private static final long ROUND = 1000L;

    /**
     * The timeout for loading data once.
     */
    private static final long LOADER_TIMEOUT = 10 * 1000;

    /**
     * The null value of {@link Long} type in the redis.
     */
    public static final long REDIS_NULL_VALUE = Long.MIN_VALUE;

    /**
     * The timeout for getting the distributed lock.
     */
    private static final long LOCK_TIMEOUT = 2 * 1000;

    /**
     * The timeout for getting the data from the redis.
     */
    private static final long REDIS_GET_VALUE_TIMEOUT = 1000;

    /**
     * 开关
     */
    public static Boolean OPEN_SWITCH= false;


    /**
     * The timeout for updating data once.
     */
    private static final long UPDATE_TIMEOUT = 20 * 1000;


    /**
     * The count of the working threads.
     */
    private static final int WORKER_COUNT = 4;

    public static final long EXPIRED_TIME = 30*24*60*60*1000L;//一个月

    /**
     * The long-polling executor will be scheduled with the given interval.
     */
    public ScheduledExecutorService longPollingExecutor = Executors.newScheduledThreadPool(1, runnable -> {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("update");
        return thread;
    });

    /**
     * The loader executor to load the data to update with asynchronous strategy.
     */
    private final ScheduledExecutorService loaderExecutor = Executors.newScheduledThreadPool(1, runnable -> {
        Thread thread = new Thread(runnable);
        thread.setName("loader-updater-" );
        return thread;
    });

    /**
     * The sequence number for creating working thread.
     */
    private final AtomicInteger workerSequenceNumber = new AtomicInteger();

    /**
     * the worker executor to handle the data.
     */
    private final ExecutorService workerExecutor = Executors.newFixedThreadPool(WORKER_COUNT, runnable -> {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("worker-updater-"+workerSequenceNumber.incrementAndGet());
        return thread;
    });


    public Runnable updateRunner = new Runnable() {
        @Override
        public void run() {
            try {
                if (needToUpdate()) {
                    log.info("update!!!");
                    update();
                }
            } catch (Exception ex) {
                log.error("An exception occurred when long-polling-updater-{} was working", ex);
            }finally {
                if(OPEN_SWITCH){
                    longPollingExecutor.schedule(updateRunner, LONG_POLLING_EXECUTOR_DELAY, TimeUnit.MILLISECONDS);
                }
            }
        }
    };


    public boolean needToUpdate() {
        log.info(this.getExpiredTime()+"");
        if (this.getExpiredTime() == REDIS_NULL_VALUE) {
            long max, current;
            if ((max = this.getMax()) == REDIS_NULL_VALUE) {
                log.info(this.max()+"");
                this.setMax(this.max());
                return false;
            }
            if ((current = this.getCurrent()) == REDIS_NULL_VALUE) {
                log.info(this.getCurrent()+"");
                this.setCurrent(0L);
                return false;
            }
            if (current >= max) {
                log.info(this.max()+":max");
                log.info(this.getCurrent()+":current");
                this.reset();
                return false;
            }
            return true;
        }
        return false;
    }

    public void update() {
        try {
            Future<List<OldmanKey>> future = this.loaderExecutor.submit(() -> load());
            List<OldmanKey> loadedData = future.get(LOADER_TIMEOUT, TimeUnit.MILLISECONDS);
            this.triggerBeforeUpdateEvents(loadedData);
            if (loadedData != null && loadedData.size() > 0) {
                CountDownLatch countDownLatch = new CountDownLatch(loadedData.size());
                List<Oldman> oldmanList=new ArrayList<>();
                for (OldmanKey oldmanKey : loadedData) {
                    this.workerExecutor.execute(() -> {
                        try {
                            for(HealthSelect healthSelect:oldmanKey.getHealthSelectIdsList()){
                                if(healthSelect.getFirType()== HealthEnum.MB.getIndex()){
                                    oldmanKey.getMbIds().add(healthSelect.getId());
                                }
                                if(healthSelect.getFirType()== HealthEnum.SN.getIndex()){
                                    oldmanKey.getSnIds().add(healthSelect.getId());
                                }
                            }
                            oldmanKey.setAge(commonService.birthdayToAge(oldmanKey.getBirthday()));

                            Oldman oldman=new Oldman();
                            oldman.setId(oldmanKey.getOldmanId());
                            oldman.setGoal(oldmanKeyService.calculateKeyGoal(oldmanKey));
                            oldman.setKeyStatus(oldmanKey.getKeyStatus());
                            oldmanKeyService.checkKeyStatus(oldman);
                            oldmanList.add(oldman);
                        } catch (Exception ex) {
                            log.error("Failed to convert the data [{}] to the target type", oldmanKey, ex);
                        } finally {
                            countDownLatch.countDown();
                        }
                    });
                }
                if (countDownLatch.await(UPDATE_TIMEOUT, TimeUnit.MILLISECONDS)) {
                    this.triggerAfterUpdateEvents(oldmanList);
                }
            }
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            log.error("Failed to update the data in the .");
        }
    }

    protected List<OldmanKey> load() {
        List<OldmanKey> data = new ArrayList<>();
        boolean locked = false;
        try {
            locked = lock.tryLock(LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
            if (locked) {
                long current = this.getCurrent();
                if (current < this.getMax()) {
                    data = this.load(current);
                    this.setCurrent(this.current(data));
                }
            }

        }catch (Exception ex) {
            log.warn("Failed to load the data.", ex);
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
        return data;
    }

    protected List<OldmanKey> load(long current) {
        //
        return oldmanKeyDao.getOldmanKeyByRound(ROUND,current);

    }
    /**
     * Execute all registered .
     * The method will block the current thread.
     *
     * @param loadedData the loaded data.
     */
    private void triggerBeforeUpdateEvents(List<OldmanKey> loadedData) {

    }

    /**
     * Execute all registered
     * The method will block the current thread.
     *
     * @param updatedData the updated data.
     */
    private void triggerAfterUpdateEvents(List<Oldman> updatedData) {
//        for(Oldman oldman:updatedData){
//            oldman.setGoal(50);
//            System.out.println(oldman.toString());
//        }
        oldmanDao.updateKeyOldman(updatedData);
    }


    private void reset() {
        boolean locked = false;
        try {
            locked = lock.tryLock(LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
            if (locked) {
                if (this.getExpiredTime() == REDIS_NULL_VALUE) {
                    this.setCurrent(REDIS_NULL_VALUE);
                    this.setMax(REDIS_NULL_VALUE);
                    this.setExpiredTime(this.expiredTime());
                    //TODO 通知前端 更新完成 或者生成excel表格
                }
            }
        } catch (Exception e) {
            log.warn("Failed to obtain lock when call reset method.");
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }


    /**
     * Gets the value with the given key in the redis with synchronous strategy.
     *
     * @param key the key to get in the redis.
     * @return the value corresponding with the given key. If any exception occur or empty value, zero will be returned.
     */
    private long getValue(final String key) {
        boolean locked = false;
        long result = REDIS_NULL_VALUE;
        try {
            locked = lock.tryLock(LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
            if (locked) {
                String value = (String) Cache.get(key);
                if (value != null && !value.equals(result+"")) {
                    result = Long.valueOf(value);
                }
            }
        } catch (Exception e) {
            log.warn("Failed to obtain lock when get key [{}] in the redis [{}].", key, e);
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
        return result;
    }

    private void setValue(final String key, final String value,Long time) {
        boolean locked = false;
        try {
            locked = lock.tryLock(LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
            if (locked) {
                boolean isSuccess;
                if (time!=0L){
                    isSuccess= Cache.put(key, value,time);
                }else{
                    isSuccess= Cache.put(key, value);
                }

                if (!isSuccess) {
                    log.error("Failed to set key [{}] and value [{}] into the redis.", key, value);
                }
            }
        } catch (Exception e) {
            log.warn("Failed to obtain lock when set key [{}] and value [{}] into the redis .", key, value);
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }


    @Override
    public long getExpiredTime() {
        return this.getValue("auto_expiredTime");
    }

    @Override
    public void setExpiredTime(long expiredTime) {
        //设置map的超时时间
        this.setValue("auto_expiredTime", String.valueOf(expiredTime),expiredTime);

    }

    @Override
    public long getMax() {
        return this.getValue("auto_max");
    }

    @Override
    public void setMax(long max) {
        this.setValue("auto_max", String.valueOf(max),0L);
    }

    @Override
    public long getCurrent() {
        return this.getValue("auto_current");
    }

    @Override
    public void setCurrent(long current) {
        this.setValue("auto_current", String.valueOf(current),0L);
    }


    protected long max() {
        return oldmanDao.getMaxId();
    }


    protected long expiredTime() {
        return EXPIRED_TIME;//一个月
    }

    protected long current(List<OldmanKey> data) {
        int maxId = 0;
        if (!CollectionUtils.isEmpty(data)) {
            for (OldmanKey oldmanKey : data) {
                if (oldmanKey.getOldmanId() > maxId) {
                    maxId = oldmanKey.getOldmanId();
                }
            }
        }
        return maxId;
    }
}
