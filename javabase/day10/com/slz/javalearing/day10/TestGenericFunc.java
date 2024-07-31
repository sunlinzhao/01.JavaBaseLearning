package com.slz.javalearing.day10;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/11
 */
public class TestGenericFunc { // 测试泛型方法
    public static void main(String[] args) {
        fun1("hello");
        System.out.println((String) fun2());
        System.out.println(fun3("hello"));
    }
    public static <T> void fun1(T t){
        System.out.println(t);
    }
    public static <T> T fun2(){
        return (T) "hello";
    }
    public static <T> T fun3(T t){
        return t;
    }
}
