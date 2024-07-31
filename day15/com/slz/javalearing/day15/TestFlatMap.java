package com.slz.javalearing.day15;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/22
 */
public class TestFlatMap {
    public static void main(String[] args) {
        String str = "a,b,c,d,e";
        f(str).forEach(System.out::println);
        System.out.println("----------");
        String str1 = "1,2,3,4,5";
        List<String> list = Arrays.asList(str1, str);
        Stream<Stream<String>> streamStream = list.stream().map(TestFlatMap::f);
        streamStream.forEach(s->s.forEach(System.out::println));
        System.out.println("---------");
        list.stream().flatMap(TestFlatMap::f).forEach(System.out::println); // 所有返回的流合成一个流
    }

    public static Stream<String> f(String string) {
        String[] strs = string.split(",");
        return Arrays.stream(strs);
    }
}
