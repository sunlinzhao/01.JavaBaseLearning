package com.slz.javalearing.day15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/21
 */
public class TestAggregate { // 测试流聚合
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bb", "ccccccccccc", "ddd", "eeeeeee", "f");
        // 获取最大长度字符串
        Optional<String> max = list.stream().max(Comparator.comparingInt(String::length));
        max.ifPresent(System.out::println);
        // 获取最小长度字符串
        Optional<String> min = list.stream().min(Comparator.comparingInt(String::length));
        min.ifPresent(System.out::println);
        // 过滤并统计个数
        long count = list.stream().filter(s -> s.length()>=3).count();
        System.out.println(count);
    }
}
