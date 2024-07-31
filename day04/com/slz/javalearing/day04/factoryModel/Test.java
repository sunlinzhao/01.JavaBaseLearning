package com.slz.javalearing.day04.factoryModel;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/2
 */
public class Test {
    public static void main(String[] args) {
        Factory factory = new AppleFactory();
        Fruit fruit = factory.getFruit();
        fruit.grow();
        fruit.plant();
        fruit.harvest();
    }
}
