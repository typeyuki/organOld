package com.organOld.service.service;

import com.organOld.dao.entity.organ.OrganType;
import com.organOld.service.contract.*;
import com.organOld.service.model.OrganModel;
import com.organOld.service.model.OrganRegInfoModel;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public interface OrganService {
    String getByPage(OrganRequest organRequest, BTableRequest bTableRequest);

    String getManByPage(BTableRequest bTableRequest, OrganOldmanRequest organOldmanManRequest);

    OrganModel getBySession(HttpSession httpSession);

    OrganModel getById(int organId);
    Result pass(int organId);

    OrganRegInfoModel getRegInfo();

    Result reg(OrganRegRequest organReg, HttpServletRequest request);

    Result reject(int id);

    Result getRoleOrgan(int type, int typeIndex);

    List<OrganType> getAllOldmanType();

    Result importExcel(MultipartFile file, int type, HttpServletRequest request) throws IOException;

    Result importManExcel(MultipartFile file) throws IOException;
}
