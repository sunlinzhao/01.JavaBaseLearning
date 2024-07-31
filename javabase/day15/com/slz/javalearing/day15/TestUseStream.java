package com.slz.javalearing.day15;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/20
 */
public class TestUseStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(20, 30, 40, 50, 60, 70, 80);
        // 遍历
        list.stream().forEach(System.out::println);
        // 查找 1
        Integer integer = list.stream().filter(x -> x > 40).findFirst().orElse(-1);
        System.out.println(integer);
        // 查找 2
        Optional<Integer> any = list.stream().filter(x -> x > 40).findAny(); // 单流
        System.out.println(any.orElse(-1));
        Optional<Integer> any1 = list.parallelStream().filter(x -> x > 40).findFirst(); // 并行流
        Optional<Integer> any2 = list.parallelStream().filter(x -> x > 40).findAny(); // 并行流
        System.out.println(any1.orElse(-1));
        System.out.println(any2.orElse(-1));
        System.out.println("---> " + list.stream().findAny().orElse(-1));
        // 匹配
        boolean b1 = list.stream().allMatch(x -> x > 40);
        boolean b2 = list.stream().anyMatch(x -> x > 40);
        boolean b3 = list.stream().noneMatch(x -> x > 40);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
