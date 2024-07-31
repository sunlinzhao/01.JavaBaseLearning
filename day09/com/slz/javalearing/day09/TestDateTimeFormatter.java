package com.slz.javalearing.day09;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/10
 */
public class TestDateTimeFormatter {
    public static void main(String[] args) {
        // 将LocalDate 转为String格式
        LocalDateTime date =  LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = dateTimeFormatter.format(date);
        System.out.println(s);

        // 时间戳转字符串日期格式，先转为LocalDateTime, 再转为字符串日期
        long x = Instant.now().toEpochMilli();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(x), ZoneId.of("Asia/Shanghai"));
        System.out.println(localDateTime);
        System.out.println(ZoneId.systemDefault()); // 获取系统默认时区
        System.out.println(dateTimeFormatter.format(localDateTime));

        // 将字符串解析为日期
        String ss = "2022-05-01 12:20:30";
        LocalDateTime parse = LocalDateTime.parse(ss, dateTimeFormatter);
        System.out.println(parse);
    }
}
