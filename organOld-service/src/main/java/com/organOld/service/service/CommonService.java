package com.organOld.service.service;

import com.alibaba.fastjson.JSONObject;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.Message;
import com.organOld.dao.entity.XqInterface;
import com.organOld.dao.repository.AutoValueDao;
import com.organOld.dao.repository.MessageDao;
import com.organOld.dao.repository.OldmanDao;
import com.organOld.dao.repository.UserDao;
import com.organOld.dao.util.Page;
import com.organOld.service.contract.*;
import com.organOld.service.enumModel.AutoValueEnum;
import com.organOld.service.enumModel.MessageTypeEnum;
import com.organOld.service.model.Model;
import com.organOld.service.contract.Result;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CommonService {

    @Autowired
    UserDao userDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    OldmanDao oldmanDao;
    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    AutoValueService autoValueService;

    public static int birthdayToAge(Date birthday){
        Date date=new Date();
        return calculateTwoDateYears(date,birthday);
    }
    public static Date AgeTobirthday(int age){
        if(age==0){
            return null;
        }
        Date nowDate = new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-age);
        return calendar.getTime();
    }

    public static String getTabeleSortType(Integer index,String type){
        if (null == index){
            return "id";
        }
        switch (type){
            case "oldman_base":
                switch (index) {
                    case 0:
                        return "id";
                    case 5:
                        return "age";
                    case 11:
                        return "time";
                }
                return "id";
            case "message":
                return "init";
             default:
                 return "id";
        }
    }


    public String tableReturn(String sEcho,Long size,List<?> list){
        JSONObject getObj = new JSONObject();
        getObj.put("sEcho", sEcho);// 不知道这个值有什么用,有知道的请告知一下
        getObj.put("iTotalRecords", size);//总的行数
        getObj.put("iTotalDisplayRecords", size);//显示的行数,这个要和上面写的一样
        getObj.put("aaData", list);//要以JSON格式返回  jqueryDataTable 默认变量名 aaData
        return getObj.toString();
    }


    public Page getPage(BTableRequest bTableRequest, String type) {
        Page page = new Page<>();
        String sortType = CommonService.getTabeleSortType(bTableRequest.getiSortCol_0(), type);
        String sort = bTableRequest.getsSortDir_0();
        if (StringUtils.isEmpty(sort)) {
            sort = "asc";
        }
        page.setSortType(sortType);
        page.setSort(sort);
        page.setStart(bTableRequest.getiDisplayStart());
        page.setLength(bTableRequest.getiDisplayLength());
        page.setSort(sort);
        page.setSortType(sortType);
        return page;
    }

    public List<Integer> getAutoValueTypes(String type){
        List<Integer> typeList=new ArrayList<>();
        switch (type){
            case "label":
                typeList.add(AutoValueEnum.PQ.getIndex());
                typeList.add(AutoValueEnum.ZZMM.getIndex());
                typeList.add(AutoValueEnum.HJ.getIndex());
                typeList.add(AutoValueEnum.JJJG.getIndex());
                typeList.add(AutoValueEnum.JJTJ.getIndex());
                typeList.add(AutoValueEnum.SL.getIndex());
                typeList.add(AutoValueEnum.SZ.getIndex());
                typeList.add(AutoValueEnum.SQZW.getIndex());
                typeList.add(AutoValueEnum.ZC.getIndex());
                typeList.add(AutoValueEnum.JTLB.getIndex());
                break;
            case "labelFilter":
                typeList.add(AutoValueEnum.PQ.getIndex());
                typeList.add(AutoValueEnum.ZZMM.getIndex());
                typeList.add(AutoValueEnum.HJ.getIndex());
                typeList.add(AutoValueEnum.JJJG.getIndex());
                typeList.add(AutoValueEnum.JJTJ.getIndex());
                typeList.add(AutoValueEnum.SL.getIndex());
                typeList.add(AutoValueEnum.SZ.getIndex());
                typeList.add(AutoValueEnum.YJBQ.getIndex());
                typeList.add(AutoValueEnum.SQZW.getIndex());
                typeList.add(AutoValueEnum.ZC.getIndex());
                typeList.add(AutoValueEnum.JTLB.getIndex());
                break;
            case "oldman_add":
                typeList.add(AutoValueEnum.PQ.getIndex());
                typeList.add(AutoValueEnum.ZZMM.getIndex());
                typeList.add(AutoValueEnum.HJ.getIndex());
                typeList.add(AutoValueEnum.JJJG.getIndex());
                typeList.add(AutoValueEnum.JJTJ.getIndex());
                typeList.add(AutoValueEnum.SL.getIndex());
                typeList.add(AutoValueEnum.SZ.getIndex());
                typeList.add(AutoValueEnum.XQ.getIndex());
                typeList.add(AutoValueEnum.SQZW.getIndex());
                typeList.add(AutoValueEnum.ZC.getIndex());
                typeList.add(AutoValueEnum.JTLB.getIndex());
                break;
            case "health_add":
                typeList.add(AutoValueEnum.SL.getIndex());
                typeList.add(AutoValueEnum.SZ.getIndex());
                break;
            case "organ_reg":
                typeList.add(AutoValueEnum.PQ.getIndex());
                break;
            case "oldman":
                typeList.add(AutoValueEnum.ZZMM.getIndex());
                typeList.add(AutoValueEnum.HJ.getIndex());
                typeList.add(AutoValueEnum.JJJG.getIndex());
                typeList.add(AutoValueEnum.JJTJ.getIndex());
                break;
            case "oldmanInfo":
                typeList.add(AutoValueEnum.ZZMM.getIndex());
                typeList.add(AutoValueEnum.HJ.getIndex());
                typeList.add(AutoValueEnum.JJJG.getIndex());
                typeList.add(AutoValueEnum.JJTJ.getIndex());
                typeList.add(AutoValueEnum.SQZW.getIndex());
                typeList.add(AutoValueEnum.ZC.getIndex());
                typeList.add(AutoValueEnum.JTLB.getIndex());
                break;
            case "importOldman":
                typeList.add(AutoValueEnum.ZZMM.getIndex());
                typeList.add(AutoValueEnum.HJ.getIndex());
                typeList.add(AutoValueEnum.JJJG.getIndex());
                typeList.add(AutoValueEnum.JJTJ.getIndex());
                typeList.add(AutoValueEnum.SQZW.getIndex());
                typeList.add(AutoValueEnum.ZC.getIndex());
                typeList.add(AutoValueEnum.JTLB.getIndex());
                typeList.add(AutoValueEnum.SL.getIndex());
                typeList.add(AutoValueEnum.SZ.getIndex());
                typeList.add(AutoValueEnum.XQ.getIndex());
                break;
            default:
        }
        return typeList;
    }


    public Integer getIdBySession() {
        try {
            Integer organId= userDao.getOrganIdByUsername(getUserNameBySession());
            if(organId==null) return 0;
            return organId;
        }catch (Exception e){
            return 0;
        }
    }

    public void checkIsOrgan(DBInterface dbInterface) {
        Integer organId=getIdBySession();
        if (organId!=null && organId!=0){
            dbInterface.setOrganId(organId);
        }
    }

    public void getOrganXqs(XqInterface xqInterface) {
        if(xqInterface.getXqIds()==null || xqInterface.getXqIds().size()==0) {
            Integer organId = getIdBySession();
            if (organId == null || organId == 0) {
                //管理员
                xqInterface.setXqIds(null);
            } else {
                List<Integer> xqIds = autoValueService.getXqIdsByUsername(getUserNameBySession());
                xqInterface.setXqIds(xqIds);
            }
        }

    }

    public static int calculateTwoDateYears(String futureTime, Date birthday) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse(futureTime);
        return calculateTwoDateYears(date,birthday);
    }

    public static int calculateTwoDateYears(Date time, Date birthday){
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthday);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        //只比较 年  不比较月
//        if (monthNow <= monthBirth) {
//            if (monthNow == monthBirth) {
//                if (dayOfMonthNow < dayOfMonthBirth) age--;
//            }else{
//                age--;
//            }
//        }
        return age;
    }

    public Result checkUserOrganType() {
        Result result;
        try {
            UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            String username=userDetails.getUsername();
            String type=userDao.getOrganTypeByUsername(username);
            if(type!=null &&!type.equals("")){
                result=new Result(true,type);
            }else{
                result=new Result(false);
            }
        }catch (Exception e){
            result=new Result(false);
        }
        return result;
    }

    public void informJwAndPq(String content) {
        Result result=checkUserOrganType();
        if(result.isSuccess()==false || result.getData().equals("片区")){
            Integer organId=getIdBySession();
            List<Integer> userIds=userDao.getJwUserId(organId);
            Message message=new Message();
            message.setType(MessageTypeEnum.XT.getIndex());
            message.setContent(content);
            messageDao.saveAllMessage(userIds,message);
        }
    }

    public Integer checkOldmanExiest(String pid) {
        return oldmanDao.getIdByPid(pid);
    }

    public String getUserNameBySession() {
        try {
            UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            String username=userDetails.getUsername();
            return username;
        }catch (Exception e){
            return "";
        }
    }

    public Boolean excelIsNotNull(Cell cell){
        if(cell==null || cell.getStringCellValue()==null || cell.getStringCellValue().trim().equals("")){
            return false;
        }
        return true;
    }

    public boolean excelIsNotNullOne(Cell cell) {
        Boolean result=excelIsNotNull(cell);
        if(result){
            if(cell.getStringCellValue().equals("1"))
                return true;
        }
        return false;
    }


    public void fillAutoValue(DBEntity entity, Model model, List<String> methods, Map<Integer,String> map)  {
        try {
            for(String method : methods){
                String setM="set"+method;
                String getM="get"+method;
                Method setMethod;
                if (method.equals("Sqzw") || method.equals("FamilyType")){
                    setMethod=model.getClass().getMethod(setM, List.class);
                }else{
                    setMethod=model.getClass().getMethod(setM, String.class);
                }
                Method getMethod =entity.getClass().getMethod(getM, null);

                String value=(String)getMethod.invoke(entity,null);
                if(value!=null && !value.equals("")){
                    if (method.equals("Sqzw") || method.equals("FamilyType")){
                        String[] s=value.split("#");
                        List<String> sList=new ArrayList<>();
                        for(String ss:s){
                            sList.add(map.get(Integer.parseInt(ss)));
                        }
                        setMethod.invoke(model,sList);
                    }else{
                        setMethod.invoke(model,map.get(Integer.parseInt(value)));
                    }

                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //填充小区 1.筛选片区、居委 2.本身机构对应的小区
    public void fillXq(XqRequest xqRequest, XqInterface xqInterface) {
        List<Integer> xqIds=new ArrayList<>();
        if(xqRequest!=null && xqRequest.getJw()!=null && xqRequest.getJw().length>0){
            xqIds=autoValueService.getXqIdsByJwIds(xqRequest.getJw());
        }else if(xqRequest!=null && xqRequest.getDistrict()!=null && xqRequest.getDistrict().length>0){
            xqIds=autoValueService.getXqIdsByPqIds(xqRequest.getDistrict());
        }
        xqInterface.setXqIds(xqIds);
        getOrganXqs(xqInterface);
    }

}

