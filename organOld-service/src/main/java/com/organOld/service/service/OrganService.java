package com.organOld.service.service;

import com.organOld.service.contract.*;
import com.organOld.service.model.OrganModel;
import com.organOld.service.model.OrganRegInfoModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface OrganService {
    String getByPage(OrganRequest organRequest, BTableRequest bTableRequest);

    String getManByPage(BTableRequest bTableRequest, OrganOldmanRequest organOldmanManRequest);

    OrganModel getBySession(HttpSession httpSession);

    OrganModel getById(int organId);
    Result pass(int organId);

    OrganRegInfoModel getRegInfo();

    Result reg(OrganRegRequest organReg, HttpServletRequest request);

    Result reject(int id);
}
