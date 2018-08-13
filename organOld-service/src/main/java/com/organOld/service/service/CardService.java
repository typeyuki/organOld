package com.organOld.service.service;

import com.organOld.dao.entity.Card;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.CardRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.model.OldmanAllInfoModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by netlab606 on 2018/6/25.
 */
public interface CardService {
    String getByPage(CardRequest cardRequest, BTableRequest bTableRequest);

    Result addMoney(String[] ids, Double money);

    Result changeStatus(String[] ids, String status);

    Integer getIdByOldmanId(int oldmanId);

    OldmanAllInfoModel handleInfo(int cid, int organId);

    Result handleIntegral(int cid, int organId);

    Result handleSign(int cid, int organId);

    Result handleConsume(int cid, int organId, String order, String oldmanPassword, String money);


    Result getById(Integer id);

    void updateById(Card card);

    void createZip(String[] ids, HttpServletResponse response, HttpServletRequest request);
}
