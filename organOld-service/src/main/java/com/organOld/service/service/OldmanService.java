package com.organOld.service.service;


import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.oldman.HealthSelect;
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


    String getOldmanByPage(OldmanRequest oldmanBaseRequest, BTableRequest bTableRequest);

    String getHealthByPage(OldmanHealthRequest oldmanHealthRequest, BTableRequest bTableRequest);

    String getLinkmanByPage(LinkmanRequest linkmanRequest, BTableRequest bTableRequest);

    String getEconomyByPage(OldmanEconomicRequest economicRequest, BTableRequest bTableRequest);

    String getFamilyByPage(OldmanFamilyRequest familyRequest, BTableRequest bTableRequest);

    String getOrganOldmanByPage(OrganOldmanRequest organOldmanRequest, BTableRequest bTableRequest);

    OldmanAddInfoModel getAddInfo();

    String getHomeOldmanByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest);

    OldmanAllInfoModel getOldmanInfo(int oldmanId);

    Result importExcel(MultipartFile file, HttpSession session) throws IOException;

    Result getIntegralByOldmanId(int oldmanId);

    String getHealthSelectByPage(HealthSelectRequest healthSelectRequest, BTableRequest bTableRequest);

    void addOrUpdateHealthSelect(HealthSelect healthSelect, String type);

    String getIntegralByPage(OldmanIntegralRequest oldmanIntegralRequest, BTableRequest bTableRequest);

    Result getById(int id, String type);

    Result updateById(DBEntity dbEntity, String base);

    void delByIds(String[] ids);

    void delHealthSelectByIds(String[] ids);

    Result getIntegralRule();

    void updateIntegral(int sign, int consume);
}
