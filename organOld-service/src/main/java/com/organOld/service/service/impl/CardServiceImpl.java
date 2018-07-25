package com.organOld.service.service.impl;

import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.record.Record;
import com.organOld.dao.repository.CardDao;
import com.organOld.dao.repository.RecordDao;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.CardRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.enumModel.RecordTypeEnum;
import com.organOld.service.model.CardModel;
import com.organOld.service.service.CardService;
import com.organOld.service.service.CommonService;
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
}
