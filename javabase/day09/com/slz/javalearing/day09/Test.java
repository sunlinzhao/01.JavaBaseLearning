package com.slz.javalearing.day09;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/10
 */
public class Test {
    public static void main(String[] args) {
        LocalDateTime date=LocalDateTime.now();
        ZonedDateTime zonedDateTime = date.atZone(ZoneId.systemDefault());
        Instant instant =zonedDateTime.toInstant();
        Date date1 = Date.from(instant);
        String s= new SimpleDateFormat("yyyy-MM-dd").format(date1);
        System.out.println(s);
    }
}
