package com.organOld.service.service;

import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.OrganOldmanRequest;
import com.organOld.service.contract.OrganRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.model.OrganModel;

import javax.servlet.http.HttpSession;

public interface OrganService {
    String getByPage(OrganRequest organRequest, BTableRequest bTableRequest);

    String getManByPage(BTableRequest bTableRequest, OrganOldmanRequest organOldmanManRequest);

    OrganModel getBySession(HttpSession httpSession);

    OrganModel getById(int organId);
    Result pass(int organId);

}
