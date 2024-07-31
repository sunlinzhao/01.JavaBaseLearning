package com.slz.javalearing.day19;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/2
 */
public class Test2 {
    static int i = 0;
    static ReentrantLock fairLock = new ReentrantLock(true);
    static ReentrantLock unfairLock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(()->{
            while (i < 1000) {
                unfairLock.lock();
                i++;
                System.out.println(Thread.currentThread().getName()+ ":" + i);
                unfairLock.unlock();
            }
        }, "t1").start();
        new Thread(()->{
            while (i < 1000) {
                unfairLock.lock();
                i++;
                System.out.println(Thread.currentThread().getName()+ ":" + i);
                unfairLock.unlock();
            }
        }, "t2").start();
    }
}
