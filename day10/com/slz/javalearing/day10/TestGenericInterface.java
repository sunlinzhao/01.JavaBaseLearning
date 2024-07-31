package com.slz.javalearing.day10;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/11
 */
public class TestGenericInterface {
    public static void main(String[] args) {
        GenericInterface<String> genericInterface1 = new impl1();
//        GenericInterface<Integer> genericInterface2 = new impl1(); // 报错；实现1不够灵活
        GenericInterface<Integer> genericInterface3 = new impl2<>(); // 实现2足够灵活
        GenericInterface<String> genericInterface4 = new impl2<>();
    }
}
