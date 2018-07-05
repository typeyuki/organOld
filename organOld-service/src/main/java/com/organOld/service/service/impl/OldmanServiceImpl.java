package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.*;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.entity.volunteer.Volunteer;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.service.enumModel.AutoValueEnum;
import com.organOld.service.enumModel.HealthEnum;
import com.organOld.service.model.*;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OldmanService;
import com.organOld.service.util.Tool;
import com.organOld.service.wrapper.Wrappers;
import com.organOld.service.contract.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
    @Autowired
    LabelDao labelDao;
    @Autowired
    OldmanFamilyDao oldmanFamilyDao;
    @Autowired
    OldmanEconomicDao oldmanEconomicDao;
    @Autowired
    HealthAddDao healthAddDao;
    @Autowired
    HealthSelectManDao healthSelectManDao;
    @Autowired
    VolunteerDao volunteerDao;

    @Override
    public String getOldmanByPage(OldmanRequest oldmanRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<Oldman> page=commonService.getPage(bTableRequest,"oldman_base");
        Oldman oldman= Wrappers.oldmanWrapper.unwrap(oldmanRequest);
        commonService.checkIsOrgan(session,oldman);
        page.setEntity(oldman);
        List<OldmanModel> oldmanList=oldmanBaseDao.getByPage(page).stream().map(Wrappers.oldmanWrapper::wrap).collect(Collectors.toList());
        Long size=oldmanBaseDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanList);
    }


    @Override
    public String getHealthByPage(OldmanHealthRequest oldmanHealthRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<OldmanHealth> page=commonService.getPage(bTableRequest,"oldman_health");
        OldmanHealth oldmanHealth=Wrappers.oldmanHealthWrapper.unwrap(oldmanHealthRequest);
        commonService.checkIsOrgan(session,oldmanHealth);
        page.setEntity(oldmanHealth);
        List<OldmanHealthModel> oldmanHealthModelList=oldmanHealthDao.getByPage(page).stream().map(Wrappers.oldmanHealthWrapper::wrap).collect(Collectors.toList());
        Long size=oldmanHealthDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanHealthModelList);
    }

    @Override
    public String getEconomyByPage(OldmanEconomicRequest economicRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<OldmanEconomic> page=commonService.getPage(bTableRequest,"oldman_economy");
        OldmanEconomic economic=Wrappers.economicWrapper.unwrap(economicRequest);
        commonService.checkIsOrgan(session,economic);
        page.setEntity(economic);
        List<OldmanEconomicModel> economicModelList=economicDao.getByPage(page).stream().map(Wrappers.economicWrapper::wrap).collect(Collectors.toList());
        Long size=economicDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,economicModelList);
    }

    @Override
    public String getFamilyByPage(OldmanFamilyRequest familyRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<OldmanFamily> page=commonService.getPage(bTableRequest,"oldman_family");
        OldmanFamily family=Wrappers.familyWrapper.unwrap(familyRequest);
        commonService.checkIsOrgan(session,family);
        page.setEntity(family);
        List<OldmanFamilyModel> familyModelList=familyDao.getByPage(page).stream().map(Wrappers.familyWrapper::wrap).collect(Collectors.toList());
        Long size=familyDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,familyModelList);
    }

    @Override
    public String getOrganOldmanByPage(OrganOldmanRequest organOldmanRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<OrganOldman> page=commonService.getPage(bTableRequest,"oldman_organOldman");
        OrganOldman organOldman=Wrappers.organOldmanWrapper.unwrap(organOldmanRequest);
        commonService.checkIsOrgan(session,organOldman);
        page.setEntity(organOldman);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getByPage(page).stream().map(Wrappers.organOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=organOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public String getLinkmanByPage(LinkmanRequest linkmanRequest, BTableRequest bTableRequest, HttpSession session) {
        Page<Linkman> page=commonService.getPage(bTableRequest,"oldman_linkman");
        Linkman linkman=Wrappers.linkmanWrapper.unwrap(linkmanRequest);
        commonService.checkIsOrgan(session,linkman);
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
        commonService.checkIsOrgan(session,homeOldman);
        page.setEntity(homeOldman);
        List<HomeOldmanModel> organOldmanModelList=homeOldmanDao.getByPage(page).stream().map(Wrappers.homeOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=homeOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public OldmanAllInfoModel getOldmanInfo(int oldmanId) {
        OldmanAllInfoModel oldmanAllInfoModel=new OldmanAllInfoModel();
        Page<DBEntity> page=new Page<>();
        page.setSortType("id");
        page.setSort("asc");

        Oldman oldman=new Oldman();
        oldman.setId(oldmanId);

        page.setEntity(oldman);
        List<OldmanModel> oldmanModelList=oldmanBaseDao.getByPage(page).stream().map(Wrappers.oldmanWrapper::wrap).collect(Collectors.toList());
        if(oldmanModelList!=null && oldmanModelList.size()>0)
            oldmanAllInfoModel.setOldman(oldmanModelList.get(0));

        List<Oldman> oldmanList=oldmanKeyDao.getByPage(page);
        if(oldmanList!=null && oldmanList.size()>0)
            oldmanAllInfoModel.setKey(oldmanList.get(0));

        OldmanHealth oldmanHealth=new OldmanHealth();
        oldmanHealth.setOldman(oldman);
        page.setEntity(oldmanHealth);
        List<OldmanHealthModel> oldmanHealthModelList=oldmanHealthDao.getByPage(page).stream().map(Wrappers.oldmanHealthWrapper::wrap).collect(Collectors.toList());
        if(oldmanHealthModelList!=null && oldmanHealthModelList.size()>0)
            oldmanAllInfoModel.setHealth(oldmanHealthModelList.get(0));

        OldmanFamily oldmanFamily=new OldmanFamily();
        oldmanFamily.setOldman(oldman);
        page.setEntity(oldmanFamily);
        List<OldmanFamilyModel> familyModelList=familyDao.getByPage(page).stream().map(Wrappers.familyWrapper::wrap).collect(Collectors.toList());
        if(familyModelList!=null && familyModelList.size()>0)
            oldmanAllInfoModel.setFamily(familyModelList.get(0).getFamily());

        OldmanEconomic oldmanEconomic=new OldmanEconomic();
        oldmanEconomic.setOldman(oldman);
        page.setEntity(oldmanEconomic);
        List<OldmanEconomicModel> economicModelList=economicDao.getByPage(page).stream().map(Wrappers.economicWrapper::wrap).collect(Collectors.toList());
        if(economicModelList!=null && economicModelList.size()>0)
            oldmanAllInfoModel.setEconomic(economicModelList.get(0).getEconomic());

        Linkman linkman=new Linkman();
        linkman.setOldman(oldman);
        page.setEntity(linkman);
        List<LinkmanModel> linkmanModelList=linkmanDao.getByPage(page).stream().map(Wrappers.linkmanWrapper::wrap).collect(Collectors.toList());
        if(linkmanModelList!=null && linkmanModelList.size()>0)
            oldmanAllInfoModel.setLinkman(linkmanModelList.get(0));

        OrganOldman organOldman=new OrganOldman();
        organOldman.setFirType(21);
        organOldman.setOldman(oldman);
        page.setEntity(organOldman);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getByPage(page).stream().map(Wrappers.organOldmanWrapper::wrap).collect(Collectors.toList());
        if(organOldmanModelList!=null && organOldmanModelList.size()>0)
            oldmanAllInfoModel.setOrgan(organOldmanModelList.get(0));

        OrganOldman communityOldman=new OrganOldman();
        communityOldman.setFirType(22);
        communityOldman.setOldman(oldman);
        page.setEntity(communityOldman);
        List<OrganOldmanModel> communityOldmanModelList=organOldmanDao.getByPage(page).stream().map(Wrappers.organOldmanWrapper::wrap).collect(Collectors.toList());
        oldmanAllInfoModel.setCommunity(communityOldmanModelList);

        HomeOldman homeOldman=new HomeOldman();
        homeOldman.setOldman(oldman);
        page.setEntity(homeOldman);
        List<HomeOldmanModel> homeOldmanModelList=homeOldmanDao.getByPage(page).stream().map(Wrappers.homeOldmanWrapper::wrap).collect(Collectors.toList());
        oldmanAllInfoModel.setHome(homeOldmanModelList);

        return oldmanAllInfoModel;
    }


    @Override
    @Transactional
    public Result importExcel(MultipartFile file, HttpSession session) throws IOException {

        Oldman o=new Oldman();
        commonService.checkIsOrgan(session,o);
        Integer organId=o.getOrganId();

        //导入规则  已有的则进行更新 没有的今天添加   数据库有的 表没有的  则“删除” 设置老人状态为不可用
        List<Integer> existOldmanIds=new ArrayList<>();//存储 本次更新 中已存在的老人ID 用于得到需要“删除”的老人ID


        //批量插入  HealthSelect只进行批量插入 在这之前将已有信息删除 由于恶性肿瘤史、骨折史 等 每次都只写当次更新的内容 历史不用写进来  所以直接进行批量更新
        List<OldmanEconomic> economicList_add=new ArrayList<>();
        List<OldmanFamily> familyList_add=new ArrayList<>();
        List<Linkman> linkmanList_add=new ArrayList<>();
        List<OldmanHealth> healthList_add=new ArrayList<>();
        List<HealthSelectMan> healthSelectManList_add=new ArrayList<>();
        List<HealthAdd> healthAddList_add=new ArrayList<>();
        List<Volunteer> volunteerList=new ArrayList<>();

        //批量更新
        List<OldmanEconomic> economicList_update=new ArrayList<>();
        List<OldmanFamily> familyList_update=new ArrayList<>();
        List<Linkman> linkmanList_update=new ArrayList<>();
        List<OldmanHealth> healthList_update=new ArrayList<>();
        List<Oldman> oldmanList_update=new ArrayList<>();//对已存在的老人进行批量更新


        List temp = new ArrayList();
        Workbook wb0 = new HSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);

        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int successUpdate=0;//导入数量中  更新的个数
        int successAdd=0;//导入数量中  更新的个数
        int successDel=0;//删除的个数
        excelReturnModel.setTotal(sht0.getLastRowNum()-1);//一共



        //对Sheet中的每一行进行迭代
        for (Row r : sht0) {
            try {
                if (r.getRowNum() >= 2) {
                    //遍历 cell  将单元格 格式 全都转换成String 类型
                    Iterator<Cell> cells = r.cellIterator();    //获得第一行的迭代器
                    while (cells.hasNext()) {
                        Cell cell = cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }


                    //创建实体类
                    Oldman oldman = new Oldman();
                    oldman.setName(r.getCell(3).getStringCellValue());
                    oldman.setSex((r.getCell(4).getStringCellValue().equals("男")) ? 2 : 1);
                    oldman.setBirthday(Tool.stringToDate((r.getCell(5).getStringCellValue())));
                    oldman.setPid(r.getCell(6).getStringCellValue());
                    oldman.setAddress(r.getCell(7).getStringCellValue());

                    oldman.setPhone(r.getCell(8).getStringCellValue());


                    //TODO  先按 居委的
                    if(r.getCell(2).getStringCellValue()!=null && !r.getCell(2).getStringCellValue().equals(""))
                        oldman.setXqId(autoValueDao.getStringLikeIndex(r.getCell(2).getStringCellValue(), AutoValueEnum.XQ.getIndex(), "like"));

//                    String politicalStatus = r.getCell(9).getStringCellValue().equals("") ? "群众" : r.getCell(9).getStringCellValue();
                    if(r.getCell(9).getStringCellValue()!=null && !r.getCell(9).getStringCellValue().equals(""))
                        oldman.setPoliticalStatus(autoValueDao.getStringLikeIndex(r.getCell(9).getStringCellValue(), AutoValueEnum.ZZMM.getIndex(), "like")+"");

                    if (r.getCell(11).getStringCellValue().equals("1")) {
                        Integer hjIndex = autoValueDao.getStringLikeIndex("户籍", AutoValueEnum.HJ.getIndex(), "equals");
                        oldman.setCensus(hjIndex + "");
                    } else if (r.getCell(12).getStringCellValue().equals("1")) {
                        Integer hjIndex = autoValueDao.getStringLikeIndex("非户籍", AutoValueEnum.HJ.getIndex(), "equals");
                        oldman.setCensus(hjIndex + "");
                    } else if (r.getCell(13).getStringCellValue().equals("1")) {
                        Integer hjIndex = autoValueDao.getStringLikeIndex("人户分离", AutoValueEnum.HJ.getIndex(), "equals");
                        oldman.setCensus(hjIndex + "");
                    }



                    Linkman linkman = new Linkman();
                    linkman.setName(r.getCell(25).getStringCellValue());
                    linkman.setRelation(r.getCell(26).getStringCellValue());
                    linkman.setPhone(r.getCell(27).getStringCellValue());


                    //is  字段中的  healthadd 只有在 insert时进行添加  update不改变
                    OldmanHealth health = new OldmanHealth();
                    health.setBloodType(r.getCell(10).getStringCellValue());
//                    health.setIntelligence("");
//                    health.setEyesight("");

                    if (r.getCell(55).getStringCellValue().equals("1")) {
                        Integer IndexSZ = autoValueDao.getStringLikeIndex("痴呆", AutoValueEnum.SZ.getIndex(), "like");
                        health.setIntelligence(IndexSZ + "");
                    }
                    if (r.getCell(56).getStringCellValue().equals("1")) {
                        Integer IndexSZ = autoValueDao.getStringLikeIndex("智障", AutoValueEnum.SZ.getIndex(), "like");
                        health.setIntelligence(IndexSZ + "");
                    }
                    if (r.getCell(57).getStringCellValue().equals("1")) {
                        Integer IndexSZ = autoValueDao.getStringLikeIndex("正常", AutoValueEnum.SZ.getIndex(), "like");
                        health.setIntelligence(IndexSZ + "");
                    }

                    if (r.getCell(58).getStringCellValue().equals("1")) {
                        Integer IndexSZ = autoValueDao.getStringLikeIndex("失明", AutoValueEnum.SL.getIndex(), "like");
                        health.setIntelligence(IndexSZ + "");
                    }
                    if (r.getCell(59).getStringCellValue().equals("1")) {
                        Integer IndexSZ = autoValueDao.getStringLikeIndex("一般障碍", AutoValueEnum.SL.getIndex(), "like");
                        health.setIntelligence(IndexSZ + "");
                    }
                    if (r.getCell(60).getStringCellValue().equals("1")) {
                        Integer IndexSZ = autoValueDao.getStringLikeIndex("正常", AutoValueEnum.SL.getIndex(), "like");
                        health.setIntelligence(IndexSZ + "");
                    }



                    List<Integer> selectIdList = new ArrayList<>();
                    if (r.getCell(28).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("青霉素", HealthEnum.YW.getIndex()));
                        health.setIsYwfy(HealthEnum.YW.getIndex());
                    }
                    if (r.getCell(29).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("磺胺", HealthEnum.YW.getIndex()));
                        health.setIsYwfy(HealthEnum.YW.getIndex());
                    }
                    if (r.getCell(30).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("四环素", HealthEnum.YW.getIndex()));
                        health.setIsYwfy(HealthEnum.YW.getIndex());
                    }
                    if (r.getCell(31).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("其他", HealthEnum.YW.getIndex()));
                        health.setIsYwfy(HealthEnum.YW.getIndex());
                    }

                    if (r.getCell(32).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("高血压", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(33).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("糖尿病", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(34).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("脑卒中", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(35).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("帕金森", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(36).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("癫痫", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(37).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("肺炎", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(38).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("慢阻肺", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(39).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("冠心病", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(40).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("甲亢/甲减", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(41).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("慢性肾功能障碍", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(42).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("肝炎/肝硬化", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(43).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("恶性肿瘤", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(44).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("骨折", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(45).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("其他消化道疾病", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (r.getCell(46).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("类风关", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }

                    if (r.getCell(49).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("上厕所", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (r.getCell(50).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("洗澡", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (r.getCell(51).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("穿衣", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (r.getCell(52).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("上下床", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (r.getCell(53).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("室内行走", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (r.getCell(54).getStringCellValue().equals("1")) {
                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("吃饭", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }


                    List<HealthAdd> healthAddList = new ArrayList<>();
                    if (!r.getCell(47).getStringCellValue().equals("")) {
                        health.setIsExzl(HealthEnum.EXZL.getIndex());
                        String[] add = r.getCell(47).getStringCellValue().split("#");
                        for (int i = 0; i < add.length; i++) {
                            HealthAdd healthAdd = new HealthAdd();
                            healthAdd.setDesc(add[i]);
                            healthAdd.setType(HealthEnum.EXZL.getIndex());
                            healthAddList.add(healthAdd);
                        }
                    }
                    if (!r.getCell(48).getStringCellValue().equals("")) {
                        health.setIsGz(HealthEnum.GZ.getIndex());
                        String[] add = r.getCell(48).getStringCellValue().split("#");
                        for (int i = 0; i < add.length; i++) {
                            HealthAdd healthAdd = new HealthAdd();
                            healthAdd.setDesc(add[i]);
                            healthAdd.setType(HealthEnum.GZ.getIndex());
                            healthAddList.add(healthAdd);
                        }
                    }

                    if (!r.getCell(61).getStringCellValue().equals("")) {
                        health.setIsCj(HealthEnum.CJQK.getIndex());
                        String[] add = r.getCell(61).getStringCellValue().split("#");
                        for (int i = 0; i < add.length; i++) {
                            HealthAdd healthAdd = new HealthAdd();
                            healthAdd.setDesc(add[i]);
                            healthAdd.setType(HealthEnum.CJQK.getIndex());
                            healthAddList.add(healthAdd);
                        }
                    }
//!!!!
                    OldmanFamily family = new OldmanFamily();
                    if (r.getCell(62).getStringCellValue().equals("1")) {
                        family.setFamilyIndex(autoValueDao.getStringLikeIndex("纯老", AutoValueEnum.JJJG.getIndex(), "like"));
                    }
                    if (r.getCell(63).getStringCellValue().equals("1")) {
                        family.setFamilyIndex(autoValueDao.getStringLikeIndex("独居", AutoValueEnum.JJJG.getIndex(), "like"));
                    }
                    if (r.getCell(64).getStringCellValue().equals("1")) {
                        family.setFamilyIndex(autoValueDao.getStringLikeIndex("失独", AutoValueEnum.JJJG.getIndex(), "like"));
                    }
                    if (r.getCell(65).getStringCellValue().equals("1")) {
                        family.setFamilyIndex(autoValueDao.getStringLikeIndex("一老养", AutoValueEnum.JJJG.getIndex(), "like"));
                    }
                    if (r.getCell(66).getStringCellValue().equals("1")) {
                        family.setFamilyIndex(autoValueDao.getStringLikeIndex("孤老", AutoValueEnum.JJJG.getIndex(), "like"));
                    }
                    if (r.getCell(67).getStringCellValue().equals("1")) {
                        family.setFamilyIndex(autoValueDao.getStringLikeIndex("三支人员", AutoValueEnum.JJJG.getIndex(), "like"));
                    }
                    if (r.getCell(68).getStringCellValue().equals("1")) {
                        family.setFamilyIndex(autoValueDao.getStringLikeIndex("其他", AutoValueEnum.JJJG.getIndex(), "like"));
                    }

                    OldmanEconomic economic = new OldmanEconomic();
                    if (r.getCell(69).getStringCellValue().equals("1")) {
                        economic.setEconomicIndex(autoValueDao.getStringLikeIndex("帮困", AutoValueEnum.JJTJ.getIndex(), "like"));
                    }
                    if (r.getCell(70).getStringCellValue().equals("1")) {
                        economic.setEconomicIndex(autoValueDao.getStringLikeIndex("低保", AutoValueEnum.JJTJ.getIndex(), "like"));
                    }
                    if (r.getCell(71).getStringCellValue().equals("1")) {
                        economic.setEconomicIndex(autoValueDao.getStringLikeIndex("养老保险", AutoValueEnum.JJTJ.getIndex(), "like"));
                    }
                    if (r.getCell(72).getStringCellValue().equals("1")) {
                        economic.setEconomicIndex(autoValueDao.getStringLikeIndex("医疗救助金", AutoValueEnum.JJTJ.getIndex(), "like"));
                    }
                    if (r.getCell(73).getStringCellValue().equals("1")) {
                        economic.setEconomicIndex(autoValueDao.getStringLikeIndex("城镇医保", AutoValueEnum.JJTJ.getIndex(), "like"));
                    }
                    if (r.getCell(74).getStringCellValue().equals("1")) {
                        economic.setEconomicIndex(autoValueDao.getStringLikeIndex("其他", AutoValueEnum.JJTJ.getIndex(), "like"));
                    }


                    Integer oldmanId=checkOldmanExiest(oldman.getPid());
                    if(oldmanId!=null && oldmanId!=0){
                        //更新
                        successUpdate++;
                        existOldmanIds.add(oldmanId);

                        oldman.setId(oldmanId);
                        oldmanList_update.add(oldman);

                        linkman.setOldmanId(oldmanId);
                        linkmanList_update.add(linkman);

                        health.setOldmanId(oldmanId);
                        healthList_update.add(health);

                        economic.setOldmanId(oldmanId);
                        economicList_update.add(economic);

                        family.setOldmanId(oldmanId);
                        familyList_update.add(family);


                    }else{
                        //添加
                        successAdd++;
                        oldmanBaseDao.save(oldman);
                        existOldmanIds.add(oldman.getId());

                        linkman.setOldmanId(oldman.getId());
                        linkmanList_add.add(linkman);

                        health.setOldmanId(oldman.getId());
                        healthList_add.add(health);

                        economic.setOldmanId(oldman.getId());
                        economicList_add.add(economic);

                        family.setOldmanId(oldman.getId());
                        familyList_add.add(family);

                    }


                    if(r.getCell(19).getStringCellValue().equals("1")){
                        Volunteer volunteer=new Volunteer();
                        volunteer.setOldmanId(oldman.getId());
                        volunteerList.add(volunteer);
                    }

                    for(int index:selectIdList){
                        HealthSelectMan healthSelectMan=new HealthSelectMan();
                        healthSelectMan.setOldmanId(oldman.getId());
                        healthSelectMan.setHealthSelectId(index);
                        healthSelectManList_add.add(healthSelectMan);
                    }
                    for(HealthAdd healthAdd:healthAddList){
                        HealthAdd add=new HealthAdd();
                        add.setOldmanId(oldman.getId());
                        add.setType(healthAdd.getType());
                        add.setDesc(healthAdd.getDesc());
                        healthAddList_add.add(healthAdd);
                    }
//                    System.out.println(oldman.toString());
//                    System.out.println(linkman.toString());
//                    System.out.println(health.toString());
//                    System.out.println(family.toString());
//                    System.out.println(economic.toString());
                }
                numSuccess++;
            }catch (Exception e){
                e.printStackTrace();
                excelReturnModel.getFail().add(r.getRowNum()+1);
            }
        }

        //更新
        if(oldmanList_update.size()>0)
            oldmanBaseDao.updateByIds(oldmanList_update);
        if(linkmanList_update.size()>0)
            linkmanDao.updateByOldmanIds(linkmanList_update);
        if(healthList_update.size()>0)
            oldmanHealthDao.updateByOldmanIds(healthList_update);
        if(economicList_update.size()>0)
            oldmanEconomicDao.updateByOldmanIds(economicList_update);
        if(familyList_update.size()>0)
            oldmanFamilyDao.updateByOldmanIds(familyList_update);
        //添加
        if(linkmanList_add.size()>0)
            linkmanDao.saveAll(linkmanList_add);
        if(healthList_add.size()>0)
            oldmanHealthDao.saveAll(healthList_add);
        if(economicList_add.size()>0)
            oldmanEconomicDao.saveAll(economicList_add);
        if(familyList_add.size()>0)
            oldmanFamilyDao.saveAll(familyList_add);
        if(healthSelectManList_add.size()>0) {
            //先把之前的记录删掉
            healthSelectManDao.delByOldmanId(existOldmanIds);
            healthSelectManDao.saveAll(healthSelectManList_add);
        }
        if(healthAddList_add.size()>0)
            healthAddDao.saveAll(healthAddList_add);
        if(volunteerList.size()>0){
            volunteerDao.delByOldmanId(existOldmanIds);
            volunteerDao.saveAll(volunteerList);
        }



        //老人不可用
        excelReturnModel.setSuccessDel(oldmanBaseDao.setDisabled(existOldmanIds,organId));

        excelReturnModel.setNumSuccess(numSuccess);
        excelReturnModel.setSuccessAdd(successAdd);
        excelReturnModel.setSuccessUpdate(successUpdate);
        excelReturnModel.setNumFail(excelReturnModel.getFail().size());


        return new Result(true,excelReturnModel);
    }

    private Integer checkOldmanExiest(String pid) {
        return oldmanBaseDao.getIdByPid(pid);
    }
}
