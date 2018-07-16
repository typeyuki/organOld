package com.organOld.service.service;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.RecordRequest;

public interface RecordService {
    String getByPage(RecordRequest recordRequest, BTableRequest bTableRequest);

    void save(int oldmanId, int organId, int index);
}
