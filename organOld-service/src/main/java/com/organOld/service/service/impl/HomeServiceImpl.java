package com.organOld.service.service.impl;

import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.BTableRequest;
import com.organOld.service.contract.HomeOldmanRequest;
import com.organOld.service.contract.HomeRequest;
import com.organOld.service.contract.Result;
import com.organOld.service.enumModel.HomeEnum;
import com.organOld.service.enumModel.OldStatusEnum;
import com.organOld.service.model.ExcelReturnModel;
import com.organOld.service.model.HomeModel;
import com.organOld.service.model.HomeOldmanModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.HomeService;
import com.organOld.service.util.Tool;
import com.organOld.service.wrapper.Wrappers;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService{

    @Autowired
    CommonService commonService;
    @Autowired
    HomeDao homeDao;
    @Autowired
    HomeOldmanDao homeOldmanDao;
    @Autowired
    OldmanDao oldmanDao;
    @Autowired
    OrganDao organDao;
    @Autowired
    OldmanKeyHandleDao oldmanKeyHandleDao;

    @Override
    public String getByPage(HomeRequest homeRequest, BTableRequest bTableRequest) {
        Page<Home> page=commonService.getPage(bTableRequest,"home");
        Home home= Wrappers.homeWrapper.unwrap(homeRequest);
        page.setEntity(home);
        List<HomeModel> homeModelList=homeDao.getByPage(page).stream().map(Wrappers.homeWrapper::wrap).collect(Collectors.toList());
        Long size=homeDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,homeModelList);
    }

    @Override
    public String getManByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest) {
        Page<HomeOldman> page=commonService.getPage(bTableRequest,"home_man");
        HomeOldman homeOldman= Wrappers.homeOldmanWrapper.unwrap(homeOldmanRequest);
        page.setEntity(homeOldman);
        List<HomeOldmanModel> organOldmanModelList=homeOldmanDao.getByPage(page).stream().map(Wrappers.homeOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=homeOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public Result importManExcel(MultipartFile file) throws IOException {
        List<HomeOldman> homeOldmanList=new ArrayList<>();
        Workbook wb0 = new HSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        int start=2;

        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int successAdd=0;//导入数量中  增加的个数
        excelReturnModel.setTotal(sht0.getLastRowNum()-(start-1));//一共

        Integer jwId=commonService.getIdBySession();


        List<Oldman> oldmanList=new ArrayList<>();//用于更新老人 养老状态


        List<Oldman> homeExistOldman=oldmanDao.getByJwId(jwId);//先存储 该居委所有的老人 ，筛选出去掉的老人 用于更新 去掉的老人的 是否已处理、养老状态

        for (Row r : sht0) {
            try {
                if (r.getRowNum() >= start) {
                    Iterator<Cell> cells = r.cellIterator();    //获得第一行的迭代器
                    while (cells.hasNext()) {
                        Cell cell = cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }

                    int oldStatus= OldStatusEnum.JJ.getIndex();//养老状态
                    Integer oldmanId=0;
                    Integer jjfwOrg=0,chxOrg=0,znOrg=0;

                    if (r.getCell(0).getStringCellValue() != null && !r.getCell(0).getStringCellValue().equals("")) {
                        oldmanId=commonService.checkOldmanExiest(r.getCell(0).getStringCellValue());
                        Oldman exiOldman = oldmanDao.getById(oldmanId);
                        if(oldmanId!=null && oldmanId!=0){
                                switch (exiOldman.getOldStatus()) {
                                    case 2:
                                    case 4:
                                        //之前是社区养老 或者社区居家
                                        oldStatus = OldStatusEnum.SJ.getIndex();
                                        break;
                                }

                            Oldman oldman=new Oldman();
                            oldman.setId(oldmanId);
                            oldman.setPid(r.getCell(0).getStringCellValue());
                            oldman.setIsHandle(2);
                            oldman.setOldStatus(oldStatus);

                            if(homeExistOldman.contains(oldman)){
                                homeExistOldman.remove(oldman);
                            }
                            oldmanList.add(oldman);
                        }else{
                            throw new Exception();
                        }
                    }else{
                        throw new Exception();
                    }


                    /**
                     * 家庭服务
                     */
                    if (r.getCell(11)!=null && r.getCell(11).getStringCellValue() != null && !r.getCell(11).getStringCellValue().equals("")) {
                        jjfwOrg=organDao.getIdByName(r.getCell(11).getStringCellValue());
                    }
                    if (r.getCell(1)!=null && r.getCell(1).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(7);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(2)!=null && r.getCell(2).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(8);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(3)!=null && r.getCell(3).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(9);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(4)!=null && r.getCell(4).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(10);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(5)!=null && r.getCell(5).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(11);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(6)!=null && r.getCell(6).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(12);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(7)!=null && r.getCell(7).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(13);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(8)!=null && r.getCell(8).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(14);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(9)!=null && r.getCell(9).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(15);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(10)!=null && r.getCell(10).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(16);
                        homeOldmanList.add(homeOldman);
                    }

                    /**
                     * 长护险
                     */
                    if (r.getCell(14)!=null && r.getCell(14).getStringCellValue() != null && !r.getCell(14).getStringCellValue().equals("")) {
                        chxOrg=organDao.getIdByName(r.getCell(14).getStringCellValue());
                    }

                    if (r.getCell(12)!=null && r.getCell(12).getStringCellValue() != null && !r.getCell(12).getStringCellValue().equals("")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(chxOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(homeDao.getIdBySecType(r.getCell(12).getStringCellValue(),HomeEnum.CHX.getIndex()));
                        if (r.getCell(13)!=null && r.getCell(13).getStringCellValue() != null && r.getCell(13).getStringCellValue().equals("1")) {
                            homeOldman.setIsService(1);
                        }
                        homeOldmanList.add(homeOldman);
                    }

                    /**
                     * 智能设备
                     */
                    if (r.getCell(18)!=null && r.getCell(18).getStringCellValue() != null && !r.getCell(18).getStringCellValue().equals("")) {
                        znOrg=organDao.getIdByName(r.getCell(18).getStringCellValue());
                    }
                    if (r.getCell(15)!=null && r.getCell(15).getStringCellValue() != null && !r.getCell(15).getStringCellValue().equals("")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(znOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(homeDao.getIdBySecType(r.getCell(15).getStringCellValue(),HomeEnum.ZNZD.getIndex()));
                        if(r.getCell(16)!=null && r.getCell(16).getStringCellValue() != null && !r.getCell(16).getStringCellValue().equals("")){
                            homeOldman.setTimeIn(Tool.stringToDate(r.getCell(16).getStringCellValue()));
                        }
                        if(r.getCell(17)!=null && r.getCell(17).getStringCellValue() != null && !r.getCell(17).getStringCellValue().equals("")){
                            homeOldman.setTimeOut(Tool.stringToDate(r.getCell(17).getStringCellValue()));
                        }
                        homeOldmanList.add(homeOldman);
                    }


                    /**
                     * 家庭医生
                     */
                    if (r.getCell(19)!=null && r.getCell(19).getStringCellValue() != null && !r.getCell(19).getStringCellValue().equals("")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOldmanId(oldmanId);
                        if(r.getCell(20)!=null && r.getCell(20).getStringCellValue() != null && !r.getCell(20).getStringCellValue().equals("")){
                            homeOldman.setTimeIn(Tool.stringToDate(r.getCell(20).getStringCellValue()));
                        }
                        if(r.getCell(21)!=null && r.getCell(21).getStringCellValue() != null && !r.getCell(21).getStringCellValue().equals("")){
                            homeOldman.setTimeOut(Tool.stringToDate(r.getCell(21).getStringCellValue()));
                        }
                        homeOldman.setHomeId(homeDao.getIdBySecType(r.getCell(19).getStringCellValue(),HomeEnum.JTYS.getIndex()));
                        homeOldmanList.add(homeOldman);
                    }

                    /**
                     * 家庭病床
                     */
                    if (r.getCell(22)!=null && r.getCell(22).getStringCellValue() != null && !r.getCell(22).getStringCellValue().equals("")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOldmanId(oldmanId);
                        if(r.getCell(23)!=null && r.getCell(23).getStringCellValue() != null && !r.getCell(23).getStringCellValue().equals("")){
                            homeOldman.setTimeIn(Tool.stringToDate(r.getCell(23).getStringCellValue()));
                        }
                        if(r.getCell(24)!=null && r.getCell(24).getStringCellValue() != null && !r.getCell(24).getStringCellValue().equals("")){
                            homeOldman.setTimeOut(Tool.stringToDate(r.getCell(24).getStringCellValue()));
                        }
                        homeOldman.setHomeId(homeDao.getIdBySecType(r.getCell(22).getStringCellValue(),HomeEnum.JTBC.getIndex()));
                        homeOldmanList.add(homeOldman);
                    }

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

        //该居家 删除的老人 的养老状态   之前是社区居家养老 则变为2  其他为0
        for(Oldman oldman:homeExistOldman){
                    if(oldman.getOldStatus()==4){
                        oldman.setOldStatus(2);
                        oldman.setIsHandle(2);
                    }else if(oldman.getOldStatus()==3){
                        oldman.setOldStatus(0);
                        oldman.setIsHandle(0);
                    }
        }

        homeOldmanDao.delByJwId(jwId);
        if(homeOldmanList.size()>0){
            // 老人基本信息表  养老状态更新
            homeExistOldman.addAll(oldmanList);//删除的老人 和 更新的 一起更新养老状态
            oldmanDao.updateOrganExceLImportByIds(homeExistOldman);
            homeOldmanDao.saveAll(homeOldmanList);
            oldmanKeyHandleDao.delByOldman(oldmanList);
        }
        return new Result(true,excelReturnModel);
    }

    @Override
    public void add(Home home) {
        
    }
}
