package com.slz.javalearing.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/22
 */
public class TestJoin {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("张飞", 19));
        list1.add(new Student("李白", 18));
        // joining 无参拼接
        String collect = list1.stream().map(Student::getName).collect(Collectors.joining());
        System.out.println(collect);
        // 一个参数，连接符号
        String collect1 = list1.stream().map(Student::getName).collect(Collectors.joining(","));
        System.out.println(collect1);
        // 三个参数：连接符号，前缀，后缀
        String collect2 = list1.stream().map(Student::getName).collect(Collectors.joining(",","AKA: ","@"));
        System.out.println(collect2); // 是拼接后的整个字符串添加前缀和后缀
    }
}
