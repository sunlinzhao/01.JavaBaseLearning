package com.slz.javalearing.day09;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/6
 */
public class TestDateFormat {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        DateFormat f1 = DateFormat.getDateInstance(); // DateFormat 格式化时间，返回的是长日期格式 2024年6月6日 下午10:32:11
        System.out.println(f1.format(date));

        DateFormat f2 = DateFormat.getTimeInstance();
        System.out.println(f2.format(date));

        DateFormat f3 = DateFormat.getDateTimeInstance();
        System.out.println(f3.format(date));

        SimpleDateFormat sf1 = new SimpleDateFormat(); // SimpleDateFormat 格式化时间, 返回的是短日期格式 2024/6/6 下午10:32
        System.out.println(sf1.format(date));

        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss"); // 根据给定模式字符pattern格式化字符串
        System.out.println(sf2.format(date));

        SimpleDateFormat sf3 = new SimpleDateFormat("yyyy/MM/dd");
        String dstr = "2024/06/07";
        Date date1 = sf3.parse(dstr); // 将字符串解析为日期
        System.out.println(date1);
    }
}
