package com.slz.javalearing.day22.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/30
 */
public class MyHandler implements InvocationHandler {
    // 被代理的目标对象
    private Object object;

    public MyHandler(Object object) {
        this.object = object;
    }

    /**
     *
     * @param proxy jdk创建的代理对象，无需赋值
     * @param method 目标类中的方法,jdk提供拦截的目标类正在调用的方法
     * @param args 目标类中方法的参数
     * @return 调用方法后的返回的结果
     * @throws Throwable
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (checkPermission()){
            Object result = method.invoke(object, args);
            log();
            return result;
        }
        return null;
    }

    private boolean checkPermission(){
        System.out.println("校验用户权限...");
        return true;
    }

    private void log(){
        System.out.println("生成日志...");
    }
}
