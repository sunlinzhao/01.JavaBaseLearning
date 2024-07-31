package com.slz.javalearing.day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/7
 */

/**
 * 日期工具类
 */
public class DateUtil {

    /**
     * 根据模版获取日期字符串
     * @param s
     * @return
     */
    public static String getByPattern(String s){
        return new SimpleDateFormat(s).format(new Date());
    }
    /**
     * 获取系统日期
     * @return String
    */

    public static String getSystemDate(){
        return getByPattern("yyyy-MM-dd");
    }

    /**
     * 获取系统日期
     * @return String
     */
    public static String getDefaultDate(){
        return getByPattern("yyyy年MM月dd日");
    }
}
