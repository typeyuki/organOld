package com.organOld.service.service.impl;

import com.organOld.dao.entity.oldman.*;
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


    @Override
    public String getOldmanByPage(OldmanRequest oldmanRequest, BTableRequest bTableRequest) {
        Page<Oldman> page=commonService.getPage(bTableRequest,"oldman_base");
        Oldman oldman= Wrappers.oldmanWrapper.unwrap(oldmanRequest);
        page.setEntity(oldman);
        List<OldmanModel> oldmanList=oldmanBaseDao.getByPage(page).stream().map(Wrappers.oldmanWrapper::wrap).collect(Collectors.toList());
        Long size=oldmanBaseDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanList);
    }

    @Override
    public String getHealthByPage(OldmanHealthRequest oldmanHealthRequest, BTableRequest bTableRequest) {
        Page<OldmanHealth> page=commonService.getPage(bTableRequest,"oldman_health");
        OldmanHealth oldmanHealth=Wrappers.oldmanHealthWrapper.unwrap(oldmanHealthRequest);
        page.setEntity(oldmanHealth);
        List<OldmanHealthModel> oldmanHealthModelList=oldmanHealthDao.getByPage(page).stream().map(Wrappers.oldmanHealthWrapper::wrap).collect(Collectors.toList());
        Long size=oldmanHealthDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanHealthModelList);
    }

    @Override
    public String getEconomyByPage(OldmanEconomicRequest economicRequest, BTableRequest bTableRequest) {
        Page<OldmanEconomic> page=commonService.getPage(bTableRequest,"oldman_economy");
        OldmanEconomic economic=Wrappers.economicWrapper.unwrap(economicRequest);
        page.setEntity(economic);
        List<OldmanEconomicModel> economicModelList=economicDao.getByPage(page).stream().map(Wrappers.economicWrapper::wrap).collect(Collectors.toList());
        Long size=economicDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,economicModelList);
    }

    @Override
    public String getFamilyByPage(OldmanFamilyRequest familyRequest, BTableRequest bTableRequest) {
        Page<OldmanFamily> page=commonService.getPage(bTableRequest,"oldman_family");
        OldmanFamily family=Wrappers.familyWrapper.unwrap(familyRequest);
        page.setEntity(family);
        List<OldmanFamilyModel> familyModelList=familyDao.getByPage(page).stream().map(Wrappers.familyWrapper::wrap).collect(Collectors.toList());
        Long size=familyDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,familyModelList);
    }

    @Override
    public String getOrganOldmanByPage(OrganOldmanRequest organOldmanRequest, BTableRequest bTableRequest) {
        Page<OrganOldman> page=commonService.getPage(bTableRequest,"oldman_organOldman");
        OrganOldman organOldman=Wrappers.organOldmanWrapper.unwrap(organOldmanRequest);
        page.setEntity(organOldman);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getByPage(page).stream().map(Wrappers.organOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=organOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public String getLinkmanByPage(LinkmanRequest linkmanRequest, BTableRequest bTableRequest) {
        Page<Linkman> page=commonService.getPage(bTableRequest,"oldman_linkman");
        Linkman linkman=Wrappers.linkmanWrapper.unwrap(linkmanRequest);
        page.setEntity(linkman);
        //mybatis 不支持一个对象里有多个list  也就是不能用多个collection 会有大量重复 只能分开查询，但是分开查询 又有很大的 传输延迟  当前解决办法就是 查一次 然后去重
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

}
