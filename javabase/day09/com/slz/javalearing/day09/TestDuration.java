package com.slz.javalearing.day09;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/10
 */
public class TestDuration {
    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 1, 10, 10, 10,5);
        LocalDateTime localDateTime2 = LocalDateTime.now();
        // 方式 1
        Duration duration = Duration.between(localDateTime1, localDateTime2);
        System.out.println(duration.toDays()); // 计算俩个日期相差天数
        System.out.println(duration.toHours()); // 计算俩个日期相差小时
        System.out.println(duration.toSeconds()); // 计算俩个日期相差秒数
        System.out.println(duration.getSeconds()); // 同上
        // 方式 2
        System.out.println(localDateTime1.until(localDateTime2, ChronoUnit.DAYS)); // 计算俩个日期相差天数
        System.out.println(localDateTime1.until(localDateTime2, ChronoUnit.HOURS)); // 计算俩个日期相差小时
        System.out.println(localDateTime1.until(localDateTime2, ChronoUnit.SECONDS)); // 计算俩个日期相差秒数
        // 方式 3
        System.out.println(ChronoUnit.YEARS.between(localDateTime1, localDateTime2));
        System.out.println(ChronoUnit.HOURS.between(localDateTime1, localDateTime2));
        System.out.println(ChronoUnit.DAYS.between(localDateTime1, localDateTime2));
    }
}
