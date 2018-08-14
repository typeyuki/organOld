package com.organOld.service.service.impl;

import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
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
import com.organOld.service.model.HomeOldmanAddInfo;
import com.organOld.service.model.HomeOldmanModel;
import com.organOld.service.service.CommonService;
import com.organOld.service.service.HomeService;
import com.organOld.service.service.OldmanService;
import com.organOld.service.service.OrganService;
import com.organOld.service.util.Tool;
import com.organOld.service.wrapper.HomeOldmanWrapper;
import com.organOld.service.wrapper.HomeWrapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
    @Autowired
    ChxDao chxDao;
    @Autowired
    HomeDoctorDao homeDoctorDao;
    @Autowired
    HomeWrapper homeWrapper;
    @Autowired
    HomeOldmanWrapper homeOldmanWrapper;
    @Autowired
    OldmanService oldmanService;
    @Autowired
    OrganService organService;



    @Override
    public String getManAllByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest) {
        Page<HomeOldman> page=commonService.getPage(bTableRequest,"oldman_homeOldman");
        HomeOldman homeOldman=homeOldmanWrapper.unwrap(homeOldmanRequest);
        page.setEntity(homeOldman);
        List<HomeOldmanModel> organOldmanModelList=homeOldmanDao.getManAllByPage(page).stream().map(homeOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=homeOldmanDao.getManAllSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public String getByPage(HomeRequest homeRequest, BTableRequest bTableRequest) {
        Page<Home> page=commonService.getPage(bTableRequest,"home");
        Home home= homeWrapper.unwrap(homeRequest);
        page.setEntity(home);
        List<HomeModel> homeModelList=homeDao.getByPage(page).stream().map(homeWrapper::wrap).collect(Collectors.toList());
        Long size=homeDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,homeModelList);
    }

    @Override
    public String getManByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest) {
        Page<HomeOldman> page=commonService.getPage(bTableRequest,"home_man");
        HomeOldman homeOldman= homeOldmanWrapper.unwrap(homeOldmanRequest);
        page.setEntity(homeOldman);
        List<HomeOldmanModel> organOldmanModelList=homeOldmanDao.getByPage(page).stream().map(homeOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=homeOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public Result importManExcel(MultipartFile file, String type) throws IOException {
        List<HomeOldman> homeOldmanList=new ArrayList<>();

        String  fix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        Workbook wb0;
        if(fix.equals("xls"))
            wb0= new HSSFWorkbook(file.getInputStream());
        else
            wb0=new XSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        int start=2;

        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int successAdd=0;//导入数量中  增加的个数
        excelReturnModel.setTotal(sht0.getLastRowNum()-(start-1));//一共

//        Integer jwId=commonService.getIdBySession();


        List<Oldman> oldmanList=new ArrayList<>();//用于当前导入的老人 养老状态

        Map<String,Oldman> existOldmanMap=oldmanService.getAllOldman();



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
                    String noExistName=null;
                    String noExistPid=null;

                    if (commonService.excelIsNotNull(r.getCell(1))) {
                        Oldman existOldman=existOldmanMap.get(r.getCell(1).getStringCellValue());
                        if(existOldman!=null){
                            oldmanId=existOldman.getId();
                            switch (existOldman.getOldStatus()){
                                case 2:
                                case 4:
                                    oldStatus=OldStatusEnum.SJ.getIndex();
                            }

                            Oldman oldman=new Oldman();
                            oldman.setId(oldmanId);
                            oldman.setIsHandle(2);
                            oldman.setOldStatus(oldStatus);
                            oldmanList.add(oldman);

                        }else{
                            noExistName=r.getCell(0).getStringCellValue();
                            noExistPid=r.getCell(1).getStringCellValue();
                        }
                    }else{
                        throw new Exception();
                    }


                    /**
                     * 家庭服务
                     */
                    if (r.getCell(12)!=null && r.getCell(12).getStringCellValue() != null && !r.getCell(12).getStringCellValue().equals("")) {
                        jjfwOrg=organService.getIdByName(r.getCell(12).getStringCellValue());
                    }
                    if (r.getCell(2)!=null && r.getCell(2).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldman.setHomeId(7);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(3)!=null && r.getCell(3).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(8);
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(4)!=null && r.getCell(4).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(9);
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(5)!=null && r.getCell(5).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(10);
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(6)!=null && r.getCell(6).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(11);
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(7)!=null && r.getCell(7).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(12);
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(8)!=null && r.getCell(8).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(13);
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(9)!=null && r.getCell(9).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(14);
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(10)!=null && r.getCell(10).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(15);
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldmanList.add(homeOldman);
                    }
                    if (r.getCell(11)!=null && r.getCell(11).getStringCellValue().equals("1")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(jjfwOrg);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(16);
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldmanList.add(homeOldman);
                    }

                    /**
                     * 长护险
                     */
                    if (r.getCell(15)!=null && r.getCell(15).getStringCellValue() != null && !r.getCell(15).getStringCellValue().equals("")) {
                        chxOrg=organService.getIdByName(r.getCell(15).getStringCellValue());
                    }

                    if (r.getCell(13)!=null && r.getCell(13).getStringCellValue() != null && !r.getCell(13).getStringCellValue().equals("")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(chxOrg);
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(getIdBySecType(r.getCell(13).getStringCellValue(),HomeEnum.CHX.getIndex()));
                        if (r.getCell(14)!=null && r.getCell(14).getStringCellValue() != null && r.getCell(14).getStringCellValue().equals("1")) {
                            homeOldman.setIsService(1);
                        }
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
                            homeOldmanList.add(homeOldman);
                    }

                    /**
                     * 智能设备
                     */
                    if (r.getCell(19)!=null && r.getCell(19).getStringCellValue() != null && !r.getCell(19).getStringCellValue().equals("")) {
                        znOrg=organService.getIdByName(r.getCell(19).getStringCellValue());
                    }
                    if (r.getCell(16)!=null && r.getCell(16).getStringCellValue() != null && !r.getCell(16).getStringCellValue().equals("")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(znOrg);
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldman.setOldmanId(oldmanId);
                        homeOldman.setHomeId(getIdBySecType(r.getCell(16).getStringCellValue(),HomeEnum.ZNZD.getIndex()));
                        if(r.getCell(17)!=null && r.getCell(17).getStringCellValue() != null && !r.getCell(17).getStringCellValue().equals("")){
                            homeOldman.setTimeIn(Tool.stringToDate(r.getCell(17).getStringCellValue()));
                        }
                        if(r.getCell(18)!=null && r.getCell(18).getStringCellValue() != null && !r.getCell(18).getStringCellValue().equals("")){
                            homeOldman.setTimeOut(Tool.stringToDate(r.getCell(18).getStringCellValue()));
                        }
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
                            homeOldmanList.add(homeOldman);
                    }


                    /**
                     * 家庭医生
                     */
                    if (r.getCell(20)!=null && r.getCell(20).getStringCellValue() != null && !r.getCell(20).getStringCellValue().equals("")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldman.setOldmanId(oldmanId);
                        if(r.getCell(21)!=null && r.getCell(21).getStringCellValue() != null && !r.getCell(21).getStringCellValue().equals("")){
                            homeOldman.setTimeIn(Tool.stringToDate(r.getCell(21).getStringCellValue()));
                        }
                        if(r.getCell(21)!=null && r.getCell(21).getStringCellValue() != null && !r.getCell(21).getStringCellValue().equals("")){
                            homeOldman.setTimeOut(Tool.stringToDate(r.getCell(21).getStringCellValue()));
                        }
                        homeOldman.setHomeId(getIdBySecType(r.getCell(20).getStringCellValue(),HomeEnum.JTYS.getIndex()));
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
                            homeOldmanList.add(homeOldman);

                    }

                    /**
                     * 家庭病床
                     */
                    if (r.getCell(23)!=null && r.getCell(23).getStringCellValue() != null && !r.getCell(23).getStringCellValue().equals("")) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setNoExistName(noExistName);
                        homeOldman.setNoExistPid(noExistPid);
                        homeOldman.setOldmanId(oldmanId);
                        if(r.getCell(24)!=null && r.getCell(24).getStringCellValue() != null && !r.getCell(24).getStringCellValue().equals("")){
                            homeOldman.setTimeIn(Tool.stringToDate(r.getCell(24).getStringCellValue()));
                        }
                        if(r.getCell(25)!=null && r.getCell(25).getStringCellValue() != null && !r.getCell(25).getStringCellValue().equals("")){
                            homeOldman.setTimeOut(Tool.stringToDate(r.getCell(25).getStringCellValue()));
                        }
                        homeOldman.setHomeId(getIdBySecType(r.getCell(23).getStringCellValue(),HomeEnum.JTBC.getIndex()));
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
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
        if(type.equals("update")){
            //更新的方式
            //删掉之前的所有数据
            homeOldmanDao.delAll();
            oldmanKeyHandleDao.delByOldman(oldmanList);
            //将 养老状态为4 的改为 2
            //将 养老状态为3 的改为 0 切 handle=0
            oldmanDao.delHomeOldStatus();
        }else{
            if(oldmanList.size()>0)
                oldmanKeyHandleDao.delByOldman(oldmanList);
        }

        if(homeOldmanList.size()>0){
            // 老人基本信息表  养老状态更新
            if(oldmanList.size()>0)
                oldmanDao.updateOrganExceLImportByIds(oldmanList);
            homeOldmanDao.saveAll(homeOldmanList);
        }
        return new Result(true,excelReturnModel);
    }

    private Integer getIdBySecType(String stringCellValue, int index) {
       return homeDao.getIdBySecType(stringCellValue,index);
    }

    @Override
    @Transactional
    public void addOrUpdate(Home home,String type) {
        if(type.equals("add")) {
            switch (home.getFirType()) {
                case 2:
                    chxDao.save(home.getChx());
                    home.setSecType(home.getChx().getId() + "");
                    break;
                case 4:
                    homeDoctorDao.save(home.getDoctor());
                    home.setSecType(home.getDoctor().getId() + "");
                    break;
            }
            homeDao.save(home);
        }else{
            switch (home.getFirType()) {
                case 1:
                case 3:
                case 5:
                    homeDao.updateById(home);
                    break;
                case 2:
                    home.getChx().setHomeId(home.getId());
                    chxDao.updateById(home.getChx());
                    break;
                case 4:
                    home.getDoctor().setHomeId(home.getId());
                    homeDoctorDao.updateById(home.getDoctor());
                    break;
            }
        }
    }

    @Override
    public Result getById(int id, int firType) {
        return new Result(true,homeDao.getByIdAndFirType(id,firType));
    }

    @Override
    @Transactional
    public void delByIds(String[] ids, int type) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        homeDao.delByIds(id);
        switch (type) {
            case 2:
                chxDao.delByIds(id);
                break;
            case 4:
                homeDoctorDao.delByIds(id);
                break;
        }

    }

    @Override
    public HomeOldman getOldmanById(Integer id) {
        return homeOldmanDao.getById(id);
    }

    @Override
    @Transactional
    public void delByOldmanIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        List<Integer> delOldmanId=homeOldmanDao.getDelOldmanIdsByHomeOldmanIds(id);
        homeOldmanDao.delByIds(id);
        //先将删掉的老人 默认去掉了 居家养老
        oldmanDao.delHomeOldStatusByIds(delOldmanId);
        //删掉之后 看还有 该老人其他的居家养老  回复 old_status和is_handle
        List<Oldman> oldmanList=oldmanDao.getByDelOldmanIds(delOldmanId);
        if(oldmanList.size()>0) {
            for (Oldman oldman : oldmanList) {
                if (oldman.getOldStatus() == 2) {
                    oldman.setOldStatus(4);
                } else if (oldman.getOldStatus() == 0) {
                    oldman.setOldStatus(3);
                }
                oldman.setIsHandle(2);
            }
            oldmanDao.updateOrganExceLImportByIds(oldmanList);
        }
    }

    @Override
    public void updateOldman(HomeOldman homeOldman) {
        homeOldmanDao.updateById(homeOldman);
    }

    @Override
    @Transactional
    public void addOldman(HomeOldman homeOldman) {
        homeOldmanDao.save(homeOldman);
        oldmanDao.updateHomeOldStatusById(homeOldman.getOldmanId());
    }


    @Override
    public HomeOldmanAddInfo getAddInfo() {
        HomeOldmanAddInfo homeOldmanAddInfo=new HomeOldmanAddInfo();
        List<Organ> organList=organService.getALLNotInFirType(1);
        homeOldmanAddInfo.setOrganList(organList);
        List<Home> homeList=homeDao.getAll();
        homeList.forEach(s->s.setFirTypeDesc(HomeEnum.getValue(s.getFirType())));
        homeOldmanAddInfo.setHomeList(homeList);
        return homeOldmanAddInfo;
    }
}