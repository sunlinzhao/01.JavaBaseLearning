package com.slz.javalearing.day06;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/4
 */
public class TestWrapper {
    public static void main(String[] args) {
        int x = 10;
        Integer y = Integer.valueOf(x); // 基本类型转包装类
        int z = y.intValue(); // 包装类转基本类型
        Character c = 's';
        char cc = c.charValue();
        String xs = String.valueOf(x); // 基本转字符串
        String ys = y.toString(); // 包装类转字符串
        String str = "123";
        int xstr = Integer.parseInt(str); // 字符串解析为基本类型

        Integer num1 = 128;
        Integer num2 = 128;
        Integer num3 = 125;
        Integer num4 = 125;
        System.out.println(num1==num2); // false
        System.out.println(num1.equals(num2)); // true
        System.out.println(num3==num4); // true
        System.out.println(num3.equals(num4)); // true
    }
}
