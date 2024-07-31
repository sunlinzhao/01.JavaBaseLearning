package com.slz.javalearing.day22.dynamicProxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/30
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        // 创建被代理对象
        UserServiceImpl userService = new UserServiceImpl();
        // 创建代理对象
        /**
         * ClassLoader loader: 被代理类对象的类加载器
         * Class<?>[] interfaces: 被代理类对象的实现接口
         * InvocationHandler h: 代理对象
         */
        Object o = Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), new MyHandler(userService));
        UserService service = (UserService) o;
        service.deleteUser();
        System.out.println("----------");
        service.saveUser();
    }
}
