package com.slz.javalearing.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/22
 */
public class TestPartitionGroup {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("张飞", 19));
        list1.add(new Student("张飞", 18));
        list1.add(new Student("李白", 19));
        list1.add(new Student("李白", 16));
        // 分区
        Map<Boolean, List<Student>> collect = list1.stream().collect(Collectors.partitioningBy(x -> x.getAge() >= 18));
        collect.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
        // 分组
        Map<String, List<Student>> collect1 = list1.stream().collect(Collectors.groupingBy(Student::getName)); // 按名字分组
        collect1.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
        Map<Integer, List<Student>> collect2 = list1.stream().collect(Collectors.groupingBy(Student::getAge)); // 按年龄分组
        collect2.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
        System.out.println("----------");
        // 多重分组，先名字，后按年龄
        Map<String, Map<Integer, List<Student>>> collect3 = list1.stream().collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(Student::getAge)));
        collect3.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((x, y) ->{
                System.out.println(x);
                y.forEach(System.out::println);
            });
        });
        // 按年龄分组，返回自定义键
        Map<String, List<Student>> collect4 = list1.stream().collect(Collectors.groupingBy(student -> {
            if (student.getAge() >= 18) return "成年";
            else return "未成年";
        }));
        System.out.println("----------");
        collect4.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
    }
}
