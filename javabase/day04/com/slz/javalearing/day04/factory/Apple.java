package com.slz.javalearing.day04.factory;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/31
 */
public class Apple implements Fruit{

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
