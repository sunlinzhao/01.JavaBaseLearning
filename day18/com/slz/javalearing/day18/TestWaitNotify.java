package com.slz.javalearing.day18;

import java.util.concurrent.TimeUnit;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/30
 */
public class TestWaitNotify {
    private static final Object obj_lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (obj_lock){
                try {
                    System.out.println("线程1等待..." );
                    obj_lock.wait(); // 线程1进入 waitset 等待，直到被其他线程唤醒
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程1被唤醒后继续执行");
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (obj_lock){
                try {
                    System.out.println("线程2等待...");
                    obj_lock.wait(2000); // // 线程1进入 waitset 等待，直到被其他线程唤醒，或者等待时间过去
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程2被唤醒后继续执行");
            }
        });
        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        synchronized (obj_lock){
            System.out.println("t1: " + t1.getState());
            System.out.println("t2: " + t2.getState());
            obj_lock.notifyAll(); // 主线程获取到锁，并唤醒 waitset 中的所有线程
//            obj_lock.notify(); // 主线程获取到锁，并唤醒 waitset 中的某个线程
            System.out.println("主线程唤醒waitset中的所有线程");
        }
    }
}
