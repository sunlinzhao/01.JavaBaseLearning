package com.slz.homework.demo2;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/2
 */
public class Test {
    public static void main(String[] args) {
        Factory factory = new Factory();
        People people1 = factory.getPeople("man");
        People people2 = factory.getPeople("woman");
        people1.say();
        people2.say();
    }
}
