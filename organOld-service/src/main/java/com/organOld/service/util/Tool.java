package com.organOld.service.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool {

    /**
     * date转字符串
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date,String format){
        if(date==null) return "";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static Date stringToDate(String str){
        if(str.contains(".")){
            str=str.replace(".","-");
        }
        if(str.contains("\\")){
            str=str.replace("\\\\","-");
        }

        if(str.split("-").length<3){
            //年月
            str+="-01";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
