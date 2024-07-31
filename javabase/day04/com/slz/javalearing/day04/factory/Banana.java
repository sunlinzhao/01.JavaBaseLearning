package com.slz.javalearing.day04.factory;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/31
 */
public class Banana implements Fruit{
    @Override
    public void plant() {
        System.out.println("香蕉种植");
    }

    @Override
    public void grow() {
        System.out.println("香蕉生长");
    }

    @Override
    public void harvest() {
        System.out.println("香蕉收获");
    }
}
