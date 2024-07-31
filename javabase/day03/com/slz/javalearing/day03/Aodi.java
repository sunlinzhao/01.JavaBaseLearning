package com.slz.javalearing.day03;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/30
 */
public class Aodi extends Car{

    public Aodi() {
        super("blue");
        System.out.println("这是子类构造器");
    }

    public void show(){
        showCount();
    }
}
