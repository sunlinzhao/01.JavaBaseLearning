package com.slz.javalearing.day14;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/19
 */
public class TestFuncRef { // 测试方法引用
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 6, 2, 8, 1);
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1, o2);
//            }
//        });
//        list.sort((x, y) -> Integer.compare(x, y));
        list.sort(Integer::compare);                    // 1.1 静态方法引用
        System.out.println(list);
        Consumer<Integer> consumer = X::test;           // 1.2 静态方法引用
        consumer.accept(123);

        Supplier<Integer> supplier = new X()::test1;    // 2.1 实例方法引用
        System.out.println("随机数: " + supplier.get());
        list.forEach(System.out::println);              // 2.2 实例方法引用

        String s = "abc";
        Function<String, String> function = String::toUpperCase; // 3.1 特殊方法引用，类名引用实例方法
        System.out.println(function.apply(s));

        Supplier<X> supplier1 = X::new;                          // 4.1 构造方法引用
        System.out.println(supplier1.get());
        Function<String, X> function1 = X::new;                  // 4.2 构造方法引用
        System.out.println(function1.apply("sun"));
        BiFunction<String, Integer, X> biFunction = X::new;      // 4.3 构造方法引用
        System.out.println(biFunction.apply("li", 18));
    }
}

class X{
    public String name;
    public Integer age;

    public X() {
        System.out.println("无参构造");
    }

    public X(String name) {
        this.name = name;
        System.out.println("一个参数构造");
    }

    public X(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("两个参数构造");
    }

    public static void test(Integer x){
        System.out.println("输出: " + x);
    }
    public int test1(){
        return new Random().nextInt();
    }

    @Override
    public String toString() {
        return "X{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
