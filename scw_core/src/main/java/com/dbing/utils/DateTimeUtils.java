package com.dbing.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:dbing
 */
public class DateTimeUtils {
    public static String getFormatTime(Date time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(time);
    }


    public static String getFormatTime(Date time,String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(time);
    }


    public static String getFormatCurrentTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }

    public static String getFormatCurrentTime(String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date());
    }
}
