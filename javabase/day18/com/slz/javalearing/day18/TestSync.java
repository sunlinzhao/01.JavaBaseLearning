package com.slz.javalearing.day18;

import com.slz.javalearing.day09.Test;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/30
 */
public class TestSync {
    public static int  x = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
               for (int i = 0; i < 10000; i++) {
                   synchronized (Test.class){ // 加锁
                        x++;
                   }
               }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                synchronized (Test.class){ // 加锁
                    x--;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(x); // 每次运行结果是不确定的
    }
}
