package com.organOld.service.service.impl;

import com.organOld.dao.entity.oldman.KeyRule;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanKey;
import com.organOld.dao.entity.oldman.OldmanKeyHandle;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.service.constant.ValueConstant;
import com.organOld.service.contract.*;
import com.organOld.service.enumModel.KeyRuleTypeEnum;
import com.organOld.service.enumModel.KeyStatusEnum;
import com.organOld.service.model.KeyRuleTypeModel;
import com.organOld.service.model.KeyRulelModel;
import com.organOld.service.model.OldmanKeyModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.thread.KeyAutoUpdate;
import com.organOld.service.service.OldmanKeyService;
import com.organOld.service.thread.KeyUpdate;
import com.organOld.service.wrapper.OldmanKeyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class OldmanKeyServiceImpl implements OldmanKeyService {

    @Autowired
    CommonService commonService;
    @Autowired
    OldmanKeyDao oldmanKeyDao;
    @Autowired
    KeyRuleDao keyRuleDao;
    @Autowired
    KeyAutoUpdate keyAutoUpdate;
    @Autowired
    KeyUpdate keyUpdate;
    @Autowired
    OldmanKeyHandleDao oldmanKeyHandleDao;
    @Autowired
    OldmanDao oldmanDao;
    @Autowired
    OrganDao organDao;
    @Autowired
    OldmanKeyWrapper oldmanKeyWrapper;

    public static List<KeyRule> keyRuleList;



    @Override
    public String getByPage(BTableRequest bTableRequest, HttpSession session, OldmanKeyRequest oldmanKeyRequest) {
        Page<Oldman> page=commonService.getPage(bTableRequest,"oldman_key");
        Oldman oldman= oldmanKeyWrapper.unwrap(oldmanKeyRequest);
        commonService.fillXq(null,oldman);
        page.setEntity(oldman);
        List<OldmanKeyModel> oldmanKeyModelList=oldmanKeyDao.getByPage(page).stream().map(oldmanKeyWrapper::wrap).collect(Collectors.toList());
        Long size=oldmanKeyDao.getSizeByPage(page);

        for(OldmanKeyModel oldmanKeyModel:oldmanKeyModelList){
            if(oldmanKeyModel.getOldmanKeyHandleModel()!=null && oldmanKeyModel.getOldmanKeyHandleModel().getOrgandIds()!=null && oldmanKeyModel.getOldmanKeyHandleModel().getOrgandIds().size()>0){
                oldmanKeyModel.getOldmanKeyHandleModel().setOrgan(organDao.getByIds(oldmanKeyModel.getOldmanKeyHandleModel().getOrgandIds()));
            }
        }

        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanKeyModelList);
    }

    @Override
    public Result updateMan(String futureTime) {
        keyRuleList=keyRuleDao.getAll();

        KeyUpdate.DOING=true;
        KeyUpdate.futureTime=futureTime;
        KeyUpdate.finish=false;
        keyUpdate.longPollingExecutor.execute(keyUpdate.updateRunner);

//        while (!KeyUpdate.finish){
//            System.out.println(KeyUpdate.finish.toString());
//        }
        if(futureTime!=null && !futureTime.equals("")){
            return new Result(true,"future");
        }else{
            return new Result(true,"now");
        }
    }

    @Override
    public Result autoUpdateMan(Boolean open) {
//        Result result;
        if(open){
            //开启
            keyRuleList=keyRuleDao.getAll();
            KeyAutoUpdate.OPEN_SWITCH=true;
            keyAutoUpdate.setCurrent(KeyAutoUpdate.REDIS_NULL_VALUE);
            keyAutoUpdate.setMax(KeyAutoUpdate.REDIS_NULL_VALUE);
            keyAutoUpdate.setExpiredTime(KeyAutoUpdate.REDIS_NULL_VALUE);
            keyAutoUpdate.longPollingExecutor.execute(keyAutoUpdate.updateRunner);
        }else{
            //关闭
            KeyAutoUpdate.OPEN_SWITCH=false;
        }
        return new Result(true);
    }


    @Override
    public void checkKeyStatus(Oldman oldman) {
        Boolean isKeyNow=false;
//        KeyUpdate.log.info(oldman.toString());
        if(oldman.getGoal()>= ValueConstant.OLDMAN_KEY_GOAL_BASE)
            isKeyNow=true;

        if(oldman.getKeyStatus()== KeyStatusEnum.NO.getIndex() || oldman.getKeyStatus()== KeyStatusEnum.DEL.getIndex()){
            if(isKeyNow){
                //上次不是 这次是
                oldman.setKeyStatus(KeyStatusEnum.ADD.getIndex());
            }else{
                //上次这次都不是
                oldman.setKeyStatus(KeyStatusEnum.NO.getIndex());
            }
        }else if(oldman.getKeyStatus()== KeyStatusEnum.YES.getIndex() || oldman.getKeyStatus()== KeyStatusEnum.ADD.getIndex()){
            if(isKeyNow){
                //上次这次都是
                oldman.setKeyStatus(KeyStatusEnum.YES.getIndex());
            }else{
                //上次是  这次不是
                oldman.setKeyStatus(KeyStatusEnum.DEL.getIndex());
            }
        }
//        KeyUpdate.log.info(oldman.toString());
    }

    @Override
    public int calculateKeyGoal(OldmanKey oldmanKey){
        int goal=0;//总分
        int goalHealth=0;// 健康状态的分数  最后如果有长护险的话 总分减去这个

        int flagAge=0,flagJTJG=0,flagJJTJ=0,flagLOU=0,flagJYLY=0;
        int flagCHX=0,flagSL=0,flagSZ=0;
        int flagSN=oldmanKey.getSnIds().size(),flagMB=oldmanKey.getMbIds().size();

        for (KeyRule keyRule:keyRuleList){
            if(keyRule.getType()== KeyRuleTypeEnum.NL.getIndex()){
                //年龄
                if(flagAge==0){
                    int start=Integer.parseInt(keyRule.getValueName().split("-")[0]);
                    int end=keyRule.getValueName().split("-").length==1? Integer.MAX_VALUE:Integer.parseInt(keyRule.getValueName().split("-")[1]);
                    if(oldmanKey.getAge()>=start && oldmanKey.getAge()<=end){
                        flagAge=1;
                        goal+=keyRule.getGoal();
                    }
                }
                continue;

            }
            if(keyRule.getType()== KeyRuleTypeEnum.JTJG.getIndex()){
                //家庭结构
                if(flagJTJG==0){
                    if(keyRule.getValueIndex()==oldmanKey.getFamilyIndex()){
                        flagJTJG=1;
                        goal+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.CHX.getIndex()){
                //长护险
                if(flagCHX==0){
                    if(keyRule.getValueIndex()==oldmanKey.getChxIndex()){
                        flagCHX=1;
                        goal+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.SN.getIndex()){
                //失能
                if(flagSN!=0 && flagCHX==0){
                    if(oldmanKey.getSnIds().contains(keyRule.getValueIndex())){
                        flagSN--;
                        goal+=keyRule.getGoal();
                        goalHealth+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.ZL.getIndex()){
                //失智
                if(flagSZ==0 && flagCHX==0){
                    if(oldmanKey.getIntelligence()==keyRule.getValueIndex()){
                        flagSZ=1;
                        goal+=keyRule.getGoal();
                        goalHealth+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.SL.getIndex()){
                //视力
                if(flagSL==0 && flagCHX==0){
                    if(oldmanKey.getEyesight()==keyRule.getValueIndex()){
                        flagSL=1;
                        goal+=keyRule.getGoal();
                        goalHealth+=keyRule.getGoal();
                    }
                }
                continue;
            }if(keyRule.getType()== KeyRuleTypeEnum.MB.getIndex()){
                //慢病
                if(flagMB!=0 && flagCHX==0){
                    if(oldmanKey.getMbIds().contains(keyRule.getValueIndex())){
                        flagMB--;
                        goal+=keyRule.getGoal();
                        goalHealth+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.JJTJ.getIndex()){
                //经济条件
                if(flagJJTJ==0){
                    if(keyRule.getValueIndex()==oldmanKey.getEconomicIndex()){
                        flagJJTJ=1;
                        goal+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.LOU.getIndex()){
                //无电梯楼层
                if(flagLOU==0){
                    if(keyRule.getValueIndex()==oldmanKey.getFloor()){
                        flagLOU=1;
                        goal+=keyRule.getGoal();
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.JYLY.getIndex()){
                //是否主动进养老院
                if(flagJYLY==0){
//                    System.out.println(oldmanKey.getOldmanId());
//                    System.out.println(oldmanKey.getIsActivityOrgan());
                    if(keyRule.getValueIndex()==oldmanKey.getIsActivityOrgan()){
                        flagJYLY=1;
                        goal+=keyRule.getGoal();
                    }
                }
                continue;
            }
        }
        if(flagCHX==1){
            goal-=goalHealth;
        }
        return goal;
    }


    @Override
    public KeyRulelModel getRule() {
        KeyRulelModel keyGoalModel=new KeyRulelModel();
        List<KeyRule> keyRuleList=keyRuleDao.getAllRule();
        List<KeyRuleTypeModel> keyRuleTypeModelList=oldmanKeyWrapper.wrapKeyRule(keyRuleList);
//        keyRuleList.stream().forEach(r->r.setTypeDesc(KeyRuleTypeEnum.getValue(r.getType())));
        keyGoalModel.setBaseGoal(ValueConstant.OLDMAN_KEY_GOAL_BASE);
        keyGoalModel.setKeyRuleTypeList(keyRuleTypeModelList);
        return keyGoalModel;
    }


    @Override
    public void updateRule(KeyRuleRequest keyRuleRequest) {
        ValueConstant.OLDMAN_KEY_GOAL_BASE=keyRuleRequest.getBaseGoal();
        List<KeyRule> keyRuleList=oldmanKeyWrapper.unwrapKeyRule(keyRuleRequest);
        keyRuleDao.updateByIds(keyRuleList);
    }


    @Override
    @Transactional
    public Result handle(OldmanhKeyHandleRequest oldmanhKeyHandleRequest) {
        OldmanKeyHandle oldmanKeyHandle= oldmanKeyWrapper.unwrapKeyHandle(oldmanhKeyHandleRequest);
        if(oldmanhKeyHandleRequest.getHandle().equals("add")) {
            oldmanKeyHandleDao.save(oldmanKeyHandle);
            oldmanDao.updateProp("is_handle", "1", oldmanhKeyHandleRequest.getOldmanId());
        }else if(oldmanhKeyHandleRequest.getHandle().equals("update")){
            oldmanKeyHandleDao.updateByOldmanId(oldmanKeyHandle);
        }else{
            //删除
            oldmanDao.updateProp("is_handle", "0", oldmanhKeyHandleRequest.getOldmanId());
            oldmanKeyHandleDao.delByOldmanId(oldmanhKeyHandleRequest.getOldmanId());
        }
        return new Result(true);
    }

    @Override
    public Result getHandleByOldmanId(int oldmanId) {
        return new Result(true,oldmanKeyWrapper.wrapHandle(oldmanKeyHandleDao.getByOldmanId(oldmanId)));
    }

    @Override
    @Transactional
    public Result handleDel(String[] oldmanIds) {
        oldmanKeyHandleDao.delByOldmanIds(oldmanIds);
        oldmanDao.updateProps("is_handle","0",oldmanIds);
        return new Result(true);
    }
}
