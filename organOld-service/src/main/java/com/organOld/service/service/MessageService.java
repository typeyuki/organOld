package com.organOld.service.service;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.MessageRequest;
import com.organOld.service.contract.Result;

public interface MessageService {
    String getByPage(MessageRequest messageRequest, BTableRequest bTableRequest);

    Result read();

    int getNoReadNum();

    void delByIds(String[] ids);
}
