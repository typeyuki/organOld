package com.organOld.service.service;

import com.organOld.dao.entity.AutoValue;
import com.organOld.service.contract.AutoValueRequest;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.Result;

import java.util.List;

public interface AutoValueService {
    List<AutoValue> getByType(int index);

    String getByPage(AutoValueRequest autoValueRequest, BTableRequest bTableRequest);

    Result getById(int id);

    void handle(String type, AutoValue autoValue);
}
