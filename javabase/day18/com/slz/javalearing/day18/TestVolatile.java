package com.slz.javalearing.day18;

import java.util.concurrent.TimeUnit;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/30
 */
public class TestVolatile {
    private volatile static Boolean b = true; // 设置 volatile 保证可见性,(直接从主内存读取变量值)
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println("子线程开始执行");
            while (b){
//                System.out.println("子线程正在执行...");
                // 打印操作（特别是System.out.println）通常涉及I/O操作，
                // 这类操作通常是耗时的，可能导致当前执行打印的线程被挂起，从而让出CPU给其他线程。
                // 这种上下文切换为其他线程提供了执行的机会，包括修改共享变量的线程，因此可能帮助暴露或解决了原本由于缺乏适当同步而隐藏的问题。
            }
            System.out.println("子线程执行结束");
        }).start();
        TimeUnit.SECONDS.sleep(2);
        b = false;
        System.out.println("主线程设置b=false");
    }
}
