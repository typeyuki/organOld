package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.XqInterface;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.*;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.dao.util.bean.ExportOldman;
import com.organOld.service.constant.TimeConstant;
import com.organOld.service.constant.ValueConstant;
import com.organOld.service.enumModel.AutoValueEnum;
import com.organOld.service.enumModel.HealthEnum;
import com.organOld.service.model.*;
import com.organOld.service.service.AutoValueService;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OldmanService;
import com.organOld.service.util.ExcelUtil;
import com.organOld.service.util.Tool;
import com.organOld.service.wrapper.*;
import com.organOld.service.contract.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
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
    HealthAddDao healthAddDao;
    @Autowired
    HealthSelectManDao healthSelectManDao;
    @Autowired
    HealthSelectDao healthSelectDao;
    @Autowired
    CardDao cardDao;
    @Autowired
    OldmanWrapper oldmanWrapper;
    @Autowired
    OldmanHealthWrapper oldmanHealthWrapper;
    @Autowired
    LinkmanWrapper linkmanWrapper;
    @Autowired
    OrganOldmanWrapper organOldmanWrapper;
    @Autowired
    HomeOldmanWrapper homeOldmanWrapper;
    @Autowired
    OldmanKeyWrapper oldmanKeyWrapper;
    @Autowired
    AutoValueService autoValueService;


    /**
     * 用于导入 提前获得auto_value,health_select数据
     */
    Map<String,String> mapAutoValue=new HashMap<>();
    Map<String,Integer> mapHealthSelect=new HashMap<>();

    @Override
    public String getOldmanByPage(OldmanRequest oldmanRequest, BTableRequest bTableRequest) {
        Page<Oldman> page=commonService.getPage(bTableRequest,"oldman_base");
        Oldman oldman= oldmanWrapper.unwrap(oldmanRequest);
        commonService.fillXq(oldmanRequest,oldman);
        page.setEntity(oldman);
        List<OldmanModel> oldmanList=oldmanBaseDao.getByPage(page).stream().map(oldmanWrapper::wrap).collect(Collectors.toList());
        Long size=oldmanBaseDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanList);
    }



    @Override
    public void export(HttpServletResponse response, ExportTableThRequest exportTableThRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Oldman oldman= oldmanWrapper.unwrapAll(exportTableThRequest);
        commonService.fillXq(exportTableThRequest,oldman);
        List<ExportOldmanModel> exportOldmanList=oldmanBaseDao.getAll(oldman).stream().map(oldmanWrapper::wrapAll).collect(Collectors.toList());

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
        for(ExportOldmanModel exportOldman:exportOldmanList){
            k=0;
            content[j]=new String[exportTableThRequest.getTh().size()];
            for(String eng:engTitle){
                if(eng.equals("getSqzw")){
//                    fillExportAutoValue(exportOldman,AutoValueEnum.SQZW.getIndex(),eng);
                    content[j][k++]=  StringUtils.collectionToDelimitedString(exportOldman.getSqzw(), ",");
                }else if(eng.equals("getFamilyType")){
                    content[j][k++]=  StringUtils.collectionToDelimitedString(exportOldman.getFamilyType(), ",");
                }else{
                    Method method = exportOldman.getClass().getMethod(eng, null);
                    content[j][k++] = (String) method.invoke(exportOldman, null);
                }
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




//    @Override
//    public String getHealthByPage(OldmanHealthRequest oldmanHealthRequest, BTableRequest bTableRequest) {
//        Page<OldmanHealth> page=commonService.getPage(bTableRequest,"oldman_health");
//        OldmanHealth oldmanHealth=oldmanHealthWrapper.unwrap(oldmanHealthRequest);
//        commonService.checkIsOrgan(oldmanHealth);
//        page.setEntity(oldmanHealth);
//        List<OldmanHealthModel> oldmanHealthModelList=oldmanHealthDao.getByPage(page).stream().map(oldmanHealthWrapper::wrap).collect(Collectors.toList());
//        Long size=oldmanHealthDao.getSizeByPage(page);
//        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanHealthModelList);
//    }

    @Override
    public String getHealthSelectByPage(HealthSelectRequest healthSelectRequest, BTableRequest bTableRequest) {
        Page<HealthSelect> page=commonService.getPage(bTableRequest,"health_select");
        HealthSelect healthSelect=oldmanHealthWrapper.unwrapHealthSelect(healthSelectRequest);
        page.setEntity(healthSelect);
        List<HealthSelectModel> healthSelectModelList=healthSelectDao.getByPage(page).stream().map(oldmanHealthWrapper::wrapHealthSelect).collect(Collectors.toList());
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

//    @Override
//    public String getEconomyByPage(OldmanEconomicRequest economicRequest, BTableRequest bTableRequest) {
//        Page<OldmanEconomic> page=commonService.getPage(bTableRequest,"oldman_economy");
//        OldmanEconomic economic=economicWrapper.unwrap(economicRequest);
//        commonService.checkIsOrgan(economic);
//        page.setEntity(economic);
//        List<OldmanEconomicModel> economicModelList=economicDao.getByPage(page).stream().map(economicWrapper::wrap).collect(Collectors.toList());
//        Long size=economicDao.getSizeByPage(page);
//        return commonService.tableReturn(bTableRequest.getsEcho(),size,economicModelList);
//    }


    @Override
    public String getIntegralByPage(OldmanIntegralRequest oldmanIntegralRequest, BTableRequest bTableRequest) {
        Page<OldmanIntegral> page=commonService.getPage(bTableRequest,"oldman_integral");
        OldmanIntegral integral=oldmanWrapper.unwrapIntegral(oldmanIntegralRequest);
        commonService.checkIsOrgan(integral);
        page.setEntity(integral);
        List<OldmanIntegralModel> oldmanIntegralModelList=oldmanBaseDao.getIntegralByPage(page).stream().map(oldmanWrapper::wrapIntegral).collect(Collectors.toList());
        Long size=oldmanBaseDao.getIntegralSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanIntegralModelList);
    }

//    @Override
//    public String getFamilyByPage(OldmanFamilyRequest familyRequest, BTableRequest bTableRequest) {
//        Page<OldmanFamily> page=commonService.getPage(bTableRequest,"oldman_family");
//        OldmanFamily family=familyWrapper.unwrap(familyRequest);
//        commonService.checkIsOrgan(family);
//        page.setEntity(family);
//        List<OldmanFamilyModel> familyModelList=familyDao.getByPage(page).stream().map(familyWrapper::wrap).collect(Collectors.toList());
//        Long size=familyDao.getSizeByPage(page);
//        try {
//            fillAutoValue(familyModelList,AutoValueEnum.JTLB.getIndex(),"FamilyType");
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return commonService.tableReturn(bTableRequest.getsEcho(),size,familyModelList);
//    }

    @Override
    public String getOrganOldmanByPage(OrganOldmanRequest organOldmanRequest, BTableRequest bTableRequest) {
        Page<OrganOldman> page=commonService.getPage(bTableRequest,"oldman_organOldman");
        OrganOldman organOldman=organOldmanWrapper.unwrap(organOldmanRequest);
        commonService.checkIsOrgan(organOldman);
        page.setEntity(organOldman);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getByPage(page).stream().map(organOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=organOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

//    @Override
//    public String getLinkmanByPage(LinkmanRequest linkmanRequest, BTableRequest bTableRequest) {
//        Page<Linkman> page=commonService.getPage(bTableRequest,"oldman_linkman");
//        Linkman linkman=linkmanWrapper.unwrap(linkmanRequest);
//        commonService.checkIsOrgan(linkman);
//        page.setEntity(linkman);
//        List<LinkmanModel> linkmanModelList=linkmanDao.getByPage(page).stream().map(linkmanWrapper::wrap).collect(Collectors.toList());
//        Long size=linkmanDao.getSizeByPage(page);
//        return commonService.tableReturn(bTableRequest.getsEcho(),size,linkmanModelList);
//    }



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
        OldmanAddInfoModel oldmanAddInfoModel=oldmanWrapper.wrapAddInfo(autoValueList,jwList,healthSelectList);
        return oldmanAddInfoModel;
    }


    @Override
    public HealthSelectInfoModel getAllHealthInfo() {
        List<Integer> typeList=commonService.getAutoValueTypes("health_add");
        List<AutoValue> autoValueList=autoValueDao.getByTypeList(typeList);
        List<HealthSelect> healthSelectList=oldmanHealthDao.getAllHealthSelect();
        HealthSelectInfoModel healthSelectInfoModel=oldmanWrapper.wrapHealthSelectInfo(autoValueList,healthSelectList);
        return healthSelectInfoModel;
    }

    @Override
    public String getHomeOldmanByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest) {
        Page<HomeOldman> page=commonService.getPage(bTableRequest,"oldman_homeOldman");
        HomeOldman homeOldman=homeOldmanWrapper.unwrap(homeOldmanRequest);
        commonService.checkIsOrgan(homeOldman);
        page.setEntity(homeOldman);
        List<HomeOldmanModel> organOldmanModelList=homeOldmanDao.getByPage(page).stream().map(homeOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=homeOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public OldmanAllInfoModel getOldmanInfo(int oldmanId) {
        OldmanAllInfoModel oldmanAllInfoModel=new OldmanAllInfoModel();
        Page<DBEntity> page=new Page<>();
        page.setLength(1);
        page.setStart(0);

        Oldman oldman=new Oldman();
        oldman.setId(oldmanId);


        OldmanModel oldmanModel=oldmanWrapper.wrapInfo(oldmanBaseDao.getById(oldmanId));
        oldmanAllInfoModel.setOldman(oldmanModel);

        oldman.setKeyGoalBase(ValueConstant.OLDMAN_KEY_GOAL_BASE);
        page.setEntity(oldman);
        List<OldmanKeyModel> oldmanKeyModelList=oldmanKeyDao.getByPage(page).stream().map(oldmanKeyWrapper::wrap).collect(Collectors.toList());
        if(oldmanKeyModelList!=null && oldmanKeyModelList.size()>0)
            oldmanAllInfoModel.setKey(oldmanKeyModelList.get(0));

        OldmanHealthModel oldmanHealthModel=oldmanHealthWrapper.wrap(oldmanHealthDao.getByOldmanId(oldmanId));
        oldmanAllInfoModel.setHealth(oldmanHealthModel);


        Linkman linkman=new Linkman();
        linkman.setOldman(oldman);
        page.setEntity(linkman);
        List<LinkmanModel> linkmanModelList=linkmanDao.getByPage(page).stream().map(linkmanWrapper::wrap).collect(Collectors.toList());
        if(linkmanModelList!=null && linkmanModelList.size()>0)
            oldmanAllInfoModel.setLinkman(linkmanModelList.get(0));

        OrganOldman organOldman=new OrganOldman();
        organOldman.setFirType(21);
        organOldman.setOldman(oldman);
        page.setEntity(organOldman);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getByPage(page).stream().map(organOldmanWrapper::wrap).collect(Collectors.toList());
        if(organOldmanModelList!=null && organOldmanModelList.size()>0)
            oldmanAllInfoModel.setOrgan(organOldmanModelList.get(0));

        OrganOldman communityOldman=new OrganOldman();
        communityOldman.setFirType(22);
        communityOldman.setOldman(oldman);
        page.setEntity(communityOldman);
        List<OrganOldmanModel> communityOldmanModelList=organOldmanDao.getByPage(page).stream().map(organOldmanWrapper::wrap).collect(Collectors.toList());
        oldmanAllInfoModel.setCommunity(communityOldmanModelList);

        HomeOldman homeOldman=new HomeOldman();
        homeOldman.setOldman(oldman);
        page.setEntity(homeOldman);
        List<HomeOldmanModel> homeOldmanModelList=homeOldmanDao.getByPage(page).stream().map(homeOldmanWrapper::wrap).collect(Collectors.toList());
        oldmanAllInfoModel.setHome(homeOldmanModelList);

        return oldmanAllInfoModel;
    }


    //TODO 标签 绑定人员更新
    @Override
    @Transactional
    public Result importExcel(MultipartFile file, HttpSession session) throws IOException {


//        Integer organId=commonService.getIdBySession();

        //导入规则  已有的则进行更新 没有的今天添加   数据库有的 表没有的  则“删除” 设置老人状态为不可用
        List<Integer> existOldmanIds=new ArrayList<>();//存储 本次更新 中已存在的老人ID 用于得到需要“删除”的老人ID


        //批量插入  HealthSelect只进行批量插入 在这之前将已有信息删除 由于恶性肿瘤史、骨折史 等 每次都只写当次更新的内容 历史不用写进来  所以直接进行批量更新
        int oldmanIdStrat=0;//导入老人 第一个 进行插入数据库  之后的老人 就不插入数据库 而是最后批量插入 该变量记录第一个的oldmanId

        List<Linkman> linkmanList_add=new ArrayList<>();
        List<OldmanHealth> healthList_add=new ArrayList<>();
        List<HealthSelectMan> healthSelectManList_add=new ArrayList<>();
        List<HealthAdd> healthAddList_add=new ArrayList<>();
        List<Oldman> oldmanList_add=new ArrayList<>();
        List<Card> cardList_add=new ArrayList<>();

        //批量更新
        List<Linkman> linkmanList_update=new ArrayList<>();
        List<OldmanHealth> healthList_update=new ArrayList<>();
        List<Oldman> oldmanList_update=new ArrayList<>();//对已存在的老人进行批量更新


        String  fix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        Workbook wb0;
        if(fix.equals("xls"))
            wb0= new HSSFWorkbook(file.getInputStream());
        else
            wb0=new XSSFWorkbook(file.getInputStream());

        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);

        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int successUpdate=0;//导入数量中  更新的个数
        int successAdd=0;//导入数量中  增加的个数
//        int successDel=0;//删除的个数


        int start=2;

        List<Integer> xqIds=null;
        Integer organId = commonService.getIdBySession();
        if (organId == null || organId == 0) {
            //管理员
        } else {
            xqIds = autoValueService.getXqIdsByUsername(commonService.getUserNameBySession());
        }
        List<Oldman> orgOldmans=oldmanBaseDao.getOrganOldmans(xqIds);
        if(mapAutoValue.size()==0){
            List<Integer> autoIds=commonService.getAutoValueTypes("importOldman");
            List<AutoValue> autoValueList=autoValueService.getByTypeList(autoIds);
            autoValueList.forEach(s->mapAutoValue.put(s.getType()+s.getValue(),s.getId()+""));//key 是type+value
        }
        if(mapHealthSelect.size()==0){
            List<HealthSelect> healthSelectList=oldmanHealthDao.getAllHealthSelect();
            healthSelectList.forEach(s->mapHealthSelect.put(s.getSecTypeName(),s.getId()));//key 是type+value
        }

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
                    if(commonService.excelIsNotNull(r.getCell(3)))
                    oldman.setName(r.getCell(3).getStringCellValue());

                        if (commonService.excelIsNotNull(r.getCell(4))) {
                            String sex = r.getCell(4).getStringCellValue();
                            sex = sex.replace("性", "");
                            oldman.setSex((sex.equals("男")) ? 2 : 1);
                        }
                    if(commonService.excelIsNotNull(r.getCell(5)))
                    oldman.setBirthday(Tool.stringToDate((r.getCell(5).getStringCellValue())));
                    if(commonService.excelIsNotNull(r.getCell(6)))
                    oldman.setPid(r.getCell(6).getStringCellValue());
                    if(commonService.excelIsNotNull(r.getCell(7)))
                    oldman.setAddress(r.getCell(7).getStringCellValue());

                    if(commonService.excelIsNotNull(r.getCell(8)))
                    oldman.setPhone(r.getCell(8).getStringCellValue());


                    //TODO  先按 居委的
                    if(r.getCell(2).getStringCellValue()!=null && !r.getCell(2).getStringCellValue().equals(""))
                        oldman.setXqId(Integer.parseInt(mapAutoValue.get(AutoValueEnum.XQ.getIndex()+r.getCell(2).getStringCellValue())));
                        // oldman.setXqId(autoValueService.getStringLikeIndex(r.getCell(2).getStringCellValue(), AutoValueEnum.XQ.getIndex(), "like"));
                    else{
                        continue;
                    }
//                    String politicalStatus = r.getCell(9).getStringCellValue().equals("") ? "群众" : r.getCell(9).getStringCellValue();
                    if(r.getCell(9).getStringCellValue()!=null && !r.getCell(9).getStringCellValue().equals(""))
                        oldman.setPoliticalStatus(mapAutoValue.get(AutoValueEnum.ZZMM.getIndex()+r.getCell(9).getStringCellValue()));
//                        oldman.setPoliticalStatus(autoValueDao.getStringLikeIndex(r.getCell(9).getStringCellValue(), AutoValueEnum.ZZMM.getIndex(), "like")+"");

                    if (commonService.excelIsNotNullOne(r.getCell(11))) {
                        oldman.setCensus(mapAutoValue.get(AutoValueEnum.HJ.getIndex()+"户籍"));
//                        Integer hjIndex = autoValueDao.getStringLikeIndex("户籍", AutoValueEnum.HJ.getIndex(), "equals");
//                        oldman.setCensus(hjIndex + "");
                    } else if (commonService.excelIsNotNullOne(r.getCell(12))) {
                        oldman.setCensus(mapAutoValue.get(AutoValueEnum.HJ.getIndex()+"非户籍"));
//                        Integer hjIndex = autoValueDao.getStringLikeIndex("非户籍", AutoValueEnum.HJ.getIndex(), "equals");
//                        oldman.setCensus(hjIndex + "");
                    } else if (commonService.excelIsNotNullOne(r.getCell(13))) {
                        oldman.setCensus(mapAutoValue.get(AutoValueEnum.HJ.getIndex()+"人户分离"));
//                        Integer hjIndex = autoValueDao.getStringLikeIndex("人户分离", AutoValueEnum.HJ.getIndex(), "equals");
//                        oldman.setCensus(hjIndex + "");
                    }

                    if (commonService.excelIsNotNullOne(r.getCell(14))) {
                        oldman.setZc(mapAutoValue.get(AutoValueEnum.ZC.getIndex()+"高级"));
//                        Integer zcIndex = autoValueDao.getStringLikeIndex("高级", AutoValueEnum.ZC.getIndex(), "equals");
//                        oldman.setZc(zcIndex + "");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(15))) {
                        oldman.setZc(mapAutoValue.get(AutoValueEnum.ZC.getIndex()+"副高级"));
//                        Integer zcIndex = autoValueDao.getStringLikeIndex("副高级", AutoValueEnum.ZC.getIndex(), "equals");
//                        oldman.setZc(zcIndex + "");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(16))) {
                        oldman.setZc(mapAutoValue.get(AutoValueEnum.ZC.getIndex()+"中级"));
//                        Integer zcIndex = autoValueDao.getStringLikeIndex("中级", AutoValueEnum.ZC.getIndex(), "equals");
//                        oldman.setZc(zcIndex + "");
                    }
                    String sqzw="";
                    if (commonService.excelIsNotNullOne(r.getCell(17))) {
                        sqzw=mapAutoValue.get(AutoValueEnum.SQZW.getIndex()+"三长");
//                        Integer szIndex = autoValueDao.getStringLikeIndex("三长", AutoValueEnum.SQZW.getIndex(), "equals");
//                        sqzw=szIndex+"";
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(18))) {
                        String sqIndex=mapAutoValue.get(AutoValueEnum.SQZW.getIndex()+"社区团队负责人");
//                        Integer sqIndex = autoValueDao.getStringLikeIndex("社区团队负责人", AutoValueEnum.SQZW.getIndex(), "equals");
                        if(sqzw.length()>1){
                            sqzw+="#"+sqIndex;
                        }
                    }
                    oldman.setSqzw(sqzw);


                    Linkman linkman = new Linkman();
                    if(commonService.excelIsNotNull(r.getCell(25)))
                    linkman.setName(r.getCell(25).getStringCellValue());
                    if(commonService.excelIsNotNull(r.getCell(26)))
                    linkman.setRelation(r.getCell(26).getStringCellValue());
                    if(commonService.excelIsNotNull(r.getCell(27)))
                    linkman.setPhone(r.getCell(27).getStringCellValue());


                    //is  字段中的  healthadd 只有在 insert时进行添加  update不改变
                    OldmanHealth health = new OldmanHealth();
                    if(commonService.excelIsNotNull(r.getCell(10)))
                    health.setBloodType(r.getCell(10).getStringCellValue());
//                    health.setIntelligence("");
//                    health.setEyesight("");

                    if (commonService.excelIsNotNullOne(r.getCell(55))) {
                        health.setIntelligence(mapAutoValue.get(AutoValueEnum.SZ.getIndex()+"痴呆"));
//                        Integer IndexSZ = autoValueDao.getStringLikeIndex("痴呆", AutoValueEnum.SZ.getIndex(), "like");
//                        health.setIntelligence(IndexSZ + "");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(56))) {
                        health.setIntelligence(mapAutoValue.get(AutoValueEnum.SZ.getIndex()+"智障"));
//                        Integer IndexSZ = autoValueDao.getStringLikeIndex("智障", AutoValueEnum.SZ.getIndex(), "like");
//                        health.setIntelligence(IndexSZ + "");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(57))) {
                        health.setIntelligence(mapAutoValue.get(AutoValueEnum.SZ.getIndex()+"正常"));
//                        Integer IndexSZ = autoValueDao.getStringLikeIndex("正常", AutoValueEnum.SZ.getIndex(), "like");
//                        health.setIntelligence(IndexSZ + "");
                    }

                    if (commonService.excelIsNotNullOne(r.getCell(58))) {
                        health.setEyesight(mapAutoValue.get(AutoValueEnum.SL.getIndex()+"失明"));
//                        Integer IndexSZ = autoValueDao.getStringLikeIndex("失明", AutoValueEnum.SL.getIndex(), "like");
//                        health.setIntelligence(IndexSZ + "");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(59))) {
                        health.setEyesight(mapAutoValue.get(AutoValueEnum.SL.getIndex()+"一般障碍"));
//                        Integer IndexSZ = autoValueDao.getStringLikeIndex("一般障碍", AutoValueEnum.SL.getIndex(), "like");
//                        health.setIntelligence(IndexSZ + "");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(60))) {
                        health.setEyesight(mapAutoValue.get(AutoValueEnum.SL.getIndex()+"正常"));
//                        Integer IndexSZ = autoValueDao.getStringLikeIndex("正常", AutoValueEnum.SL.getIndex(), "like");
//                        health.setIntelligence(IndexSZ + "");
                    }



                    List<Integer> selectIdList = new ArrayList<>();
                    if (commonService.excelIsNotNullOne(r.getCell(28))) {
                        selectIdList.add(mapHealthSelect.get("青霉素"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("青霉素", HealthEnum.YW.getIndex()));
                        health.setIsYwfy(HealthEnum.YW.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(29))) {
                        selectIdList.add(mapHealthSelect.get("磺胺"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("磺胺", HealthEnum.YW.getIndex()));
                        health.setIsYwfy(HealthEnum.YW.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(30))) {
                        selectIdList.add(mapHealthSelect.get("四环素"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("四环素", HealthEnum.YW.getIndex()));
                        health.setIsYwfy(HealthEnum.YW.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(31))) {
                        selectIdList.add(mapHealthSelect.get("其他"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("其他", HealthEnum.YW.getIndex()));
                        health.setIsYwfy(HealthEnum.YW.getIndex());
                    }

                    if (commonService.excelIsNotNullOne(r.getCell(32))) {
                        selectIdList.add(mapHealthSelect.get("高血压"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("高血压", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(33))) {
                        selectIdList.add(mapHealthSelect.get("糖尿病"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("糖尿病", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(34))) {
                        selectIdList.add(mapHealthSelect.get("脑卒中（脑出血、脑梗塞）"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("脑卒中", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(35))) {
                        selectIdList.add(mapHealthSelect.get("帕金森"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("帕金森", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(36))) {
                        selectIdList.add(mapHealthSelect.get("癫痫"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("癫痫", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(37))) {
                        selectIdList.add(mapHealthSelect.get("肺炎"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("肺炎", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(38))) {
                        selectIdList.add(mapHealthSelect.get("慢阻肺"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("慢阻肺", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(39))) {
                        selectIdList.add(mapHealthSelect.get("冠心病"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("冠心病", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(40))) {
                        selectIdList.add(mapHealthSelect.get("甲亢/甲减"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("甲亢/甲减", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(41))) {
                        selectIdList.add(mapHealthSelect.get("慢性肾功能障碍"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("慢性肾功能障碍", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(42))) {
                        selectIdList.add(mapHealthSelect.get("肝炎/肝硬化"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("肝炎/肝硬化", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(43))) {
                        selectIdList.add(mapHealthSelect.get("恶性肿瘤"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("恶性肿瘤", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(44))) {
                        selectIdList.add(mapHealthSelect.get("骨折"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("骨折", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(45))) {
                        selectIdList.add(mapHealthSelect.get("其他消化道疾病"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("其他消化道疾病", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(46))) {
                        selectIdList.add(mapHealthSelect.get("类风关"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("类风关", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }

                    if (commonService.excelIsNotNullOne(r.getCell(49))) {
                        selectIdList.add(mapHealthSelect.get("上厕所"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("上厕所", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(50))) {
                        selectIdList.add(mapHealthSelect.get("洗澡"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("洗澡", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(51))) {
                        selectIdList.add(mapHealthSelect.get("穿衣"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("穿衣", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(52))) {
                        selectIdList.add(mapHealthSelect.get("上下床"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("上下床", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(53))) {
                        selectIdList.add(mapHealthSelect.get("室内行走"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("室内行走", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(54))) {
                        selectIdList.add(mapHealthSelect.get("吃饭"));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("吃饭", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }


                    List<HealthAdd> healthAddList = new ArrayList<>();
                    if (commonService.excelIsNotNull(r.getCell(47))) {
                        health.setIsExzl(HealthEnum.EXZL.getIndex());
                        String[] add = r.getCell(47).getStringCellValue().split("#");
                        for (int i = 0; i < add.length; i++) {
                            HealthAdd healthAdd = new HealthAdd();
                            healthAdd.setDesc(add[i]);
                            healthAdd.setType(HealthEnum.EXZL.getIndex());
                            healthAddList.add(healthAdd);
                        }
                    }
                    if (commonService.excelIsNotNull(r.getCell(48))) {
                        health.setIsGz(HealthEnum.GZ.getIndex());
                        String[] add = r.getCell(48).getStringCellValue().split("#");
                        for (int i = 0; i < add.length; i++) {
                            HealthAdd healthAdd = new HealthAdd();
                            healthAdd.setDesc(add[i]);
                            healthAdd.setType(HealthEnum.GZ.getIndex());
                            healthAddList.add(healthAdd);
                        }
                    }

                    if (commonService.excelIsNotNull(r.getCell(61))) {
                        health.setIsCj(HealthEnum.CJQK.getIndex());
                        String[] add = r.getCell(61).getStringCellValue().split("#");
                        for (int i = 0; i < add.length; i++) {
                            HealthAdd healthAdd = new HealthAdd();
                            healthAdd.setDesc(add[i]);
                            healthAdd.setType(HealthEnum.CJQK.getIndex());
                            healthAddList.add(healthAdd);
                        }
                    }

                    if (commonService.excelIsNotNullOne(r.getCell(62))) {
                        oldman.setFamily(mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+"纯老"));
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("纯老", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(63))) {
                        oldman.setFamily(mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+"独居"));
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("独居", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(64))) {
                        oldman.setFamily(mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+"失独"));
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("失独", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(65))) {
                        oldman.setFamily(mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+"一老养一老"));
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("一老养", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(66))) {
                        oldman.setFamily(mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+"孤老"));
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("孤老", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(67))) {
                        oldman.setFamily(mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+"三支人员"));
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("三支人员", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(68))) {
                        oldman.setFamily(mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+"其他"));
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("其他", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }

                    String familyType="";
                    if (commonService.excelIsNotNullOne(r.getCell(20))) {
                        familyType+=mapAutoValue.get(AutoValueEnum.JTLB.getIndex()+"独生子女家庭");
//                       familyType+=autoValueDao.getStringLikeIndex("独生子女家庭", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(21))) {
                        familyType+=mapAutoValue.get(AutoValueEnum.JTLB.getIndex()+"军属");
//                        familyType+=autoValueDao.getStringLikeIndex("军属", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(22))) {
                        familyType+=mapAutoValue.get(AutoValueEnum.JTLB.getIndex()+"烈士家庭");
//                        familyType+=autoValueDao.getStringLikeIndex("烈士家庭", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(23))) {
                        familyType+=mapAutoValue.get(AutoValueEnum.JTLB.getIndex()+"离休干部");
//                        familyType+=autoValueDao.getStringLikeIndex("离休干部", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(24))) {
                        familyType+=mapAutoValue.get(AutoValueEnum.JTLB.getIndex()+"侨属");
//                        familyType+=autoValueDao.getStringLikeIndex("侨属", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if(!familyType.equals("")){
                        familyType=familyType.substring(0,familyType.length()-1);
                        oldman.setFamilyType(familyType);
                    }



                    if (commonService.excelIsNotNullOne(r.getCell(69))) {
                        oldman.setEconomic(mapAutoValue.get(AutoValueEnum.JJTJ.getIndex()+"帮困"));
//                        oldman.setEconomic(autoValueDao.getStringLikeIndex("帮困", AutoValueEnum.JJTJ.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(70))) {
                        oldman.setEconomic(mapAutoValue.get(AutoValueEnum.JJTJ.getIndex()+"低保"));
//                        oldman.setEconomic(autoValueDao.getStringLikeIndex("低保", AutoValueEnum.JJTJ.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(71))) {
                        oldman.setEconomic(mapAutoValue.get(AutoValueEnum.JJTJ.getIndex()+"养老保险"));
//                        oldman.setEconomic(autoValueDao.getStringLikeIndex("养老保险", AutoValueEnum.JJTJ.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(72))) {
                        oldman.setEconomic(mapAutoValue.get(AutoValueEnum.JJTJ.getIndex()+"医疗救助金"));
//                        oldman.setEconomic(autoValueDao.getStringLikeIndex("医疗救助金", AutoValueEnum.JJTJ.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(73))) {
                        oldman.setEconomic(mapAutoValue.get(AutoValueEnum.JJTJ.getIndex()+"城镇医保"));
//                        oldman.setEconomic(autoValueDao.getStringLikeIndex("城镇医保", AutoValueEnum.JJTJ.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(74))) {
                        oldman.setEconomic(mapAutoValue.get(AutoValueEnum.JJTJ.getIndex()+"其他"));
//                        oldman.setEconomic(autoValueDao.getStringLikeIndex("其他", AutoValueEnum.JJTJ.getIndex(), "like")+"");
                    }

                    if(commonService.excelIsNotNullOne(r.getCell(19))){
                        oldman.setIsVolunteer(1);
                    }else {
                        oldman.setIsVolunteer(0);
                    }

                    Boolean exist=orgOldmans.contains(oldman);

                    if(exist){
                        //更新
                        successUpdate++;

                        Integer oldmanId=orgOldmans.get(orgOldmans.indexOf(oldman)).getId();
                        oldman.setId(oldmanId);
                        existOldmanIds.add(oldmanId);

                        oldman.setId(oldmanId);
                        oldmanList_update.add(oldman);

                        linkman.setOldmanId(oldmanId);
                        linkmanList_update.add(linkman);

                        health.setOldmanId(oldmanId);
                        healthList_update.add(health);

                    }else{
                        //添加
                        successAdd++;
                        if(oldmanIdStrat!=0){
                            oldman.setId(oldmanIdStrat++);
                            oldmanList_add.add(oldman);
                        }else {
                            oldmanBaseDao.save(oldman);
                            oldmanIdStrat=oldman.getId()+1;
                        }

                        existOldmanIds.add(oldman.getId());

                        linkman.setOldmanId(oldman.getId());
                        linkmanList_add.add(linkman);

                        health.setOldmanId(oldman.getId());
                        healthList_add.add(health);


                        Card card=new Card();
                        card.setOldmanId(oldman.getId());
                        card.setCid(oldman.getPid().substring(oldman.getPid().length()-6));
                        card.setPassword("123456");
                        cardList_add.add(card);


                    }

                    if(selectIdList!=null && selectIdList.size()>0) {
                        for (Integer index : selectIdList) {
                            HealthSelectMan healthSelectMan = new HealthSelectMan();
                            healthSelectMan.setOldmanId(oldman.getId());
                            healthSelectMan.setHealthSelectId(index);
                            healthSelectManList_add.add(healthSelectMan);
                        }
                    }
                    if(healthAddList!=null && healthAddList.size()>0) {
                        for (HealthAdd healthAdd : healthAddList) {
                            if(!healthAdd.getDesc().trim().equals("")) {
                                HealthAdd add = new HealthAdd();
                                add.setOldmanId(oldman.getId());
                                add.setType(healthAdd.getType());
                                add.setDesc(healthAdd.getDesc());
                                healthAddList_add.add(add);
                            }
                        }
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
        //添加
        if(linkmanList_add.size()>0)
            linkmanDao.saveAll(linkmanList_add);
        if(healthList_add.size()>0)
            oldmanHealthDao.saveAll(healthList_add);
        if(oldmanList_add.size()>0)
            oldmanBaseDao.saveAll(oldmanList_add);

        if(existOldmanIds.size()>0)
            healthSelectManDao.delByOldmanIds(existOldmanIds);
        if(healthSelectManList_add.size()>0) {
            //先把之前的记录删掉
            healthSelectManDao.saveAll(healthSelectManList_add);
        }
        if(healthAddList_add.size()>0)
            healthAddDao.saveAll(healthAddList_add);

//        oldmanBaseDao.delVolunteerByXqIds(existOldmanIds,xqIds);


        cardDao.delByOldmanIds(existOldmanIds,xqIds);
        cardDao.ableByOldmanIds(existOldmanIds,xqIds);
        if(cardList_add.size()>0){
            cardDao.saveAll(cardList_add);
        }



        //老人不可用  机构范围
        excelReturnModel.setSuccessDel(oldmanBaseDao.setDisabled(existOldmanIds,xqIds));

        excelReturnModel.setNumSuccess(numSuccess);
        excelReturnModel.setSuccessAdd(successAdd);
        excelReturnModel.setSuccessUpdate(successUpdate);
        excelReturnModel.setNumFail(excelReturnModel.getFail().size());
        excelReturnModel.setTotal(numSuccess+excelReturnModel.getNumFail());//一共

        return new Result(true,excelReturnModel);
    }


    @Override
    public Result getIntegralByOldmanId(int oldmanId) {
        OrganQueryIntegralModel organQueryIntegralModel=oldmanWrapper.wrapInregral(oldmanBaseDao.getIntegralByOldmanId(oldmanId));
        if(organQueryIntegralModel!=null)
            return new Result(true,organQueryIntegralModel);
        else return new Result(false,"找不到");
    }

    @Override
    public Result getById(int id, String type) {
        switch (type){
            case "base":
                Oldman oldman=oldmanBaseDao.getById(id);
//                oldman.setSqzw(oldman.getSqzw().replace("s",""));
                oldman.setBirthdayTime(Tool.dateToString(oldman.getBirthday(), TimeConstant.DATA_FORMAT_YMD));
                return new Result(true,oldman);
            case "linkman":
                Linkman linkman=linkmanDao.getByOldmanId(id);
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
            case "linkman":
                Linkman linkman=(Linkman) dbEntity;
                linkmanDao.updateByOldmanId(linkman);
                break;
            case "health":
                OldmanHealth oldmanHealth=(OldmanHealth) dbEntity;
                healthSelectManDao.delByOldmanId(oldmanHealth.getOldmanId());
                List<HealthSelectMan> healthSelectManList=new ArrayList<>();
                if(oldmanHealth.getHealthSelectIds()!=null && oldmanHealth.getHealthSelectIds().size()>0){
                    for(Integer id:oldmanHealth.getHealthSelectIds()){
                        Integer firType=healthSelectDao.getFirTypeById(id);
                        if(firType==HealthEnum.MB.getIndex()){
                            oldmanHealth.setIsMb(1);
                        }
                        if(firType==HealthEnum.SN.getIndex()){
                            oldmanHealth.setIsSn(1);
                        }
                        if(firType==HealthEnum.YW.getIndex()){
                            oldmanHealth.setIsYwfy(1);
                        }
                        HealthSelectMan healthSelectMan=new HealthSelectMan();
                        healthSelectMan.setHealthSelectId(id);
                        healthSelectMan.setOldmanId(oldmanHealth.getOldmanId());
                        healthSelectManList.add(healthSelectMan);
                    }
                }
                if(healthSelectManList.size()>0)
                    healthSelectManDao.saveAll(healthSelectManList);
                healthAddDao.delByOldmanId(oldmanHealth.getOldmanId());
                List<HealthAdd> healthAddList=new ArrayList<>();
                if(oldmanHealth.getHealthAdd_exzl()!=null && oldmanHealth.getHealthAdd_exzl().size()>0){
                    oldmanHealth.setIsExzl(1);
                    for(String s:oldmanHealth.getHealthAdd_exzl()){
                        HealthAdd healthAdd=new HealthAdd();
                        healthAdd.setOldmanId(oldmanHealth.getOldmanId());
                        healthAdd.setType(HealthEnum.EXZL.getIndex());
                        healthAdd.setDesc(s);
                        healthAddList.add(healthAdd);
                    }
                }
                if(oldmanHealth.getHealthAdd_gz()!=null && oldmanHealth.getHealthAdd_gz().size()>0){
                    oldmanHealth.setIsGz(1);
                    for(String s:oldmanHealth.getHealthAdd_gz()){
                        HealthAdd healthAdd=new HealthAdd();
                        healthAdd.setOldmanId(oldmanHealth.getOldmanId());
                        healthAdd.setType(HealthEnum.GZ.getIndex());
                        healthAdd.setDesc(s);
                        healthAddList.add(healthAdd);
                    }
                }
                if(oldmanHealth.getHealthAdd_cj()!=null && oldmanHealth.getHealthAdd_cj().size()>0){
                    oldmanHealth.setIsCj(1);
                    for(String s:oldmanHealth.getHealthAdd_cj()){
                        HealthAdd healthAdd=new HealthAdd();
                        healthAdd.setOldmanId(oldmanHealth.getOldmanId());
                        healthAdd.setType(HealthEnum.CJQK.getIndex());
                        healthAdd.setDesc(s);
                        healthAddList.add(healthAdd);
                    }
                }
                if(healthAddList.size()>0)
                    healthAddDao.saveAll(healthAddList);

                oldmanHealthDao.updateByOldmanId(oldmanHealth);
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

    @Override
    public Oldman getOldStatusNum() {
        return oldmanBaseDao.getOldStatusNum();
    }
}
