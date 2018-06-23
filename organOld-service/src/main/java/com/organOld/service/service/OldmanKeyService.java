package com.organOld.service.service;

import com.organOld.dao.entity.oldman.KeyRule;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanKey;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.OldmanKeyRequest;
import com.organOld.service.contract.OldmanRequest;
import com.organOld.service.contract.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OldmanKeyService {
    String getByPage(BTableRequest bTableRequest, HttpSession session, OldmanKeyRequest oldmanKeyRequest);

    Result updateMan();
    void updateKey(List<OldmanKey> oldmanKeys);

    int calculateKeyGoal(OldmanKey oldmanKey);

    void checkKeyStatus(Oldman oldman);
}
