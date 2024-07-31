package com.slz.javalearing.day07;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/5
 */
public class TestString {
    public static void main(String[] args) {
        String str1 = "abc"; // /静态创建
        String str2 = new String("abc"); // 动态创建
        System.out.println(str1==str2); // false
        System.out.println(str1.equals(str2)); // true

        char[] chars = {'a', 'b', 'c'};
        String str3 = new String(chars); // 通过String构造方法, 将字符/字节/整数数组转为字符串
        String str4 = new String(chars, 0, 2); // 通过String构造方法, 将字符数组转为字符串
        System.out.println(str3); // abc
        System.out.println(str4); // ab

        String str5 = str4 + 10 + 20 + 'd'; // 字符串连接操作
        System.out.println(str5);

        String str6 = "abcabc";
        System.out.println(str6==str1+str1); // false
        System.out.println(str6=="abc"+"abc"); // true

    }
}
