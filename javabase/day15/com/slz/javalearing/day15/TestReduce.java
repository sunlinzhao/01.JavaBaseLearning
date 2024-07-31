package com.slz.javalearing.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/22
 */
public class TestReduce {
    public static void main(String[] args) {
        // 基本数据类型
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
        // 使用归约 1
        stream.reduce(Integer::sum).ifPresent(System.out::println);
        // 使用归约 2
        Integer reduce = stream1.reduce(0, Integer::sum); // 有一个初始值
        System.out.println(reduce); // 在流上不能进行两次流操作
        // 乘积
        stream2.reduce((x, y) -> x * y).ifPresent(System.out::println);
        // 最大值
        stream3.reduce((x,y)->x>y?x:y).ifPresent(System.out::println);
        // 引用类型
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("张飞", 18));
        list1.add(new Student("李白", 20));
        list1.add(new Student("杜甫", 22));
        // 求和
        Integer reduce1 = list1.stream().reduce(0, (sum, student) -> sum += student.getAge(), Integer::sum);
        System.out.println(reduce1);
        Integer reduce2 = list1.stream().map(Student::getAge).reduce(0, Integer::sum);
        System.out.println(reduce2);
    }
}
