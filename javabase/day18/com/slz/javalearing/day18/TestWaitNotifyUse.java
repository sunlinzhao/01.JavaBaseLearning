package com.slz.javalearing.day18;

import java.util.concurrent.TimeUnit;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/30
 */
public class TestWaitNotifyUse {
    private static final Object obj_lock = new Object();
    private static Boolean condition1 = false;
    private static Boolean condition2 = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (obj_lock){
                while (!condition1){
                    try {
                        System.out.println(Thread.currentThread().getName() + "条件不满足, 进入等待...");
                        obj_lock.wait();  // 进入等待,并释放锁
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + "条件满足, 执行完毕!");
            }
        }, "线程1").start();
        new Thread(()->{
            synchronized (obj_lock){
                while (!condition2){
                    try {
                        System.out.println(Thread.currentThread().getName() + "条件不满足, 进入等待...");
                        obj_lock.wait(); // 进入等待,并释放锁
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + "条件满足, 执行完毕!");
            }
        }, "线程2").start();
        TimeUnit.MILLISECONDS.sleep(1000); // 主线程休眠
        new Thread(()->{ // 使得条件一满足
            synchronized (obj_lock){ // 要使用 notifyAll / notify 需要使用 synchronized 获得锁
                condition1 = true;
                System.out.println("condition1 置为 true");
                obj_lock.notifyAll();
            }
        }).start();
        TimeUnit.MILLISECONDS.sleep(1000); // 主线程休眠
        new Thread(()->{ // 使得条件二满足
            synchronized (obj_lock){ // 要使用 notifyAll / notify 需要使用 synchronized 获得锁
                condition2 = true;
                System.out.println("condition2 置为 true");
                obj_lock.notifyAll();
            }
        }).start();
    }
}
