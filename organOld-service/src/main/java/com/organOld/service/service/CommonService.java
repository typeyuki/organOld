package com.organOld.service.service;

import com.alibaba.fastjson.JSONObject;

import com.organOld.dao.util.Page;
import com.organOld.service.contract.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CommonService {

    public static int birthdayToAge(Date birthday){
        Calendar cal = Calendar.getInstance();
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

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        return age;
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
}
