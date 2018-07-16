package com.organOld.service.wrapper;

import com.organOld.dao.entity.record.Record;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.contract.RecordRequest;
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
        return recordModel;
    }

    @Override
    public Record unwrap(RecordRequest recordRequest) {
        Record record=new Record();
        BeanUtils.copyProperties(recordRequest,record);
        return record;
    }
}
