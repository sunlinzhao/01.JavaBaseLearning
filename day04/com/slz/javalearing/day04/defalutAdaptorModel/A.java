package com.slz.javalearing.day04.defalutAdaptorModel;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/2
 */
public interface A {
    void x();
    void y();
    void z();

    default void k(){
        System.out.println("默认的代码");
    }
}
