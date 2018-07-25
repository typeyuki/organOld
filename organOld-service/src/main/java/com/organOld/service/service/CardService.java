package com.organOld.service.service;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.CardRequest;
import com.organOld.service.contract.Result;

/**
 * Created by netlab606 on 2018/6/25.
 */
public interface CardService {
    String getByPage(CardRequest cardRequest, BTableRequest bTableRequest);

    Result addMoney(String[] ids, Double money);

    Result changeStatus(String[] ids, String status);

    int getIdByOldmanId(int oldmanId);
}
