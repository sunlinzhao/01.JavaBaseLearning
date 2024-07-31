package com.slz.javalearing.day21;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/30
 */
public class TestFatherClass {
    public static void main(String[] args) {
        // 获取继承的父类
        Class<?> jokerInterClass = JokerInterImpl.class;
        Class<?> superclass = jokerInterClass.getSuperclass();
        System.out.println(superclass.getSimpleName());

        // 获取父类泛型
        Type genericSuperclass = jokerInterClass.getGenericSuperclass();
        if(genericSuperclass instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument.getTypeName());
            }
        }
        System.out.println("----------------");
        // 获取实现的接口
        Class<?>[] interfaces = jokerInterClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getSimpleName());
        }
        // 获取接口泛型
        Type[] genericInterfaces = jokerInterClass.getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            if (genericInterface instanceof ParameterizedType){
                ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
                for (Type actualTypeArgument : parameterizedType.getActualTypeArguments()) {
                    System.out.println(actualTypeArgument.getTypeName());
                }
            }
        }
    }
}
