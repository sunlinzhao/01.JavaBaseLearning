package com.slz.javalearing.day22;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/30
 */


@Config(className = "com.slz.javalearing.day22.Player", propertyName = "name", propertyValue = "傻逼")
public class TestConfig {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<TestConfig> testConfigClass = TestConfig.class;
        Config annotation = testConfigClass.getAnnotation(Config.class);
        String className = annotation.className();
        String propertyName = annotation.propertyName();
        String propertyValue = annotation.propertyValue();

        Class<?> aClass = Class.forName(className);
        Field field = aClass.getDeclaredField(propertyName);
        field.setAccessible(true);
        Object o = aClass.getConstructor().newInstance();
        field.set(o, propertyValue);

        System.out.println(o);

    }
}
