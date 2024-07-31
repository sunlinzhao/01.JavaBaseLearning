package com.slz.javalearing.day21;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/29
 */
public class TestField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.slz.javalearing.day21.Joker");
        // 获取所有字段（公有），包括父类继承的
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(judgeModifiers(field.getModifiers()) + "\t" + field.getName());
        }
        System.out.println("----------");
        // 获取所有字段，不包括从父类继承的
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(judgeModifiers(declaredField.getModifiers()) + "\t" + declaredField.getName());
        }
        System.out.println("----------");
        // 通过反射赋值
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        Joker o1 = (Joker) o;
        // 获取单个属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true); // 设置Java访问权限不检查
        name.set(o1, "李白");
        System.out.println(o1);
    }
    public static String judgeModifiers(int val){
        switch (val){
            case 0:
                return "default";
            case 1:
                return "public";
            case 2:
                return "private";
            case 4:
                return "protected";
            default:
                return "other";
        }
    }
}
