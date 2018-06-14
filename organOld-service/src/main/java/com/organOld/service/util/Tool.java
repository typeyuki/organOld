package com.organOld.service.util;


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
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
}
