package com.slz.javalearing.day04.factoryModel;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/2
 */
public class AppleFactory implements Factory{ // 具体工厂
    @Override
    public Fruit getFruit() {
        return new Apple();
    }
}
