package com.slz.javalearing.day15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/22
 */
public class TestSorted {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("张飞", 19));
        list1.add(new Student("李白", 18));
        list1.add(new Student("阿甫ssa", 22));
        list1.add(new Student("卜甫s", 22));
        list1.add(new Student("曹甫ss", 22));
        list1.stream().forEach(System.out::println);
        System.out.println("---------");
        list1.stream().sorted(Comparator.comparingInt(Student::getAge)).forEach(System.out::println); // 自定义排序
        // 多重排序
        System.out.println("---------");
        list1.stream().sorted(Comparator.comparingInt(Student::getAge).thenComparingInt(x -> x.getName().length())).forEach(System.out::println);
        // 顺序反转
        System.out.println("---------");
        list1.stream().sorted(Comparator.comparingInt(Student::getAge).reversed()).forEach(System.out::println);
    }
}
