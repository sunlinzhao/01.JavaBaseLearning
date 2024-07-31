package com.slz.javalearing.day15;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/22
 */
public class TestMapToX {
    public static void main(String[] args) {
        // 数值
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 2, 4, 6, 8);
        list.stream().mapToInt(x -> x * 10).forEach(System.out::println); // mapToInt 必须返回 int
        System.out.println("----------");
        // 非数值
        List<String> list1 = Arrays.asList("aaaa", "bbb", "c");
        list1.stream().mapToInt(String::length).forEach(System.out::println);
        int sum = list1.stream().mapToInt(String::length).sum();
        OptionalInt max = list1.stream().mapToInt(String::length).max();
        OptionalInt min = list1.stream().mapToInt(String::length).min();
        OptionalDouble average = list1.stream().mapToInt(String::length).average();
        System.out.println("sum " + sum + " max " + max.orElse(-1) + " min " + min.orElse(-1) + " aaverage " + average.orElse(-1));
        // summary 获取所有信息 摘要
        IntSummaryStatistics intSummaryStatistics = Stream.of("1", "2", "3").mapToInt(Integer::valueOf).summaryStatistics();
        System.out.println(intSummaryStatistics);
        // 范围生成流
        int sum1 = IntStream.rangeClosed(1, 100).sum(); // 左右闭区间
        int sum2 = IntStream.range(1, 100).sum(); // 左闭右开区间
        System.out.println(sum1);
        System.out.println(sum2);
        // boxed 将数值流转成 Stream
        Stream<Integer> boxed = IntStream.rangeClosed(1, 100).boxed();
    }
}
