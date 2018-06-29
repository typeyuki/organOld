package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.*;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.service.model.*;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OldmanService;
import com.organOld.service.wrapper.Wrappers;
import com.organOld.service.contract.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by netlab606 on 2018/4/1.
 */
@Service
public class OldmanServiceImpl implements OldmanService {

    @Autowired
    OldmanDao oldmanBaseDao;
    @Autowired
    OldmanHealthDao oldmanHealthDao;
    @Autowired
    LinkmanDao linkmanDao;
    @Autowired
    OldmanEconomicDao economicDao;
    @Autowired
    OldmanFamilyDao familyDao;
    @Autowired
    OrganOldmanDao organOldmanDao;
    @Autowired
    CommonService commonService;
    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    OrganDao organDao;
    @Autowired
    HomeOldmanDao homeOldmanDao;
    @Autowired
    OldmanKeyDao oldmanKeyDao;


    @Override
    public String getOldmanByPage(OldmanRequest oldmanRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<Oldman> page=commonService.getPage(bTableRequest,"oldman_base");
        Oldman oldman= Wrappers.oldmanWrapper.unwrap(oldmanRequest);
        commonService.checkIsJw(session,oldman);
        page.setEntity(oldman);
        List<OldmanModel> oldmanList=oldmanBaseDao.getByPage(page).stream().map(Wrappers.oldmanWrapper::wrap).collect(Collectors.toList());
        Long size=oldmanBaseDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanList);
    }


    @Override
    public String getHealthByPage(OldmanHealthRequest oldmanHealthRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<OldmanHealth> page=commonService.getPage(bTableRequest,"oldman_health");
        OldmanHealth oldmanHealth=Wrappers.oldmanHealthWrapper.unwrap(oldmanHealthRequest);
        commonService.checkIsJw(session,oldmanHealth);
        page.setEntity(oldmanHealth);
        List<OldmanHealthModel> oldmanHealthModelList=oldmanHealthDao.getByPage(page).stream().map(Wrappers.oldmanHealthWrapper::wrap).collect(Collectors.toList());
        Long size=oldmanHealthDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanHealthModelList);
    }

    @Override
    public String getEconomyByPage(OldmanEconomicRequest economicRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<OldmanEconomic> page=commonService.getPage(bTableRequest,"oldman_economy");
        OldmanEconomic economic=Wrappers.economicWrapper.unwrap(economicRequest);
        commonService.checkIsJw(session,economic);
        page.setEntity(economic);
        List<OldmanEconomicModel> economicModelList=economicDao.getByPage(page).stream().map(Wrappers.economicWrapper::wrap).collect(Collectors.toList());
        Long size=economicDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,economicModelList);
    }

    @Override
    public String getFamilyByPage(OldmanFamilyRequest familyRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<OldmanFamily> page=commonService.getPage(bTableRequest,"oldman_family");
        OldmanFamily family=Wrappers.familyWrapper.unwrap(familyRequest);
        commonService.checkIsJw(session,family);
        page.setEntity(family);
        List<OldmanFamilyModel> familyModelList=familyDao.getByPage(page).stream().map(Wrappers.familyWrapper::wrap).collect(Collectors.toList());
        Long size=familyDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,familyModelList);
    }

    @Override
    public String getOrganOldmanByPage(OrganOldmanRequest organOldmanRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<OrganOldman> page=commonService.getPage(bTableRequest,"oldman_organOldman");
        OrganOldman organOldman=Wrappers.organOldmanWrapper.unwrap(organOldmanRequest);
        commonService.checkIsJw(session,organOldman);
        page.setEntity(organOldman);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getByPage(page).stream().map(Wrappers.organOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=organOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public String getLinkmanByPage(LinkmanRequest linkmanRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<Linkman> page=commonService.getPage(bTableRequest,"oldman_linkman");
        Linkman linkman=Wrappers.linkmanWrapper.unwrap(linkmanRequest);
        commonService.checkIsJw(session,linkman);
        page.setEntity(linkman);
        List<LinkmanModel> linkmanModelList=linkmanDao.getByPage(page).stream().map(Wrappers.linkmanWrapper::wrap).collect(Collectors.toList());
        Long size=linkmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,linkmanModelList);
    }



    @Override
    @Transactional
    public void delById(int id) {
        //TODO 删除老人的其他信息
        linkmanDao.delByOid(id);
        oldmanBaseDao.delById(id);
    }


    //TODO
    @Override
    @Transactional
    public void save(OldmanAddRequest oldmanAddRequest) {
//        oldmanBaseDao.save(oldmanAddRequest.getOldman());
//        Linkman linkman=oldmanAddRequest.getLinkman();
//        linkman.setOldmanId(oldmanAddRequest.getOldman().getId());
//        linkmanDao.save(linkman);
//        OldmanHealth oldmanHealth=oldmanAddRequest.getOldmanHealth();
//        oldmanHealth.setOldmanId(oldmanAddRequest.getOldman().getId());
//        oldmanHealthDao.save(oldmanAddRequest.getOldmanHealth());
    }


    @Override
    public void updateOldman(OldmanRequest oldmanBaseRequest) {
        Oldman oldman= Wrappers.oldmanWrapper.unwrap(oldmanBaseRequest);
        oldmanBaseDao.updateById(oldman);
    }

    @Override
    public void updateLinkman(LinkmanRequest linkmanRequest) {
        Linkman linkman= Wrappers.linkmanWrapper.unwrap(linkmanRequest);
        linkmanDao.updateById(linkman);
    }

    @Override
    public void updateFamily(OldmanFamilyRequest familyRequest) {
        OldmanFamily family= Wrappers.familyWrapper.unwrap(familyRequest);
        familyDao.updateById(family);
    }

    @Override
    public void updateEconomy(OldmanEconomicRequest economicRequest) {
        OldmanEconomic economic= Wrappers.economicWrapper.unwrap(economicRequest);
        economicDao.updateById(economic);
    }

    @Override
    public void updateOrganOldman(OrganOldmanRequest organOldmanRequest) {
        OrganOldman organOldman= Wrappers.organOldmanWrapper.unwrap(organOldmanRequest);
        organOldmanDao.updateById(organOldman);
    }


    @Override
    public OldmanAddInfoModel getAddInfo() {
        List<Integer> typeList=commonService.getAutoValueTypes("oldman_add");
        List<AutoValue> autoValueList=autoValueDao.getByTypeList(typeList);
        List<Organ> jwList=organDao.getSimpleByType(2);
        List<HealthSelect> healthSelectList=oldmanHealthDao.getAllHealthSelect();
        OldmanAddInfoModel oldmanAddInfoModel=Wrappers.oldmanWrapper.wrapAddInfo(autoValueList,jwList,healthSelectList);
        return oldmanAddInfoModel;
    }


    @Override
    public String getHomeOldmanByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<HomeOldman> page=commonService.getPage(bTableRequest,"oldman_homeOldman");
        HomeOldman homeOldman=Wrappers.homeOldmanWrapper.unwrap(homeOldmanRequest);
        commonService.checkIsJw(session,homeOldman);
        page.setEntity(homeOldman);
        List<HomeOldmanModel> organOldmanModelList=homeOldmanDao.getByPage(page).stream().map(Wrappers.homeOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=homeOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public OldmanAllInfoModel getOldmanInfo(int oldmanId) {
        OldmanAllInfoModel oldmanAllInfoModel=new OldmanAllInfoModel();
        Page<DBEntity> page=new Page<>();
        page.setStart(0);
        page.setLength(999);
        page.setSort("asc");

        Oldman oldman=new Oldman();
        oldman.setId(oldmanId);

        page.setEntity(oldman);
        List<OldmanModel> oldmanModelList=oldmanBaseDao.getByPage(page).stream().map(Wrappers.oldmanWrapper::wrap).collect(Collectors.toList());
        oldmanAllInfoModel.setOldman(oldmanModelList.get(0));

        List<Oldman> oldmanList=oldmanKeyDao.getByPage(page);
        oldmanAllInfoModel.setKey(oldmanList.get(0));

        OldmanHealth oldmanHealth=new OldmanHealth();
        oldmanHealth.setOldman(oldman);
        page.setEntity(oldmanHealth);
        List<OldmanHealthModel> oldmanHealthModelList=oldmanHealthDao.getByPage(page).stream().map(Wrappers.oldmanHealthWrapper::wrap).collect(Collectors.toList());
        oldmanAllInfoModel.setHealth(oldmanHealthModelList.get(0));

        OldmanFamily oldmanFamily=new OldmanFamily();
        oldmanFamily.setOldman(oldman);
        page.setEntity(oldmanFamily);
        List<OldmanFamilyModel> familyModelList=familyDao.getByPage(page).stream().map(Wrappers.familyWrapper::wrap).collect(Collectors.toList());
        oldmanAllInfoModel.setFamily(familyModelList.get(0).getFamily());

        OldmanEconomic oldmanEconomic=new OldmanEconomic();
        oldmanEconomic.setOldman(oldman);
        page.setEntity(oldmanEconomic);
        List<OldmanEconomicModel> economicModelList=economicDao.getByPage(page).stream().map(Wrappers.economicWrapper::wrap).collect(Collectors.toList());
        oldmanAllInfoModel.setEconomic(economicModelList.get(0).getEconomic());

        Linkman linkman=new Linkman();
        linkman.setOldman(oldman);
        page.setEntity(linkman);
        List<LinkmanModel> linkmanModelList=linkmanDao.getByPage(page).stream().map(Wrappers.linkmanWrapper::wrap).collect(Collectors.toList());
        oldmanAllInfoModel.setLinkman(linkmanModelList.get(0));

        OrganOldman organOldman=new OrganOldman();
//        organ.setOrganFirTypeId(21);
//        organ.setOldmanId(oldmanId);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getByPage(page).stream().map(Wrappers.organOldmanWrapper::wrap).collect(Collectors.toList());

        return null;
    }
}
