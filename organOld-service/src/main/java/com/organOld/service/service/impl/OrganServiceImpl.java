package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.SysUser;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.*;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.*;
import com.organOld.service.enumModel.AutoValueEnum;
import com.organOld.service.enumModel.OldStatusEnum;
import com.organOld.service.enumModel.OrganFirEnum;
import com.organOld.service.model.*;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.OrganService;
import com.organOld.service.service.UserService;
import com.organOld.service.util.Email;
import com.organOld.service.util.ImgUpload;
import com.organOld.service.util.Tool;
import com.organOld.service.wrapper.Wrappers;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

import java.util.stream.Collectors;

@Service
public class OrganServiceImpl implements OrganService{

    @Autowired
    OrganDao organDao;
    @Autowired
    CommonService commonService;
    @Autowired
    OrganOldmanDao organOldmanDao;
    @Autowired
    UserService userService;
    @Autowired
    OrganRegDao organRegDao;
    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    OrganTypeDao organTypeDao;
    @Autowired
    OldmanDao oldmanDao;
    @Autowired
    UserDao userDao;
    @Autowired
    OldmanKeyHandleDao oldmanKeyHandleDao;
    @Autowired
    OrganServiceRecordDao organServiceRecordDao;


    @Override
    public String getByPage(OrganRequest organRequest, BTableRequest bTableRequest) {
        Page<Organ> page=commonService.getPage(bTableRequest,"organ");
        Organ organ= Wrappers.organWrapper.unwrap(organRequest);
        page.setEntity(organ);
        List<OrganModel> organModelList=organDao.getByPage(page).stream().map(Wrappers.organWrapper::wrap).collect(Collectors.toList());
        Long size=organDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organModelList);
    }

    @Override
    public String getManByPage(BTableRequest bTableRequest, OrganOldmanRequest organOrganManRequest) {
        Page<OrganOldman> page=commonService.getPage(bTableRequest,"organ_man");
        OrganOldman organOldman= Wrappers.organOldmanWrapper.unwrap(organOrganManRequest);
        page.setEntity(organOldman);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getByPage(page).stream().map(Wrappers.organOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=organOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public OrganModel getBySession(HttpSession httpSession) {
        Integer organId=commonService.getIdBySession();
        return getById(organId);
    }

    @Override
    public OrganModel getById(int organId) {
        OrganModel organModel=Wrappers.organWrapper.wrap(organDao.getById(organId));
        List<AutoValue> districtList=autoValueDao.getByType(AutoValueEnum.PQ.getIndex());
        organModel.setDistrictList(districtList);
        List<OrganType> organTypeList=organTypeDao.getByFirType(organModel.getOrganFirTypeId());
        organModel.setOrganTypeList(organTypeList);
        List<Organ> parentOrganList=organDao.getByType(33);//针对居委
        organModel.setParentOrganList(parentOrganList);
        return organModel;

    }

    @Override
    public OrganAddModel getAddInfo(int firType) {
        OrganAddModel organAddModel=new OrganAddModel();
        List<AutoValue> districtList=autoValueDao.getByType(AutoValueEnum.PQ.getIndex());
        organAddModel.setDistrictList(districtList);
        List<OrganType> organTypeList=organTypeDao.getByFirType(firType);
        organAddModel.setOrganTypeList(organTypeList);
        List<Organ> parentOrganList=organDao.getByType(33);//针对居委
        organAddModel.setParentOrganList(parentOrganList);
        organAddModel.setOrganTypeId(firType);
        return organAddModel;
    }

    @Override
    public Result pass(int organId) {
        Organ organ=new Organ();
        organ.setId(organId);
        organ.setStatus("2");
        organDao.updateById(organ);

        OrganReg organReg=organRegDao.getByOrganId(organId);
        SysUser user=newAccount(organId);
        String content=String.format("您的账号:%s<br>密码：%s",user.getUsername(),user.getPassword());
        Email.send(organReg.getEmail(),content);

        return new Result(true);
    }

    @Override
    public Result reject(int organId) {
        OrganReg organReg=organRegDao.getByOrganId(organId);
        String content=String.format("抱歉您的审核未通过");
        Email.send(organReg.getEmail(),content);

        Organ organ=new Organ();
        organ.setId(organId);
        organ.setStatus("3");
        organDao.updateById(organ);
        return new Result(true);
    }

    @Override
    @Transactional
    public void cancel(int organId) {
        OrganReg organReg=organRegDao.getByOrganId(organId);
        String content=String.format("抱歉您被撤销了");
        Email.send(organReg.getEmail(),content);

        Organ organ=new Organ();
        organ.setId(organId);
        organ.setStatus("4");
        organDao.updateById(organ);

        userDao.setDisableByOrganId(organId);
    }

    /**
     * 为机构注册新账号
     * @param organId
     */
    @Transactional
    SysUser newAccount(int organId) {
        SysUser user=createUser(organId);
        userService.save(user);
        userService.setUserOrgan(user.getId(),organId);
        userService.setUserRole(user.getId(),9);
        return user;
    }

    private SysUser createUser(int organId) {
        SysUser sysUser=new SysUser();
        String username="Organ"+organId;
        String password="000000";
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        return sysUser;
    }

    @Override
    public List<Organ> getByType(int type) {
        return organDao.getSimpleByType(2,0);
    }

    @Override
    public OrganRegInfoModel getRegInfo() {
        OrganRegInfoModel organRegInfoModel=new OrganRegInfoModel();
        List<Integer> typeList=commonService.getAutoValueTypes("organ_reg");
        List<AutoValue> district=autoValueDao.getByTypeList(typeList);
        organRegInfoModel.setDistrict(district);
        organRegInfoModel.setOrganTypeList(organTypeDao.getByFirType(OrganFirEnum.SH.getIndex()));
        return organRegInfoModel;
    }

    @Override
    @Transactional
    public Result reg(OrganRegRequest organRegRequest, HttpServletRequest request) {
        Organ organ=Wrappers.organWrapper.unwrapRegOrgan(organRegRequest,request);
        organ.setStatus("1");
        OrganReg organReg=Wrappers.organWrapper.unwrapRegOrganReg(organRegRequest);
        organDao.save(organ);
        organReg.setOrganId(organ.getId());
        organRegDao.save(organReg);
        return new Result(true,"注册成功！请等待审核");
    }

    @Override
    public Integer addOrUpdate(OrganRegRequest organRegRequest, HttpServletRequest request, String type) {
        Organ organ=Wrappers.organWrapper.unwrapRegOrgan(organRegRequest,request);
        if(type.equals("update")) organDao.updateById(organ);
        else organDao.save(organ);
        return organ.getId();
    }

    @Override
    public Result getRoleOrgan(int type, int typeIndex) {
        return new Result(true,organDao.getRoleOrgan(type,typeIndex));
    }

    @Override
    public List<OrganType> getAllOldmanType() {
        return organTypeDao.getAllOldmanType();
    }


    @Override
    public List<OrganType> getByFirType(int firType) {
        return organTypeDao.getByFirType(firType);
    }


    @Override
    public List<Organ> getByOrganFirType(int firType) {
        return organDao.getByFirType(firType);
    }

    @Override
    public Result importExcel(MultipartFile file, int type, HttpServletRequest request) throws IOException {
        List<Organ> organList=new ArrayList<>();
        Workbook wb0 = new HSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        int start=0;
        if(type==21 || type==22){
            start=2;
        }else{
            start=1;
        }


        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int successAdd=0;//导入数量中  增加的个数

        //得到所有的图片  一个机构一张图片  key是行号
        Map<Integer, PictureData> sheetIndexPicMap = getSheetPictrues03( (HSSFSheet) sht0, (HSSFWorkbook) wb0);

        Map<Integer,String> picPath= ImgUpload.excelImg(sheetIndexPicMap,request,"organ");


        for (Row r : sht0) {
            try {
                if (r.getRowNum() >= start) {
                    //遍历 cell  将单元格 格式 全都转换成String 类型
//                    Iterator<Cell> cells = r.cellIterator();    //获得第一行的迭代器
//                    while (cells.hasNext()) {
//                        Cell cell = cells.next();
//
//                        cell.setCellType(Cell.CELL_TYPE_STRING);
//                    }
                    //创建实体类
                    Organ organ=new Organ();
                    if(type==21 || type==22) {
                        if (r.getCell(0).getStringCellValue() != null && !r.getCell(0).getStringCellValue().equals("")) {
                            organ.setName(r.getCell(0).getStringCellValue());
                        }else{
                            continue;
                        }
                        if (r.getCell(1).getStringCellValue() != null && !r.getCell(1).getStringCellValue().equals("")) {
                            organ.setIntro(r.getCell(1).getStringCellValue());
                        }
                        r.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                        if (r.getCell(2).getStringCellValue() != null && !r.getCell(2).getStringCellValue().equals("")) {
                            organ.setNum(Integer.parseInt(r.getCell(2).getStringCellValue()));
                        }
                        if (r.getCell(3).getStringCellValue() != null && !r.getCell(3).getStringCellValue().equals("")) {
                            organ.setWork(r.getCell(3).getStringCellValue());
                        }
                        if (r.getCell(4).getStringCellValue() != null && !r.getCell(4).getStringCellValue().equals("")) {
                            organ.setInstitution(r.getCell(4).getStringCellValue());
                        }
                        if (r.getCell(5).getStringCellValue() != null && !r.getCell(5).getStringCellValue().equals("")) {
                            organ.setRequire(r.getCell(5).getStringCellValue());
                        }
                        if (r.getCell(6).getStringCellValue() != null && !r.getCell(6).getStringCellValue().equals("")) {
                            organ.setServiceTime(r.getCell(6).getStringCellValue());
                        }
                        if (r.getCell(7).getStringCellValue() != null && !r.getCell(7).getStringCellValue().equals("")) {
                            organ.setAddress(r.getCell(7).getStringCellValue());
                        }
                        r.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
                        if (r.getCell(8).getStringCellValue() != null && !r.getCell(8).getStringCellValue().equals("")) {
                            organ.setPhone(r.getCell(8).getStringCellValue());
                        }
                        if (r.getCell(9).getStringCellValue() != null && !r.getCell(9).getStringCellValue().equals("")) {
                            organ.setWebUrl(r.getCell(9).getStringCellValue());
                        }
                        r.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
                        r.getCell(12).setCellType(Cell.CELL_TYPE_STRING);
                        r.getCell(13).setCellType(Cell.CELL_TYPE_STRING);
                        r.getCell(14).setCellType(Cell.CELL_TYPE_STRING);
                        r.getCell(15).setCellType(Cell.CELL_TYPE_STRING);
                        int total = 0; //1养老院  2长者  3 日照  4日托  8助餐
                        if (r.getCell(11).getStringCellValue() != null && r.getCell(11).getStringCellValue().equals("1")) {
                            total += 1;
                        }
                        if (r.getCell(12).getStringCellValue() != null && r.getCell(12).getStringCellValue().equals("1")) {
                            total += 2;
                        }
                        if (r.getCell(13).getStringCellValue() != null && r.getCell(13).getStringCellValue().equals("1")) {
                            total += 3;
                        }
                        if (r.getCell(14).getStringCellValue() != null && r.getCell(14).getStringCellValue().equals("1")) {
                            total += 4;
                        }
                        if (r.getCell(15).getStringCellValue() != null && r.getCell(15).getStringCellValue().equals("1")) {
                            total += 8;
                        }
                        switch (total) {
                            case 1:
                                organ.setOrganTypeId(26);
                                break;
                            case 2:
                                organ.setOrganTypeId(27);
                                break;
                            case 3:
                                organ.setOrganTypeId(28);
                                break;
                            case 8:
                                organ.setOrganTypeId(29);
                                break;
                            case 5:
                                organ.setOrganTypeId(34);
                                break;
                            case 4:
                                organ.setOrganTypeId(35);
                                break;
                        }
                    }else if(type==1){
                        if (r.getCell(1).getStringCellValue() != null && !r.getCell(1).getStringCellValue().equals("")) {
                            organ.setName(r.getCell(1).getStringCellValue());
                        }else{
                            continue;
                        }
                        if (r.getCell(2).getStringCellValue() != null && !r.getCell(2).getStringCellValue().equals("")) {
                            organ.setIntro(r.getCell(2).getStringCellValue());
                        }

                        if (r.getCell(3).getStringCellValue() != null && !r.getCell(3).getStringCellValue().equals("")) {
                            organ.setWork(r.getCell(3).getStringCellValue());
                        }
                        if (r.getCell(4).getStringCellValue() != null && !r.getCell(4).getStringCellValue().equals("")) {
                            organ.setServiceTime(r.getCell(4).getStringCellValue());
                        }
                        if (r.getCell(5).getStringCellValue() != null && !r.getCell(5).getStringCellValue().equals("")) {
                            organ.setAddress(r.getCell(5).getStringCellValue());
                        }
                        r.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                        if (r.getCell(6).getStringCellValue() != null && !r.getCell(6).getStringCellValue().equals("")) {
                            organ.setPhone(r.getCell(6).getStringCellValue());
                        }
                        if (r.getCell(7).getStringCellValue() != null && !r.getCell(7).getStringCellValue().equals("")) {
                            organ.setWebUrl(r.getCell(7).getStringCellValue());
                        }
                        organ.setOrganTypeId((int) r.getCell(9).getNumericCellValue());
                    }
                    organ.setImgUrl(picPath.get(r.getRowNum()));
                    organList.add(organ);
                    numSuccess++;
                    successAdd++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                excelReturnModel.getFail().add(r.getRowNum() + 1);
            }
        }
        excelReturnModel.setNumFail(excelReturnModel.getFail().size());
        excelReturnModel.setSuccessAdd(successAdd);
        excelReturnModel.setNumSuccess(numSuccess);
        excelReturnModel.setTotal(numSuccess+excelReturnModel.getNumFail());//一共
        organDao.saveAll(organList);
        return new Result(true,excelReturnModel);
    }



    public static Map<Integer, PictureData> getSheetPictrues03(HSSFSheet sheet, HSSFWorkbook workbook) {

        Map<Integer, PictureData> sheetIndexPicMap = new HashMap<Integer, PictureData>();
        List<HSSFPictureData> pictures = workbook.getAllPictures();
        if (pictures.size() != 0) {
            for (HSSFShape shape : sheet.getDrawingPatriarch().getChildren()) {
                HSSFClientAnchor anchor = (HSSFClientAnchor) shape.getAnchor();
                if (shape instanceof HSSFPicture) {
                    HSSFPicture pic = (HSSFPicture) shape;
                    int pictureIndex = pic.getPictureIndex() - 1;
                    HSSFPictureData picData = pictures.get(pictureIndex);
                    int picIndex = anchor.getRow1();
                    sheetIndexPicMap.put(picIndex, picData);
                }
            }
            return sheetIndexPicMap;
        } else {
            return null;
        }
    }


    @Override
    @Transactional
    public Result importManExcel(MultipartFile file) throws IOException {
        List<OrganOldman> organOldmanList=new ArrayList<>();
        Workbook wb0 = new HSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        int start=1;

        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int successAdd=0;//导入数量中  增加的个数

        Integer organId=commonService.getIdBySession();
        int oldStatus=0;//养老状态
        Organ organ=organDao.getById(organId);
        if(organ.getOrganFirTypeId()==21){
            oldStatus= OldStatusEnum.JG.getIndex();
        }else if(organ.getOrganFirTypeId()==22){
            oldStatus=OldStatusEnum.SQ.getIndex();

        }
        List<Oldman> oldmanList=new ArrayList<>();//用于更新老人 养老状态


        List<Oldman> organExistOldman=organOldmanDao.getByOrganId(organId);//先存储 该机构所有的老人 ，筛选出去掉的老人

        for (Row r : sht0) {
            try {
                if (r.getRowNum() >= start) {
                    //创建实体类
                    OrganOldman organOldman=new OrganOldman();
                    organOldman.setOrganId(organId);


                        if (r.getCell(1).getStringCellValue() != null && !r.getCell(1).getStringCellValue().equals("")) {
                        }else{
                            throw new Exception();
                        }
                        if (r.getCell(2).getStringCellValue() != null && !r.getCell(2).getStringCellValue().equals("")) {
                            Integer oldmanId=commonService.checkOldmanExiest(r.getCell(2).getStringCellValue());
                            Oldman exiOldman = oldmanDao.getById(oldmanId);
                            if(oldmanId!=null && oldmanId!=0){
                                if(oldStatus==2) {
                                    //社区养老
                                    switch (exiOldman.getOldStatus()) {
                                        case 3:
                                        case 4:
                                            //之前是居家养老 或者社区居家
                                            oldStatus = OldStatusEnum.SJ.getIndex();
                                            break;
                                    }
                                }
                                Oldman oldman=new Oldman();
                                oldman.setId(oldmanId);
                                oldman.setPid(r.getCell(2).getStringCellValue());
                                oldman.setIsHandle(2);
                                if (r.getCell(5).getStringCellValue() != null && r.getCell(5).getStringCellValue().equals("0")){
                                    //排队的  保持以前的养老状态
                                    organOldman.setNum(r.getCell(5).getStringCellValue());
                                    oldman.setOldStatus(exiOldman.getOldStatus());
                                    if (r.getCell(6).getStringCellValue() != null && !r.getCell(6).getStringCellValue().equals("")){
                                        organOldman.setApplyTime(Tool.stringToDate(r.getCell(6).getStringCellValue()));
                                        oldman.setIsHandle(exiOldman.getIsHandle());
                                    }
                                }else if(r.getCell(5).getStringCellValue() != null && !r.getCell(5).getStringCellValue().equals("") && !r.getCell(5).getStringCellValue().equals("0")){
                                    oldman.setOldStatus(oldStatus);
                                    organOldman.setNum(r.getCell(5).getStringCellValue());
                                }

                                if(organExistOldman.contains(oldman)){
                                    organExistOldman.remove(oldman);
                                }
                                oldmanList.add(oldman);
                                organOldman.setOldman(oldman);
                            }else{
                                throw new Exception();
                            }
                        }else{
                            throw new Exception();
                        }

                        if (r.getCell(3).getStringCellValue() != null && !r.getCell(3).getStringCellValue().equals("")) {
                            organOldman.setTimeIn(Tool.stringToDate(r.getCell(3).getStringCellValue()));
                        }
                        if (r.getCell(4).getStringCellValue() != null && !r.getCell(4).getStringCellValue().equals("")) {
                            organOldman.setTimeOut(Tool.stringToDate(r.getCell(4).getStringCellValue()));
                        }

                    organOldmanList.add(organOldman);
                    numSuccess++;
                    successAdd++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                excelReturnModel.getFail().add(r.getRowNum() + 1);
            }
        }
        excelReturnModel.setNumFail(excelReturnModel.getFail().size());
        excelReturnModel.setSuccessAdd(successAdd);
        excelReturnModel.setNumSuccess(numSuccess);
        excelReturnModel.setTotal(numSuccess+excelReturnModel.getNumFail());//一共
        //该机构 删除的老人 的养老状态   之前是机构养老 则变为0 之前是社区养老的 看看之前的养老状态是不是居家社区 看看有没有在其他的社区养老机构
        for(Oldman oldman:organExistOldman){
            if(organ.getOrganFirTypeId()==21){
                oldman.setOldStatus(0);
                oldman.setIsHandle(0);
            }else{
                int orgNum=organOldmanDao.getNumByOldmanId(oldman.getId());
                if(orgNum==1){
                    //没有其他家 社区机构
                    if(oldman.getOldStatus()==4){
                        //之前是 社区居家
                        oldman.setOldStatus(3);
                        oldman.setIsHandle(2);
                    }else if(oldman.getOldStatus()==2){
                        oldman.setOldStatus(0);
                        oldman.setIsHandle(0);
                    }
                }
            }
        }

        organOldmanDao.delByOrganId(organId);
        if(organOldmanList.size()>0){
            // 老人基本信息表  养老状态更新
            organExistOldman.addAll(oldmanList);//删除的老人 和 更新的 一起更新养老状态
            oldmanDao.updateOrganExceLImportByIds(organExistOldman);
            organOldmanDao.saveAll(organOldmanList);
            oldmanKeyHandleDao.delByOldman(oldmanList);
        }
        return new Result(true,excelReturnModel);
    }


    @Override
    public Boolean checkHaveAuthByAuthType(int type, Integer organId) {
        if(organId==null || organId==0){
            organId=commonService.getIdBySession();
        }
        if(organId==null || organId==0){
            return true;
        }
        Organ organ=organDao.getAuthById(organId);
        switch (type){
            case 1:if(organ.getAuthConsume()==1) return true;break;
            case 2:if(organ.getAuthSign()==1) return true;break;
            case 3:if(organ.getAuthQueryInfo()==1) return true;break;
            case 4:if(organ.getAuthQueryIntegral()==1) return true;break;
        }
        return false;
    }

    @Override
    public String getRecordByPage(OrganServiceRecordRequest organServiceRecordRequest, BTableRequest bTableRequest) {
        Page<OrganServiceRecord> page=commonService.getPage(bTableRequest,"organ_service_record");
        OrganServiceRecord organServiceRecord= Wrappers.organWrapper.unwrapServiceRecord(organServiceRecordRequest);
        if(organServiceRecord.getOrganId()==null || organServiceRecord.getOrganId()==0){
            //机构账号页面
            commonService.checkIsOrgan(organServiceRecord);
        }
        page.setEntity(organServiceRecord);
        List<OrganServiceRecordModel> productModelList=organServiceRecordDao.getByPage(page).stream().map(Wrappers.organWrapper::wrapServiceRecord).collect(Collectors.toList());
        Long size=organServiceRecordDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,productModelList);
    }


    @Override
    public Result importRecordExcel(MultipartFile file) throws IOException {
        List<OrganServiceRecord> organServiceRecordList=new ArrayList<>();
        Workbook wb0 = new HSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        int start=1;

        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int successAdd=0;//导入数量中  增加的个数

        Integer organId=commonService.getIdBySession();

        for (Row r : sht0) {
            try {
                if (r.getRowNum() >= start) {
                    //创建实体类
                    OrganServiceRecord organServiceRecord=new OrganServiceRecord();
                    organServiceRecord.setOrganId(organId);

                    if (r.getCell(1).getStringCellValue() != null && !r.getCell(1).getStringCellValue().equals("")) {
                        Integer oldmanId=commonService.checkOldmanExiest(r.getCell(1).getStringCellValue());
                        if(oldmanId!=null && oldmanId!=0){
                            organServiceRecord.setOldmanId(oldmanId);
                        }else{
                            throw new Exception();
                        }
                    }else{
                        throw new Exception();
                    }

                    if (r.getCell(12).getStringCellValue() != null && !r.getCell(2).getStringCellValue().equals("")) {
                        organServiceRecord.setData(r.getCell(2).getStringCellValue());
                    }
                    if (r.getCell(3).getStringCellValue() != null && !r.getCell(3).getStringCellValue().equals("")) {
                        organServiceRecord.setTime(Tool.stringToDate(r.getCell(3).getStringCellValue()));
                    }
                    if (r.getCell(4).getStringCellValue() != null && !r.getCell(4).getStringCellValue().equals("")) {
                        organServiceRecord.setOrder(r.getCell(4).getStringCellValue());
                    }
                    organServiceRecordList.add(organServiceRecord);
                    numSuccess++;
                    successAdd++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                excelReturnModel.getFail().add(r.getRowNum() + 1);
            }
        }
        excelReturnModel.setNumFail(excelReturnModel.getFail().size());
        excelReturnModel.setSuccessAdd(successAdd);
        excelReturnModel.setNumSuccess(numSuccess);
        excelReturnModel.setTotal(numSuccess+excelReturnModel.getNumFail());//一共
        if(organServiceRecordList.size()>0){
            organServiceRecordDao.saveAll(organServiceRecordList);
        }
        return new Result(true,excelReturnModel);
    }


    @Override
    public void delByIds(String[] ids) {
        organDao.updateProps("disable","1",ids);
    }

    @Override
    public List<Organ> getAll() {
        return organDao.getAll();
    }
}
