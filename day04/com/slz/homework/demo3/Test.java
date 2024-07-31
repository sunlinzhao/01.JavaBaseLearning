package com.slz.homework.demo3;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/2
 */
public class Test {
    public static void main(String[] args) {
        Factory factory1 = new ManFactory();
        Factory factory2 = new WomanFactory();
        factory1.getPeople().say();
        factory2.getPeople().say();
    }
}
