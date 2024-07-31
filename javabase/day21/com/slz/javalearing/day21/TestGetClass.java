package com.slz.javalearing.day21;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/29
 */
public class TestGetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        // 方法一
        Class<?> clazz = Class.forName("com.slz.javalearing.day21.Joker");
        // 方法二
        Class<?> jokerClass = Joker.class;
        System.out.println(clazz==jokerClass); // true 类只载入一次
        // 方法三
        Joker joker = new Joker("张三", 18);
        Class<?> aClass = joker.getClass();
        // 方法四
        ClassLoader classLoader = Joker.class.getClassLoader();
        Class<?> aClass1 = classLoader.loadClass("com.slz.javalearing.day21.Joker");

        // 以上都是class

        // interface 接口
        Class<?> jokerInterClass = JokerInter.class;
        // 数组
        int[] nums = new int[3];
        Class<?> aClass2 = nums.getClass();
        Class<?> aClass3 = int[].class;
        // 基本数据类型
        Class<?> doubleClass = double.class;
        // void
        Class<?> voidClass = void.class;
        // 枚举
        Class<?> enumClass = Enum.class;
    }
}
