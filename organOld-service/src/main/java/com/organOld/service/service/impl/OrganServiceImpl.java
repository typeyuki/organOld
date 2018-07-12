package com.organOld.service.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.SysUser;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.entity.organ.OrganReg;
import com.organOld.dao.entity.organ.OrganType;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.*;
import com.organOld.service.enumModel.OrganFirEnum;
import com.organOld.service.model.ExcelReturnModel;
import com.organOld.service.model.OrganModel;
import com.organOld.service.model.OrganOldmanModel;
import com.organOld.service.model.OrganRegInfoModel;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username=userDetails.getUsername();
        OrganModel organModel=Wrappers.organWrapper.wrap(organDao.getByUsername(username));
        return organModel;
    }

    @Override
    public OrganModel getById(int organId) {
        return null;
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

    /**
     * 为机构注册新账号
     * @param organId
     */
    @Transactional
    SysUser newAccount(int organId) {
        SysUser user=createUser(organId);
        userService.save(user);
        userService.setUserOrgan(user.getId(),organId);

        Organ auths=organDao.getAuthById(organId);
        int goal;//商品 1  消费2 签到4     总分 0无特殊权限 1 商品权限 2消费权限 4 签到权限 3商品+消费权限

        goal=auths.getAuthConsume()+auths.getAuthProduct()+auths.getAuthProduct();
        switch (goal){
            case 0:
                userService.setUserRole(user.getId(),3);
                break;
            case 1:
                userService.setUserRole(user.getId(),8);
                break;
            case 2:
                userService.setUserRole(user.getId(),6);
                break;
            case 3:
                userService.setUserRole(user.getId(),9);
                break;
            case 4:
                userService.setUserRole(user.getId(),7);
                break;
            default:
                break;
        }

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
        OrganReg organReg=Wrappers.organWrapper.unwrapRegOrganReg(organRegRequest);
        organDao.save(organ);
        organReg.setOrganId(organ.getId());
        organRegDao.save(organReg);
        return new Result(true,"注册成功！请等待审核");
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
        excelReturnModel.setTotal(sht0.getLastRowNum()-(start-1));//一共

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
        excelReturnModel.setTotal(sht0.getLastRowNum()-(start-1));//一共

        Integer organId=commonService.getIdBySession();

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
                            if(oldmanId!=null && oldmanId!=0){
                                Oldman oldman=new Oldman();
                                oldman.setId(oldmanId);
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
                        if (r.getCell(5).getStringCellValue() != null && !r.getCell(5).getStringCellValue().equals("")) {
                            organOldman.setNum(r.getCell(5).getStringCellValue());
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

        organOldmanDao.delByOrganId(organId);
        if(organOldmanList.size()>0){
            organOldmanDao.saveAll(organOldmanList);
        }
        return new Result(true,excelReturnModel);
    }
}
