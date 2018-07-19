package com.organOld.service.service;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanKey;
import com.organOld.service.contract.*;
import com.organOld.service.model.KeyRulelModel;

import javax.servlet.http.HttpSession;

public interface OldmanKeyService {
    String getByPage(BTableRequest bTableRequest, HttpSession session, OldmanKeyRequest oldmanKeyRequest);

    Result updateMan(String futureTime);
//    void updateKey(List<OldmanKey> oldmanKeys);

    int calculateKeyGoal(OldmanKey oldmanKey);

    void checkKeyStatus(Oldman oldman);

    Result autoUpdateMan(Boolean open);

    KeyRulelModel getRule();

    void updateRule(KeyRuleRequest keyRuleRequest);

    Result handle(OldmanhKeyHandleRequest oldmanhKeyHandleRequest);

    Result getHandleByOldmanId(int oldmanId);

    Result handleDel(String[] oldmanIds);
}
