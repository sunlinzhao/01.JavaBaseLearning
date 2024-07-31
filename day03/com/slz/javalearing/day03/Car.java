package com.slz.javalearing.day03;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/30
 */
public class Car {
    public String color;
    public String gps;
    private int count;

    public Car() {
        System.out.println("这是父类构造器");
    }

    public Car(String color){
        System.out.println("这是父类有参构造器");
    }

    public void showCount(){
        System.out.println(count);
    }

    public int getCount() {
        return count;
    }
}
