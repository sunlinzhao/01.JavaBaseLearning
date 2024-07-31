package com.slz.javalearing.day15;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/22
 */
public class TestCollect {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("张飞", 19));
        list1.add(new Student("李白", 18));
        list1.add(new Student("李上瘾", 18));
        list1.add(new Student("曹操", 22));

        // toList
        List<Student> list2 = list1.stream().filter(student -> student.getName().startsWith("李")).collect(Collectors.toList());
        System.out.println(list2);
        // toSet
        Set<Integer> set = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(x -> x % 2 == 0).collect(Collectors.toSet());
        System.out.println(set);
        // toMap
        Map<String, Integer> map = list1.stream().filter(student -> student.getName().startsWith("李")).collect(Collectors.toMap(Student::getName, Student::getAge));// key val
        System.out.println(map);
        // toCollection
        ArrayList<String> collect = Stream.of("aa", "ss", "fff").collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);

        // 统计
        Long aLong = list1.stream().filter(x -> x.getName().startsWith("李")).collect(Collectors.counting());
        Long aLong1 = list1.stream().filter(x -> x.getName().startsWith("李")).count();
        System.out.println(aLong);
        System.out.println(aLong1);
        // 最值
        Optional<Student> collect1 = list1.stream().filter(x -> x.getAge() > 18).collect(Collectors.maxBy(Comparator.comparingInt(Student::getAge)));
        Optional<Student> collect2 = list1.stream().filter(x -> x.getAge() > 18).max(Comparator.comparingInt(Student::getAge));
        System.out.println(collect1.orElse(null));
        System.out.println(collect2.orElse(null));
        // 求和
        Integer collect3 = list1.stream().collect(Collectors.summingInt(Student::getAge));
        int sum = list1.stream().mapToInt(Student::getAge).sum();
        System.out.println(collect3);
        System.out.println(sum);
        // 均值
        Double collect4 = list1.stream().collect(Collectors.averagingDouble(Student::getAge));
        OptionalDouble average = list1.stream().mapToInt(Student::getAge).average(); // 先转为数值流
        System.out.println(collect4);
        System.out.println(average.orElse(-1));
        // 摘要
        IntSummaryStatistics collect5 = list1.stream().collect(Collectors.summarizingInt(Student::getAge));
        IntSummaryStatistics intSummaryStatistics = list1.stream().mapToInt(Student::getAge).summaryStatistics();
        System.out.println(collect5);
        System.out.println(intSummaryStatistics);
    }
}
