package com.organOld.service.service;


import com.organOld.service.contract.*;

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

    String getOldmanByPage(OldmanRequest oldmanBaseRequest, BTableRequest bTableRequest);

    String getHealthByPage(OldmanHealthRequest oldmanHealthRequest, BTableRequest bTableRequest);

    String getLinkmanByPage(LinkmanRequest linkmanRequest, BTableRequest bTableRequest);

    String getEconomyByPage(OldmanEconomicRequest economicRequest, BTableRequest bTableRequest);

    String getFamilyByPage(OldmanFamilyRequest familyRequest, BTableRequest bTableRequest);

    String getOrganOldmanByPage(OrganOldmanRequest organOldmanRequest, BTableRequest bTableRequest);
}
