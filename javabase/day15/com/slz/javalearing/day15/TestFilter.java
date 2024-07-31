package com.slz.javalearing.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/21
 */
public class TestFilter {
    public static void main(String[] args) {
        // 对基本数据类型的过滤
        Stream<Integer> stream = Stream.of(4, 3, 5, 7, 8, 9, 100, 20);
        stream.filter(x -> x > 10).forEach(System.out::println);
        System.out.println("----------");
        // 对引用类型的过滤
        List<Student> list = new ArrayList<>();
        list.add(new Student("张飞", 18));
        list.add(new Student("李白", 20));
        list.add(new Student("杜甫", 22));
        list.add(new Student("李商隐", 20));
        list.add(new Student("李商隐", 20));
        list.add(new Student("杜康", 16));
        list.add(new Student("杜康", 16));
        list.stream().filter(student -> student.getName().length() > 2).forEach(System.out::println);
        System.out.println("----------");
        // 切片 -> limit 截断
        list.stream().filter(student -> student.getAge() >= 18).limit(2).forEach(System.out::println); // 截取前两个，不足两个时获取全部
        System.out.println("----------");
        // 切片 -> skip 跳过
        list.stream().filter(student -> student.getAge() >= 18).skip(2).forEach(System.out::println); // 跳过前两个，超过全部大小则返回空流
        // 切片 -> distinct 去重
        System.out.println("----------");
        list.stream().distinct() // 依赖于 hashcode 与 equals
                .forEach(System.out::println);
    }
}
