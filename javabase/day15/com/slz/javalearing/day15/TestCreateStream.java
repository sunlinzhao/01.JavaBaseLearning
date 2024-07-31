package com.slz.javalearing.day15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/19
 */
public class TestCreateStream {
    public static void main(String[] args) throws IOException {
        // 1. 通过 Collection 接口的 stream() 方法使用集合创建流(Collection内置有stream方法);
        List<String> list = Arrays.asList("aa", "bb", "cc");
        Stream<String> stream1 = list.stream();
        // 2. 使用 Arrays.stream(T[] array) 方法使用数组创建流；
        String[] strs = {"aa", "bb", "cc"};
        Stream<String> stream2 = Arrays.stream(strs);
        // 3. 使用 StreamAPI 中的静态方法来创建流；
        // 3.1. 有限流
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");
        // 3.2. 无限流 - 迭代 / 可以用 limit 加以限制
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2); // 从 0 开始
//        stream4.forEach(System.out::println);
        Stream<Integer> stream5 = Stream.iterate(0, x -> x + 2).limit(10);
        stream5.forEach(System.out::println);
        // 3.3. 无限流 - 生成 / 可以用 limit 加以限制
        Stream<Double> stream6 = Stream.generate(Math::random).limit(10);
        stream6.forEach(System.out::println);
        // 3.4 Stream concat 方法合并流
        Stream<String> stream7 = Arrays.stream(new String[]{"aa", "bb", "cc"});
        Stream<String> stream8 = Arrays.stream(new String[]{"aa", "bb", "cc"});
        Stream<String> stream9 = Stream.concat(stream7, stream8);
        // 4. 文件流
        Stream<String> stream10 = Files.lines(Path.of("javabase/resource/data.txt"));
        stream10.forEach(System.out::println);
    }
}