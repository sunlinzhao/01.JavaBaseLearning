package com.slz.javalearing.day04.factory;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/31
 */
public class Factory {
    public static Fruit getFruit(String s){ // 静态工厂
        if("apple".equals(s)){
            return new Apple();
        } else if("banana".equals(s)){
            return new Banana();
        }
        return null;
    }
}
