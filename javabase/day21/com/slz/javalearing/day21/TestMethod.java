package com.slz.javalearing.day21;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/29
 */
public class TestMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Joker> jokerClass = Joker.class;
        // 获取所有方法（不包括构造方法）
        Method[] declaredMethods = jokerClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println("\t" + exceptionType.getName());
            }
            Parameter[] parameters = declaredMethod.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("\t\t" + parameter.getType().getSimpleName() + " " + parameter.getName());
            }
        }
        // 调用方法
        Joker joker = jokerClass.getConstructor().newInstance();
        Method test2 = jokerClass.getDeclaredMethod("test2", String.class);
        test2.setAccessible(true); // 设值java访问权限不检查
        test2.invoke(joker, "傻逼");
    }
}
