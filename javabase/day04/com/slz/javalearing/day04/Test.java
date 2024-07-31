package com.slz.javalearing.day04;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/31
 */
public interface Test {
    int x = 0; // 接口中的成员全部默认是public static final，因此必须初始化
    void fun(); // 接口中的方法全部默认是public abstract（JDK1.8之前）,所以实现类重写方法时必须声明为public（一大）
}
