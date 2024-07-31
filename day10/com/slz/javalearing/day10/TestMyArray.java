package com.slz.javalearing.day10;

import java.util.stream.Stream;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/11
 */
public class TestMyArray {
    public static void main(String[] args) {
        MyArray myArray  = new MyArray(4);
        myArray.add(1);
        myArray.add(1);
        myArray.add(1);
        myArray.add(1);
        myArray.add(1);
        System.out.println(myArray.size());
//        System.out.println(myArray.get(9));
        myArray.add(0, 123);
        System.out.println(myArray.get(0));
        myArray.remove(0);
        System.out.println(myArray.get(0));
    }
}
