package com.slz.javalearing.day09;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/10
 */
public class TestTemporalAdjuster {
    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime1.with(DayOfWeek.MONDAY); // 获取本周一的时间

        localDateTime2 = localDateTime1.with(TemporalAdjusters.next(DayOfWeek.MONDAY)); // 获取下周一的时间
        System.out.println(localDateTime1);
    }
}
