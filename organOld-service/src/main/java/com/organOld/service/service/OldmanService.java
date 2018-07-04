package com.organOld.service.service;


import com.organOld.service.contract.*;
import com.organOld.service.model.OldmanAddInfoModel;
import com.organOld.service.model.OldmanAllInfoModel;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by netlab606 on 2018/4/1.
 */
public interface OldmanService {

    void delById(int id);

    void save(OldmanAddRequest oldmanAddRequest);

    void updateOldman(OldmanRequest oldmanBaseRequest);

    void updateLinkman(LinkmanRequest linkmanBaseRequest);

    void updateEconomy(OldmanEconomicRequest economicRequest);

    void updateFamily(OldmanFamilyRequest familyRequest);

    void updateOrganOldman(OrganOldmanRequest organoldmanRequest);

    String getOldmanByPage(OldmanRequest oldmanBaseRequest, BTableRequest bTableRequest, HttpSession session);

    String getHealthByPage(OldmanHealthRequest oldmanHealthRequest, BTableRequest bTableRequest, HttpSession session);

    String getLinkmanByPage(LinkmanRequest linkmanRequest, BTableRequest bTableRequest, HttpSession session);

    String getEconomyByPage(OldmanEconomicRequest economicRequest, BTableRequest bTableRequest, HttpSession session);

    String getFamilyByPage(OldmanFamilyRequest familyRequest, BTableRequest bTableRequest, HttpSession session);

    String getOrganOldmanByPage(OrganOldmanRequest organOldmanRequest, BTableRequest bTableRequest, HttpSession session);

    OldmanAddInfoModel getAddInfo();

    String getHomeOldmanByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest, HttpSession session);

    OldmanAllInfoModel getOldmanInfo(int oldmanId);

    Result importExcel(MultipartFile file, HttpSession session) throws IOException;
}
