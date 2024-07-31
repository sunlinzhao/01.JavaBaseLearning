package com.slz.javalearing.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/22
 */
public class TestMapping {
    public static void main(String[] args) {
        // map 映射操作基本数据类型 【转换】
        List<Double> list = Arrays.asList(3.1415, 1.1234, 8.8765, 4.4321, 7.521, 0.912); // 包装类是 final 不可改变
        list.stream().map(TestMapping::k2).forEach(System.out::println);
        list.forEach(System.out::println);
        System.out.println("------------");
        // map 映射操作引用数据类型 【提取】
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("张飞", 18));
        list1.add(new Student("李白", 20));
        list1.add(new Student("杜甫", 22));
        list1.stream().map(Student::getName).forEach(System.out::println);
        System.out.println("------------");
        // map 映射操作引用数据类型 【修改】 改变数据源的数据
        list1.stream().map(student -> {
            student.setName("AKA: " + student.getName());
            return student;
        }).forEach(System.out::println);
        list1.forEach(System.out::println);
        System.out.println("------------");
        // map 映射操作引用数据类型 【修改】 不改变数据源的数据
        list1.stream().map(student -> {
            Student student1 = new Student(student.getName(), student.getAge() + 2);
            return student1;
        }).forEach(System.out::println);
        list1.forEach(System.out::println);

    }
    public static double k2(double x){ // 保留两位小数
       return  (int)((x*100)+0.5) / 100d;
    }
}
