package com.slz.javalearing.day21;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/29
 */
public class TestClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = TestClassLoader.class.getClassLoader();
        System.out.println(classLoader); // jdk.internal.loader.ClassLoaders$AppClassLoader@71bc1ae4
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1); // jdk.internal.loader.ClassLoaders$PlatformClassLoader@58ceff1
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2); // null
    }
}
