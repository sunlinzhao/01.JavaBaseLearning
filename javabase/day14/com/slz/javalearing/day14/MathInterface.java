package com.slz.javalearing.day14;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/17
 */
@FunctionalInterface // 函数式接口注解，检查是否是函数式接口
public interface MathInterface {
    Integer expend10(Integer i);
//    Integer abs(Integer i); // 一个函数式接口，有且只有一个抽象方法
    default Integer abs(Integer i){
        return Math.abs(i);
    }
}
