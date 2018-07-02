package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.label.Label;
import com.organOld.dao.entity.label.LabelRule;
import com.organOld.dao.entity.label.LabelRuleToDBSelectMan;
import com.organOld.dao.entity.oldman.*;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
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
    public void importExcel(MultipartFile file) throws IOException {
        List temp = new ArrayList();
        Workbook wb0 = new HSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        //对Sheet中的每一行进行迭代
        for (Row r : sht0) {
            //如果当前行的行号（从0开始）未达到2（第二行）则从新循环
            while (r.getRowNum() < 2) {
                break;
            }
            //创建实体类
            Oldman oldman=new Oldman();
            oldman.setName(r.getCell(3).getStringCellValue());
            oldman.setSex((r.getCell(4).getStringCellValue().equals("男"))?2:1);
            oldman.setBirthday(Tool.stringToDate((r.getCell(5).getStringCellValue())));
            oldman.setPid(r.getCell(6).getStringCellValue());
            oldman.setAddress(r.getCell(7).getStringCellValue());
            oldman.setPhone(r.getCell(8).getStringCellValue());

            String politicalStatus=r.getCell(9).getStringCellValue().equals("")?"群众":r.getCell(9).getStringCellValue();
            Integer poliIndex=autoValueDao.getStringLikeIndex(politicalStatus, AutoValueEnum.ZZMM.getIndex());
            oldman.setPoliticalStatus(poliIndex+"");

            if(r.getCell(11).getStringCellValue().equals("1")){
                Integer hjIndex=autoValueDao.getStringLikeIndex("户籍", AutoValueEnum.HJ.getIndex());
                oldman.setCensus(hjIndex+"");
            }else if(r.getCell(12).getStringCellValue().equals("1")){
                Integer hjIndex=autoValueDao.getStringLikeIndex("非户籍", AutoValueEnum.HJ.getIndex());
                oldman.setCensus(hjIndex+"");
            }else if(r.getCell(13).getStringCellValue().equals("1")){
                Integer hjIndex=autoValueDao.getStringLikeIndex("人户分离", AutoValueEnum.HJ.getIndex());
                oldman.setCensus(hjIndex+"");
            }

            Linkman linkman=new Linkman();
            linkman.setName(r.getCell(25).getStringCellValue());
            linkman.setRelation(r.getCell(26).getStringCellValue());
            linkman.setPhone(r.getCell(27).getStringCellValue());



            OldmanHealth health=new OldmanHealth();
            health.setBloodType(r.getCell(10).getStringCellValue());
            List<Integer> selectIdList=new ArrayList<>();
            if(r.getCell(28).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("青霉素", HealthEnum.YW.getIndex()));
            }
            if(r.getCell(29).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("磺胺", HealthEnum.YW.getIndex()));
            }
            if(r.getCell(30).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("四环素", HealthEnum.YW.getIndex()));
            }
            if(r.getCell(31).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("其他", HealthEnum.YW.getIndex()));
            }

            if(r.getCell(32).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("高血压", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(33).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("糖尿病", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(34).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("脑卒中", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(35).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("帕金森", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(36).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("癫痫", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(37).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("肺炎", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(38).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("慢阻肺", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(39).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("冠心病", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(40).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("甲亢/甲减", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(41).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("慢性肾功能障碍", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(42).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("肝炎/肝硬化", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(43).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("恶性肿瘤", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(44).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("骨折", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(45).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("其他消化道疾病", HealthEnum.MB.getIndex()));
            }
            if(r.getCell(46).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("类风关", HealthEnum.MB.getIndex()));
            }

            if(r.getCell(49).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("上厕所", HealthEnum.SN.getIndex()));
            }
            if(r.getCell(50).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("洗澡", HealthEnum.SN.getIndex()));
            }
            if(r.getCell(51).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("穿衣", HealthEnum.SN.getIndex()));
            }
            if(r.getCell(52).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("上下床", HealthEnum.SN.getIndex()));
            }
            if(r.getCell(53).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("室内行走", HealthEnum.SN.getIndex()));
            }
            if(r.getCell(54).getStringCellValue().equals("1")){
                selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("吃饭", HealthEnum.SN.getIndex()));
            }


            List<HealthAdd> healthAddList=new ArrayList<>();
            if(!r.getCell(47).getStringCellValue().equals("")){
                String[] add=r.getCell(47).getStringCellValue().split("#");
                for(int i=0;i<add.length;i++){
                    HealthAdd healthAdd=new HealthAdd();
                    healthAdd.setDesc(add[i]);
                    healthAdd.setType(HealthEnum.EXZL.getIndex());
                    healthAddList.add(healthAdd);
                }
            }
            if(!r.getCell(48).getStringCellValue().equals("")){
                String[] add=r.getCell(48).getStringCellValue().split("#");
                for(int i=0;i<add.length;i++){
                    HealthAdd healthAdd=new HealthAdd();
                    healthAdd.setDesc(add[i]);
                    healthAdd.setType(HealthEnum.GZ.getIndex());
                    healthAddList.add(healthAdd);
                }
            }

            if(r.getCell(55).getStringCellValue().equals("1")){
                Integer IndexSZ=autoValueDao.getStringLikeIndex("痴呆", AutoValueEnum.SZ.getIndex());
                health.setIntelligence(IndexSZ+"");
            }
            if(r.getCell(56).getStringCellValue().equals("1")){
                Integer IndexSZ=autoValueDao.getStringLikeIndex("智障", AutoValueEnum.SZ.getIndex());
                health.setIntelligence(IndexSZ+"");
            }
            if(r.getCell(57).getStringCellValue().equals("1")){
                Integer IndexSZ=autoValueDao.getStringLikeIndex("正常", AutoValueEnum.SZ.getIndex());
                health.setIntelligence(IndexSZ+"");
            }

            if(r.getCell(58).getStringCellValue().equals("1")){
                Integer IndexSZ=autoValueDao.getStringLikeIndex("失明", AutoValueEnum.SL.getIndex());
                health.setIntelligence(IndexSZ+"");
            }
            if(r.getCell(59).getStringCellValue().equals("1")){
                Integer IndexSZ=autoValueDao.getStringLikeIndex("一般障碍", AutoValueEnum.SL.getIndex());
                health.setIntelligence(IndexSZ+"");
            }
            if(r.getCell(60).getStringCellValue().equals("1")){
                Integer IndexSZ=autoValueDao.getStringLikeIndex("正常", AutoValueEnum.SL.getIndex());
                health.setIntelligence(IndexSZ+"");
            }

            if(!r.getCell(60).getStringCellValue().equals("")){
                String[] add=r.getCell(60).getStringCellValue().split("#");
                for(int i=0;i<add.length;i++){
                    HealthAdd healthAdd=new HealthAdd();
                    healthAdd.setDesc(add[i]);
                    healthAdd.setType(HealthEnum.CJQK.getIndex());
                    healthAddList.add(healthAdd);
                }
            }

            OldmanFamily family=new OldmanFamily();
            if(r.getCell(61).getStringCellValue().equals("1")){
                family.setFamily(autoValueDao.getStringLikeIndex("纯老", AutoValueEnum.JJJG.getIndex())+"");
            }
            if(r.getCell(62).getStringCellValue().equals("1")){
                family.setFamily(autoValueDao.getStringLikeIndex("独居", AutoValueEnum.JJJG.getIndex())+"");
            }
            if(r.getCell(63).getStringCellValue().equals("1")){
                family.setFamily(autoValueDao.getStringLikeIndex("失独", AutoValueEnum.JJJG.getIndex())+"");
            }
            if(r.getCell(64).getStringCellValue().equals("1")){
                family.setFamily(autoValueDao.getStringLikeIndex("一老养", AutoValueEnum.JJJG.getIndex())+"");
            }
            if(r.getCell(65).getStringCellValue().equals("1")){
                family.setFamily(autoValueDao.getStringLikeIndex("孤老", AutoValueEnum.JJJG.getIndex())+"");
            }
            if(r.getCell(66).getStringCellValue().equals("1")){
                family.setFamily(autoValueDao.getStringLikeIndex("三支人员", AutoValueEnum.JJJG.getIndex())+"");
            }
            if(r.getCell(67).getStringCellValue().equals("1")){
                family.setFamily(autoValueDao.getStringLikeIndex("其他", AutoValueEnum.JJJG.getIndex())+"");
            }

            OldmanEconomic economic=new OldmanEconomic();
            if(r.getCell(68).getStringCellValue().equals("1")){
                economic.setEconomic(autoValueDao.getStringLikeIndex("帮困", AutoValueEnum.JJTJ.getIndex())+"");
            }
            if(r.getCell(69).getStringCellValue().equals("1")){
                economic.setEconomic(autoValueDao.getStringLikeIndex("低保", AutoValueEnum.JJTJ.getIndex())+"");
            }
            if(r.getCell(70).getStringCellValue().equals("1")){
                economic.setEconomic(autoValueDao.getStringLikeIndex("养老保险", AutoValueEnum.JJTJ.getIndex())+"");
            }
            if(r.getCell(71).getStringCellValue().equals("1")){
                economic.setEconomic(autoValueDao.getStringLikeIndex("医疗救助金", AutoValueEnum.JJTJ.getIndex())+"");
            }
            if(r.getCell(72).getStringCellValue().equals("1")){
                economic.setEconomic(autoValueDao.getStringLikeIndex("城镇医保", AutoValueEnum.JJTJ.getIndex())+"");
            }
            if(r.getCell(73).getStringCellValue().equals("1")){
                economic.setEconomic(autoValueDao.getStringLikeIndex("其他", AutoValueEnum.JJTJ.getIndex())+"");
            }

        }

    }
}
