package com.organOld.service.wrapper;

import com.organOld.dao.entity.record.Record;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.CardRecordRequest;
import com.organOld.service.contract.RecordRequest;
import com.organOld.service.enumModel.RecordTypeEnum;
import com.organOld.service.model.RecordModel;
import com.organOld.service.util.Tool;
import org.springframework.beans.BeanUtils;

public class RecordWrapper implements Wrapper<Record,RecordModel,RecordRequest> {


    @Override
    public RecordModel wrap(Record record) {
        RecordModel recordModel=new RecordModel();
        recordModel.setId(record.getId());
        recordModel.setData(record.getData());
        recordModel.setOldman(record.getOldman());
        recordModel.setTime(Tool.dateToString(record.getTime(), TimeConstant.DATA_FORMAT_YMDHMS));
        recordModel.setOrgan(record.getOrgan());
        recordModel.setType(RecordTypeEnum.getValue(record.getType()));
        recordModel.setOrder(record.getOrder());
        if(record.getPrevMoney()!=null)
        recordModel.setMoneyChange(record.getPrevMoney()+"--->"+record.getNowMoney());
        return recordModel;
    }

    @Override
    public Record unwrap(RecordRequest recordRequest) {
        Record record=new Record();
        BeanUtils.copyProperties(recordRequest,record);
        return record;
    }

    public Record unwrapCard(CardRecordRequest cardRecordRequest) {
        Record record=new Record();
        record.setCardId(cardRecordRequest.getId());
        record.setStart(Tool.stringToDate(cardRecordRequest.getStart()));
        record.setEnd(Tool.stringToDate(cardRecordRequest.getEnd()));
        record.setType(cardRecordRequest.getType());
        return record;
    }
}
