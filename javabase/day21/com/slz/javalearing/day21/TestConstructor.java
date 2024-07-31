package com.slz.javalearing.day21;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/29
 */
public class TestConstructor {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> jokerClass = Joker.class;
        // 调用无参构造方法 - 公有
        Constructor<?> constructor = jokerClass.getConstructor();
        Object o = constructor.newInstance();
        Joker joker = (Joker) o;
        System.out.println(joker);
        // 调用有参构造方法 - 公有
        Constructor<?> constructor1 = jokerClass.getConstructor(String.class, Integer.class);
        Object o1 = constructor1.newInstance("李白", 15);
        Joker joker1 = (Joker) o1;
        System.out.println(joker1);

        // 调用私有构造方法 - 私有/公有都可以
        // 获取构造方法列表
        Constructor<?>[] declaredConstructors = jokerClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName()); // 获取构造函数名
            for (Class<?> parameterType : declaredConstructor.getParameterTypes()) {
                System.out.println(parameterType.getName()); // 获取构造函数名
            }
        }
        // 调用私有构造方法
        Constructor<?> declaredConstructor = declaredConstructors[1];
        declaredConstructor.setAccessible(true); // 取消JAVA语言对访问的检查
        Object o2 = declaredConstructor.newInstance("李琦");
        System.out.println((Joker) o2);
    }
}
