package com.slz.javalearing.day09;

import java.time.Instant;
import java.time.ZoneOffset;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/10
 */
public class TestInstant {
    public static void main(String[] args) {
        Instant instant = Instant.now(); // 获取当前时间点
        System.out.println(instant);
        System.out.println(Instant.MIN); // 最大时间点
        System.out.println(Instant.MAX); // 最小时间点
        long l = instant.toEpochMilli();
        System.out.println(l); // 1970 到目前的毫秒数
        System.out.println(System.currentTimeMillis()); // 1970 到目前的毫秒数

        System.out.println(instant.atOffset(ZoneOffset.of("+8"))); // 东八区
        System.out.println(instant.atOffset(ZoneOffset.ofHours(8))) ; // 东八区
        System.out.println(instant.atOffset(ZoneOffset.ofHours(8)).toLocalDateTime()); // 再转回本地时间
        System.out.println(Instant.ofEpochMilli(System.currentTimeMillis())); // 将时间戳转为Instant
    }
}
