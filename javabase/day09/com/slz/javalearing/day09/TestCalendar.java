package com.slz.javalearing.day09;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/7
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(); // 抽象类获取实例
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // 一月是0，从0开始计数
        int date = calendar.get(Calendar.DATE);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK); // 周日算第一天
        System.out.println(year + " "  + month + " " + date + " " + weekday);
        calendar.set(2024, Calendar.JULY, 10);
        System.out.println(calendar.get(Calendar.MONTH));

        // Calendar 转 Date
        Date time = calendar.getTime();
        System.out.println(time);

        Date date1 = new Date();
        calendar.setTime(date1);
        // Date 转 Calendar
        int date2 = calendar.get(Calendar.DATE);
        System.out.println(date2);
        // 格里高利历
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.println(gregorianCalendar.isLeapYear(2024)); // 是否是闰年
    }
}
