package com.slz.javalearing.day08;

import java.util.Arrays;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/6
 */
public class TestSystem {
    public static void main(String[] args) {
        String JAVA_HOME = System.getenv("JAVA_HOME"); // 获取环境变量
        System.out.println(JAVA_HOME);

        String p = System.getProperty("os.name"); // 获取系统属性
        System.out.println(p);

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {10, 20, 30, 40, 50};
        System.arraycopy(arr1, 2, arr2, 2, 3);
        System.out.println(Arrays.toString(arr2));
        System.gc();
    }
}
