package com.slz.javalearing.day04.factoryModel;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/2
 */
public class Apple implements Fruit{ // 具体产品
    @Override
    public void plant() {
        System.out.println("苹果种植");
    }

    @Override
    public void grow() {
        System.out.println("苹果生长");
    }

    @Override
    public void harvest() {
        System.out.println("苹果收获");
    }
}
