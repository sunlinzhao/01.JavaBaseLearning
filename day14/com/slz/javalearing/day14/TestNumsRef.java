package com.slz.javalearing.day14;

import java.util.function.Function;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/19
 */
public class TestNumsRef {
    public static void main(String[] args) {
//        Function<Integer, int[]> function = new Function<Integer, int[]>() {
//            @Override
//            public int[] apply(Integer integer) {
//                return new int[integer];
//            }
//        };
//        Function<Integer, int[]> function1 = x->new int[x];
        Function<Integer, int[]> function2 = int[]::new;
        System.out.println(function2.apply(3).length);
    }
}
