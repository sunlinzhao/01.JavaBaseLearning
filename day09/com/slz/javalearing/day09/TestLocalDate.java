package com.slz.javalearing.day09;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/10
 */
public class TestLocalDate {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now(); // 获取系统时间
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate.toString());
        System.out.println(localTime.toString());
        System.out.println(localDateTime.toString());

        LocalDate localDate1 = LocalDate.of(2022, 9, 13);
        System.out.println(localDate1);

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfWeek().getValue());

        LocalDate date1 = localDate.withDayOfMonth(10).
                minusWeeks(4).
                withYear(2022); // 修改
        System.out.println(date1);

        System.out.println(localDateTime.plusDays(30)); // 延后30天
        System.out.println(localDateTime.minusDays(30)); // 提前30天
    }
}
