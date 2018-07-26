package com.organOld.service.service.impl;

import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.record.Record;
import com.organOld.dao.repository.CardDao;
import com.organOld.dao.repository.OldmanDao;
import com.organOld.dao.repository.RecordDao;
import com.organOld.dao.util.Page;
import com.organOld.service.constant.ValueConstant;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.CardRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.enumModel.RecordTypeEnum;
import com.organOld.service.model.CardModel;
import com.organOld.service.model.OldmanAllInfoModel;
import com.organOld.service.service.CardService;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OldmanService;
import com.organOld.service.service.RecordService;
import com.organOld.service.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by netlab606 on 2018/6/25.
 */
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardDao cardDao;
    @Autowired
    CommonService commonService;
    @Autowired
    RecordDao recordDao;
    @Autowired
    OldmanService oldmanService;
    @Autowired
    RecordService recordService;
    @Autowired
    OldmanDao oldmanDao;


    @Override
    public String getByPage(CardRequest cardRequest, BTableRequest bTableRequest) {
        Page<Card> page=commonService.getPage(bTableRequest,"card");
        Card card= Wrappers.cardWrapper.unwrap(cardRequest);
        page.setEntity(card);
        List<CardModel> cardModelList=cardDao.getByPage(page).stream().map(Wrappers.cardWrapper::wrap).collect(Collectors.toList());
        Long size=cardDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,cardModelList);
    }

    @Override
    @Transactional
    public Result addMoney(String[] ids, Double money) {
        List<Record> recordList=new ArrayList<>();
        for(String id:ids){
            Card card=cardDao.getById(Integer.parseInt(id));
            Record record=new Record();
            record.setOldmanId(card.getOldmanId());
            record.setType(RecordTypeEnum.CQ.getIndex());
            record.setData(money+"");
            record.setPrevMoney(card.getMoney());
            record.setNowMoney(card.getMoney()+money);
            recordList.add(record);
        }
        cardDao.addMoney(ids,money);
        recordDao.saveAll(recordList);
        return new Result(true);
    }

    @Override
    public Result changeStatus(String[] ids, String status) {
        cardDao.updateProps("status",status,ids);
        return new Result(true);
    }

    @Override
    public Integer getIdByOldmanId(int oldmanId) {
        Card card=cardDao.getByOldmanId(oldmanId);
        if(card==null) return null;
        return card.getId();
    }

    @Override
    public OldmanAllInfoModel handleInfo(int cid, int organId) {
        Card card=cardDao.getByCid(cid);
        OldmanAllInfoModel oldmanAllInfoModel =oldmanService.getOldmanInfo(card.getOldmanId());

        Record record2=new Record();
        record2.setOldmanId(card.getOldmanId());
        record2.setType(RecordTypeEnum.INFO.getIndex());
        record2.setOrganId(organId);
        recordService.saveEntity(record2);
        return oldmanAllInfoModel;
    }

    @Override
    public Result handleIntegral(int cid, int organId) {
        Card card=cardDao.getByCid(cid);
        Result result = oldmanService.getIntegralByOldmanId(card.getOldmanId());
        Record record2=new Record();
        record2.setOldmanId(card.getOldmanId());
        record2.setType(RecordTypeEnum.IN.getIndex());
        record2.setOrganId(organId);
        recordService.saveEntity(record2);
        return result;
    }

    @Override
    @Transactional
    public Result handleSign(int cid, int organId) {
        Card card=cardDao.getByCid(cid);
        Oldman oldman=oldmanDao.getIntegralByOldmanId(card.getOldmanId());
        Record record2=new Record();
        record2.setOldmanId(card.getOldmanId());
        record2.setType(RecordTypeEnum.SIGN.getIndex());
        record2.setOrganId(organId);
        recordService.saveEntity(record2);
        //积分变动记录
        Record record=new Record();
        record.setType(RecordTypeEnum.JF.getIndex());
        record.setOrder("2");
        record.setOldmanId(card.getOldmanId());
        record.setData(ValueConstant.INTEGRAL_RULE_SIGN+"");
        record.setPrevMoney(Double.valueOf(oldman.getIntegral()));
        record.setNowMoney(Double.valueOf(oldman.getIntegral())+ValueConstant.INTEGRAL_RULE_SIGN);
        oldmanDao.addInregral(card.getOldmanId(),ValueConstant.INTEGRAL_RULE_SIGN);
        recordService.saveEntity(record);

        Result result=new Result(true,"签到成功");
        return result;
    }

    @Override
    public Result handleConsume(int cid, int organId, String order, String oldmanPassword, String m) {
        Double money=Double.parseDouble(m);
        Result check=checkCanConsume(cid,oldmanPassword,money);
        if(check.isSuccess()) {
            Card card = cardDao.getByCid(cid);
            Record record = new Record();
            record.setType(RecordTypeEnum.CONSUME.getIndex());
            record.setOrder(order);
            record.setOldmanId(card.getOldmanId());
            record.setData(money + "");
            record.setOrganId(organId);
            record.setPrevMoney(card.getMoney());
            record.setNowMoney(card.getMoney() - money);
            recordService.saveEntity(record);
            cardDao.updateProp("money",record.getNowMoney()+"",card.getId());
            Result result = new Result(true, "消费成功");
            return result;
        }else{
            Result result = new Result(false, "消费失败");
            return result;
        }
    }

    //TODO 老人密码验证
    private Result checkCanConsume(int cid, String oldmanPassword, Double money) {
        Card card=cardDao.getByCid(cid);
        if(card.getMoney()<money){
            return new Result(false,"消费失败，余额不足");
        }else{
            return new Result(true);
        }
    }
}
