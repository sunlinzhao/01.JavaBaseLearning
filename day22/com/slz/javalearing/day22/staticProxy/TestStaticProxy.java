package com.slz.javalearing.day22.staticProxy;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/30
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        Defendant defendant = new Defendant();
        Court court = new Lawyer(defendant); // 同一个接口下可以实现互换
        court.litigate();
    }
}
