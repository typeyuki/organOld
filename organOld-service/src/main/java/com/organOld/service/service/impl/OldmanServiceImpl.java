package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.*;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.entity.volunteer.Volunteer;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.dao.util.bean.ExportOldman;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.constant.ValueConstant;
import com.organOld.service.enumModel.AutoValueEnum;
import com.organOld.service.enumModel.HealthEnum;
import com.organOld.service.model.*;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OldmanService;
import com.organOld.service.util.ExcelUtil;
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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
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
    @Autowired
    HealthSelectDao healthSelectDao;
    @Autowired
    CardDao cardDao;

    @Override
    public String getOldmanByPage(OldmanRequest oldmanRequest, BTableRequest bTableRequest) {
        Page<Oldman> page=commonService.getPage(bTableRequest,"oldman_base");
        Oldman oldman= Wrappers.oldmanWrapper.unwrap(oldmanRequest);
        commonService.checkIsOrgan(oldman);
        page.setEntity(oldman);
        List<OldmanModel> oldmanList=oldmanBaseDao.getByPage(page).stream().map(Wrappers.oldmanWrapper::wrap).collect(Collectors.toList());
        try {
            fillAutoValue(oldmanList,AutoValueEnum.SQZW.getIndex(),"Sqzw");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Long size=oldmanBaseDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanList);
    }

    @Override
    public void export(HttpServletResponse response, ExportTableThRequest exportTableThRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Oldman oldman= Wrappers.oldmanWrapper.unwrapAll(exportTableThRequest);
        commonService.checkIsOrgan(oldman);
        List<ExportOldman> exportOldmanList=oldmanBaseDao.getAll(oldman).stream().map(Wrappers.oldmanWrapper::wrapAll).collect(Collectors.toList());

        //excel标题
        String[] title =new String[exportTableThRequest.getTh().size()];
        String[] engTitle=new String[exportTableThRequest.getTh().size()];
        int i=0,j=0,k;
        for(String t:exportTableThRequest.getTh()){
            String ct=t.split("#")[1];
            String engt=t.split("#")[0];
            title[i]=ct;
            engTitle[i]=engt;
            i++;
        }
        //excel文件名
        String fileName = "老人信息表.xls";
        String sheetName = "老人信息表";
        String[][] content=new String[exportOldmanList.size()][];
        for(ExportOldman exportOldman:exportOldmanList){
            k=0;
            content[j]=new String[exportTableThRequest.getTh().size()];
            for(String eng:engTitle){
                if(eng.equals("getSqzw")){
                    fillExportAutoValue(exportOldman,AutoValueEnum.SQZW.getIndex());
                }
                Method method = exportOldman.getClass().getMethod(eng, null);
                content[j][k++]= (String) method.invoke(exportOldman,null);
            }
            j++;
        }

//创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

//响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillExportAutoValue(ExportOldman exportOldman, int type) {
        List<AutoValue> autoValueList=autoValueDao.getByType(type);
        Map<Integer,String> map=new HashMap<>();
        autoValueList.forEach(s->map.put(s.getId(),s.getValue()));
            if(exportOldman.getSqzw()!=null && !exportOldman.getSqzw().equals("")){
                String[] sq=exportOldman.getSqzw().split("#");
                exportOldman.setSqzw("");
                for(String s:sq){
                    exportOldman.setSqzw(exportOldman.getSqzw()+","+map.get(Integer.parseInt(s)));
                }
                exportOldman.setSqzw(exportOldman.getSqzw().substring(1));
            }

    }

    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename="+fileName);
//            response.setContentType("application/octet-stream;charset=ISO8859-1");
//            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
//            response.addHeader("Pargam", "no-cache");
//            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void fillAutoValue(List<? extends Model> list, int type,String method) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<AutoValue> autoValueList=autoValueDao.getByType(type);
        Map<Integer,String> map=new HashMap<>();
        autoValueList.forEach(s->map.put(s.getId(),s.getValue()));
        for(Model model : list){
            String setM="set"+method;
            String getM="get"+method+"String";
            Method setMethod = model.getClass().getMethod(setM, List.class);
            Method getMethod = model.getClass().getMethod(getM, null);

            if((String)getMethod.invoke(model,null)!=null && !((String)getMethod.invoke(model,null)).equals("")){
                String[] s=((String)getMethod.invoke(model,null)).split("#");
                List<String> sList=new ArrayList<>();
                for(String ss:s){
                    sList.add(map.get(Integer.parseInt(ss)));
                }
                setMethod.invoke(model,sList);
            }
        }
    }


    @Override
    public String getHealthByPage(OldmanHealthRequest oldmanHealthRequest, BTableRequest bTableRequest) {
        Page<OldmanHealth> page=commonService.getPage(bTableRequest,"oldman_health");
        OldmanHealth oldmanHealth=Wrappers.oldmanHealthWrapper.unwrap(oldmanHealthRequest);
        commonService.checkIsOrgan(oldmanHealth);
        page.setEntity(oldmanHealth);
        List<OldmanHealthModel> oldmanHealthModelList=oldmanHealthDao.getByPage(page).stream().map(Wrappers.oldmanHealthWrapper::wrap).collect(Collectors.toList());
        Long size=oldmanHealthDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanHealthModelList);
    }

    @Override
    public String getHealthSelectByPage(HealthSelectRequest healthSelectRequest, BTableRequest bTableRequest) {
        Page<HealthSelect> page=commonService.getPage(bTableRequest,"health_select");
        HealthSelect healthSelect=Wrappers.oldmanHealthWrapper.unwrapHealthSelect(healthSelectRequest);
        page.setEntity(healthSelect);
        List<HealthSelectModel> healthSelectModelList=healthSelectDao.getByPage(page).stream().map(Wrappers.oldmanHealthWrapper::wrapHealthSelect).collect(Collectors.toList());
        Long size=healthSelectDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,healthSelectModelList);
    }

    @Override
    public void addOrUpdateHealthSelect(HealthSelect healthSelect, String type) {
        if(type.equals("add"))
            healthSelectDao.save(healthSelect);
        else
            healthSelectDao.updateById(healthSelect);
    }

    @Override
    public String getEconomyByPage(OldmanEconomicRequest economicRequest, BTableRequest bTableRequest) {
        Page<OldmanEconomic> page=commonService.getPage(bTableRequest,"oldman_economy");
        OldmanEconomic economic=Wrappers.economicWrapper.unwrap(economicRequest);
        commonService.checkIsOrgan(economic);
        page.setEntity(economic);
        List<OldmanEconomicModel> economicModelList=economicDao.getByPage(page).stream().map(Wrappers.economicWrapper::wrap).collect(Collectors.toList());
        Long size=economicDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,economicModelList);
    }


    @Override
    public String getIntegralByPage(OldmanIntegralRequest oldmanIntegralRequest, BTableRequest bTableRequest) {
        Page<OldmanIntegral> page=commonService.getPage(bTableRequest,"oldman_integral");
        OldmanIntegral integral=Wrappers.oldmanWrapper.unwrapIntegral(oldmanIntegralRequest);
        commonService.checkIsOrgan(integral);
        page.setEntity(integral);
        List<OldmanIntegralModel> oldmanIntegralModelList=oldmanBaseDao.getIntegralByPage(page).stream().map(Wrappers.oldmanWrapper::wrapIntegral).collect(Collectors.toList());
        Long size=oldmanBaseDao.getIntegralSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanIntegralModelList);
    }

    @Override
    public String getFamilyByPage(OldmanFamilyRequest familyRequest, BTableRequest bTableRequest) {
        Page<OldmanFamily> page=commonService.getPage(bTableRequest,"oldman_family");
        OldmanFamily family=Wrappers.familyWrapper.unwrap(familyRequest);
        commonService.checkIsOrgan(family);
        page.setEntity(family);
        List<OldmanFamilyModel> familyModelList=familyDao.getByPage(page).stream().map(Wrappers.familyWrapper::wrap).collect(Collectors.toList());
        Long size=familyDao.getSizeByPage(page);
        try {
            fillAutoValue(familyModelList,AutoValueEnum.JTLB.getIndex(),"FamilyType");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return commonService.tableReturn(bTableRequest.getsEcho(),size,familyModelList);
    }

    @Override
    public String getOrganOldmanByPage(OrganOldmanRequest organOldmanRequest, BTableRequest bTableRequest) {
        Page<OrganOldman> page=commonService.getPage(bTableRequest,"oldman_organOldman");
        OrganOldman organOldman=Wrappers.organOldmanWrapper.unwrap(organOldmanRequest);
        commonService.checkIsOrgan(organOldman);
        page.setEntity(organOldman);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getByPage(page).stream().map(Wrappers.organOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=organOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public String getLinkmanByPage(LinkmanRequest linkmanRequest, BTableRequest bTableRequest) {
        Page<Linkman> page=commonService.getPage(bTableRequest,"oldman_linkman");
        Linkman linkman=Wrappers.linkmanWrapper.unwrap(linkmanRequest);
        commonService.checkIsOrgan(linkman);
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
    public OldmanAddInfoModel getAddInfo() {
        List<Integer> typeList=commonService.getAutoValueTypes("oldman_add");
        List<AutoValue> autoValueList=autoValueDao.getByTypeList(typeList);
        Integer organId=commonService.getIdBySession();
        List<Organ> jwList=organDao.getSimpleByType(2,organId);
        List<HealthSelect> healthSelectList=oldmanHealthDao.getAllHealthSelect();
        OldmanAddInfoModel oldmanAddInfoModel=Wrappers.oldmanWrapper.wrapAddInfo(autoValueList,jwList,healthSelectList);
        return oldmanAddInfoModel;
    }


    @Override
    public HealthSelectInfoModel getAllHealthInfo() {
        List<Integer> typeList=commonService.getAutoValueTypes("health_add");
        List<AutoValue> autoValueList=autoValueDao.getByTypeList(typeList);
        List<HealthSelect> healthSelectList=oldmanHealthDao.getAllHealthSelect();
        HealthSelectInfoModel healthSelectInfoModel=Wrappers.oldmanWrapper.wrapHealthSelectInfo(autoValueList,healthSelectList);
        return healthSelectInfoModel;
    }

    @Override
    public String getHomeOldmanByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest) {
        Page<HomeOldman> page=commonService.getPage(bTableRequest,"oldman_homeOldman");
        HomeOldman homeOldman=Wrappers.homeOldmanWrapper.unwrap(homeOldmanRequest);
        commonService.checkIsOrgan(homeOldman);
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
        page.setLength(1);
        page.setStart(0);

        Oldman oldman=new Oldman();
        oldman.setId(oldmanId);

        page.setEntity(oldman);
        List<OldmanModel> oldmanModelList=oldmanBaseDao.getByPage(page).stream().map(Wrappers.oldmanWrapper::wrap).collect(Collectors.toList());
        try {
            fillAutoValue(oldmanModelList,AutoValueEnum.SQZW.getIndex(),"Sqzw");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
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


    //TODO 标签 绑定人员更新
    @Override
    @Transactional
    public Result importExcel(MultipartFile file, HttpSession session) throws IOException {

        Oldman o=new Oldman();
        commonService.checkIsOrgan(o);
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

        List<Card> cardList_add=new ArrayList<>();

        //批量更新
        List<OldmanEconomic> economicList_update=new ArrayList<>();
        List<OldmanFamily> familyList_update=new ArrayList<>();
        List<Linkman> linkmanList_update=new ArrayList<>();
        List<OldmanHealth> healthList_update=new ArrayList<>();
        List<Oldman> oldmanList_update=new ArrayList<>();//对已存在的老人进行批量更新



        Workbook wb0 = new HSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);

        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int successUpdate=0;//导入数量中  更新的个数
        int successAdd=0;//导入数量中  增加的个数
//        int successDel=0;//删除的个数


        int start=2;


        //对Sheet中的每一行进行迭代
        for (Row r : sht0) {
            Oldman oldman = new Oldman();
            try {
                if (r.getRowNum() >= start) {
                    //遍历 cell  将单元格 格式 全都转换成String 类型
                    Iterator<Cell> cells = r.cellIterator();    //获得第一行的迭代器
                    while (cells.hasNext()) {
                        Cell cell = cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }


                    //创建实体类
                    oldman.setName(r.getCell(3).getStringCellValue());
                    String sex=r.getCell(4).getStringCellValue();
                    sex=sex.replace("性","");
                    oldman.setSex((sex.equals("男")) ? 2 : 1);
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

                    if (r.getCell(14).getStringCellValue().equals("1")) {
                        Integer zcIndex = autoValueDao.getStringLikeIndex("高级", AutoValueEnum.ZC.getIndex(), "equals");
                        oldman.setZc(zcIndex + "");
                    }
                    if (r.getCell(15).getStringCellValue().equals("1")) {
                        Integer zcIndex = autoValueDao.getStringLikeIndex("副高级", AutoValueEnum.ZC.getIndex(), "equals");
                        oldman.setZc(zcIndex + "");
                    }
                    if (r.getCell(16).getStringCellValue().equals("1")) {
                        Integer zcIndex = autoValueDao.getStringLikeIndex("中级", AutoValueEnum.ZC.getIndex(), "equals");
                        oldman.setZc(zcIndex + "");
                    }
                    String sqzw="";
                    if (r.getCell(17).getStringCellValue().equals("1")) {
                        Integer szIndex = autoValueDao.getStringLikeIndex("三长", AutoValueEnum.SQZW.getIndex(), "equals");
                        sqzw=szIndex+"";
                    }
                    if (r.getCell(18).getStringCellValue().equals("1")) {
                        Integer sqIndex = autoValueDao.getStringLikeIndex("社区团队负责人", AutoValueEnum.SQZW.getIndex(), "equals");
                        if(sqzw.length()>1){
                            sqzw+="#"+sqIndex;
                        }
                    }
                    oldman.setSqzw(sqzw);


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

                    String familyType="";
                    if (r.getCell(20).getStringCellValue().equals("1")) {
                       familyType+=autoValueDao.getStringLikeIndex("独生子女家庭", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if (r.getCell(21).getStringCellValue().equals("1")) {
                        familyType+=autoValueDao.getStringLikeIndex("军属", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if (r.getCell(22).getStringCellValue().equals("1")) {
                        familyType+=autoValueDao.getStringLikeIndex("烈士家庭", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if (r.getCell(23).getStringCellValue().equals("1")) {
                        familyType+=autoValueDao.getStringLikeIndex("离休干部", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if (r.getCell(24).getStringCellValue().equals("1")) {
                        familyType+=autoValueDao.getStringLikeIndex("侨属", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if(!familyType.equals("")){
                        familyType=familyType.substring(0,familyType.length()-1);
                        family.setFamilyTypeIndex(familyType);
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


                    Integer oldmanId=commonService.checkOldmanExiest(oldman.getPid());
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


                        Card card=new Card();
                        card.setOldmanId(oldman.getId());
                        card.setCid(oldman.getPid().substring(oldman.getPid().length()-6));
                        card.setPassword("123456");
                        cardList_add.add(card);


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
                        healthAddList_add.add(add);
                    }
                    numSuccess++;
                }
            }catch (Exception e){
                //检测 是否已经把改老人信息加到表里
                oldmanBaseDao.delById(oldman.getId());

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

        if(existOldmanIds.size()>0)
            healthSelectManDao.delByOldmanIds(existOldmanIds);
        if(healthSelectManList_add.size()>0) {
            //先把之前的记录删掉
            healthSelectManDao.saveAll(healthSelectManList_add);
        }
        if(healthAddList_add.size()>0)
            healthAddDao.saveAll(healthAddList_add);

        volunteerDao.delByOrganId(organId);
        if(volunteerList.size()>0){
            volunteerDao.saveAll(volunteerList);
        }

        cardDao.delByOldmanIds(existOldmanIds);
        if(cardList_add.size()>0){
            cardDao.saveAll(cardList_add);
        }



        //老人不可用  机构范围
        excelReturnModel.setSuccessDel(oldmanBaseDao.setDisabled(existOldmanIds,organId));

        excelReturnModel.setNumSuccess(numSuccess);
        excelReturnModel.setSuccessAdd(successAdd);
        excelReturnModel.setSuccessUpdate(successUpdate);
        excelReturnModel.setNumFail(excelReturnModel.getFail().size());
        excelReturnModel.setTotal(numSuccess+excelReturnModel.getNumFail());//一共

        return new Result(true,excelReturnModel);
    }


    @Override
    public Result getIntegralByOldmanId(int oldmanId) {
        OrganQueryIntegralModel organQueryIntegralModel=Wrappers.oldmanWrapper.wrapInregral(oldmanBaseDao.getIntegralByOldmanId(oldmanId));
        if(organQueryIntegralModel!=null)
            return new Result(true,organQueryIntegralModel);
        else return new Result(false,"找不到");
    }

    @Override
    public Result getById(int id, String type) {
        switch (type){
            case "base":
                Oldman oldman=oldmanBaseDao.getById(id);
                oldman.setSqzw(oldman.getSqzw().replace("s",""));
                oldman.setBirthdayTime(Tool.dateToString(oldman.getBirthday(), TimeConstant.DATA_FORMAT_YMD));
                return new Result(true,oldman);
            case "family":
                OldmanFamily oldmanFamily=oldmanFamilyDao.getById(id);
                return new Result(true,oldmanFamily);
            case "economic":
                OldmanEconomic oldmanEconomic=oldmanEconomicDao.getById(id);
                return new Result(true,oldmanEconomic);
            case "linkman":
                Linkman linkman=linkmanDao.getById(id);
                return new Result(true,linkman);
            case "health":
                OldmanHealth oldmanHealth=oldmanHealthDao.getByOldmanId(id);
                return new Result(true,oldmanHealth);
        }
        return null;
    }

    @Override
    public Result updateById(DBEntity dbEntity, String type) {
        switch (type){
            case "base":
                Oldman oldman= (Oldman) dbEntity;
                oldman.setBirthday(Tool.stringToDate(oldman.getBirthdayTime()));
                if(oldman.getSqzw()!=null && !oldman.getSqzw().equals(""))
                    oldman.setSqzw(oldman.getSqzw().replace(",","#"));
                oldmanBaseDao.updateById(oldman);
                break;
            case "family":
                OldmanFamily oldmanFamily=(OldmanFamily)dbEntity;
//                if(oldman.getSqzw()!=null && !oldman.getSqzw().equals(""))
//                    oldman.setSqzw(oldman.getSqzw().replace(",","#"));
                oldmanFamilyDao.updateById(oldmanFamily);
                break;
            case "economic":
                OldmanEconomic oldmanEconomic=(OldmanEconomic)dbEntity;
                oldmanEconomicDao.updateById(oldmanEconomic);
                break;
            case "linkman":
                Linkman linkman=(Linkman) dbEntity;
                linkmanDao.updateById(linkman);
                break;
            case "health":
                OldmanHealth oldmanHealth=(OldmanHealth) dbEntity;
                oldmanHealthDao.updateById(oldmanHealth);
                healthSelectManDao.delByOldmanId(oldmanHealth.getOldman().getId());
                healthAddDao.delByOldmanId(oldmanHealth.getOldman().getId());
                List<HealthAdd> healthAddList=new ArrayList<>();

        }
        return new Result(true);
    }

    @Override
    public void delByIds(String[] ids) {
        oldmanBaseDao.updateProps("disable","1",ids);
    }

    @Override
    public void delHealthSelectByIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        healthSelectDao.delByIds(id);
    }

    @Override
    public Result getIntegralRule() {
        IntegralRuleModel integralRuleModel=new IntegralRuleModel();
        integralRuleModel.setConsume(ValueConstant.INTEGRAL_RULE_CONSUME);
        integralRuleModel.setSign(ValueConstant.INTEGRAL_RULE_SIGN);
        return new Result(true, integralRuleModel);
    }

    @Override
    public void updateIntegral(int sign, int consume) {
        ValueConstant.INTEGRAL_RULE_SIGN=sign;
        ValueConstant.INTEGRAL_RULE_CONSUME=consume;
    }
}
