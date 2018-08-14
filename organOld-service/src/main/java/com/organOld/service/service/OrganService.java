package com.organOld.service.service;

import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.entity.organ.OrganType;
import com.organOld.service.contract.*;
import com.organOld.service.model.OrganAddModel;
import com.organOld.service.model.OrganModel;
import com.organOld.service.model.OrganRegInfoModel;
import com.organOld.service.contract.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public interface OrganService {
    String getByPage(OrganRequest organRequest, BTableRequest bTableRequest);

    String getManByPage(BTableRequest bTableRequest, OrganOldmanRequest organOldmanManRequest);

    OrganModel getBySession(HttpSession httpSession);

    OrganModel getById(int id);
    Result pass(int organId);

    OrganRegInfoModel getRegInfo();

    Result reg(OrganRegRequest organReg, HttpServletRequest request);

    Result reject(int id);

    Result getRoleOrgan(int type, int typeIndex);

    List<OrganType> getAllOldmanType();

    Result importExcel(MultipartFile file, int type, HttpServletRequest request) throws IOException;

    Result importManExcel(MultipartFile file) throws IOException;

    Integer addOrUpdate(OrganRegRequest organRegRequest, HttpServletRequest request, String type);

    void cancel(int organId);

    List<OrganType> getByFirType(int firType);

    OrganAddModel getAddInfo(int firType);

    Boolean checkHaveAuthByAuthType(int type, Integer organId);

    List<Organ> getByOrganFirType(int firType);

    String getRecordByPage(OrganServiceRecordRequest organServiceRecordRequest, BTableRequest bTableRequest);

    Result importRecordExcel(MultipartFile file) throws IOException;

    void delByIds(String[] ids);

    List<Organ> getAll();

    List<Organ> getByType(int type);

    void addOldman(OrganOldman organOldman);

    OrganOldman getOldmanById(Integer oldmanId);

    void updateOldman(OrganOldman organOldman);

    void delByOldmanIds(String[] ids);

    Integer getIdByName(String name);


    List<Organ> getALLNotInFirType(int firType);
}
