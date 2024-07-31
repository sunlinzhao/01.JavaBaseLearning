package com.slz.javalearing.day14;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/19
 */
public class TestFunctionInterface {
    public static void main(String[] args) {
//        Consumer<Integer> consumer = x -> System.out.println(x);
//        consumer.accept(123);
        test1(123, x-> System.out.println("获得" + x + "元")); // 1. 消费型接口
        test2(()->{                                              // 2. 供给型接口
            StringBuilder sb = new StringBuilder();
            String pattern = "abcdefghijklmnopqrstuvwxyz0123456789";
            Random random = new Random();
            for(int i=0; i<5; i++){
                sb.append(pattern.charAt(Math.abs(random.nextInt()) % pattern.length()));
            }
            System.out.println("验证码: " + sb.toString());
            return sb.toString();
        });
        System.out.println(test3(10, x->x*x));                  // 3. 函数型接口
        System.out.println(test4(100, x->x>0));                 // 4. 断言型接口
    }
    public static void test1(Integer x, Consumer<Integer> consumer){ // 函数式接口作为形参
        consumer.accept(x);
    }
    public static void test2(Supplier<String> supplier){ // 函数式接口作为形参
        supplier.get();
    }
    public static Integer test3(Integer x, Function<Integer, Integer> function){ // 函数式接口作为形参
        return function.apply(x);
    }
    public static boolean test4(Integer x, Predicate<Integer> predicate){ // 函数式接口作为形参
        return predicate.test(x);
    }
}
