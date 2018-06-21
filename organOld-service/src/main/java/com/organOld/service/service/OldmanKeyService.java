package com.organOld.service.service;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.OldmanKeyRequest;
import com.organOld.service.contract.OldmanRequest;
import com.organOld.service.contract.Result;

import javax.servlet.http.HttpSession;

public interface OldmanKeyService {
    String getByPage(BTableRequest bTableRequest, HttpSession session, OldmanKeyRequest oldmanKeyRequest);

    Result updateMan();
}
