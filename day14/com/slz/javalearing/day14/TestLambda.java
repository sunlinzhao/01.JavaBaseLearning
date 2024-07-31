package com.slz.javalearing.day14;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/17
 */
public class TestLambda {
    public static void main(String[] args) {
        MathInterface mathInterface = new MathInterface() { // 1. 匿名内部类方式实现函数功能
            @Override
            public Integer expend10(Integer i) {
                return i*10;
            }
        };
        System.out.println(mathInterface.expend10(10));
        MathInterface mathInterface1 = (i) -> {return i*10;}; // 2. lambda 表达式实现函数功能
        MathInterface mathInterface2 = i -> i*10;             // 2. lambda 表达式实现函数功能
        System.out.println(mathInterface1.expend10(10));
        System.out.println(mathInterface2.expend10(10));
    }
}
