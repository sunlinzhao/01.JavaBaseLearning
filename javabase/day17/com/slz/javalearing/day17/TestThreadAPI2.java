package com.slz.javalearing.day17;

import java.util.concurrent.TimeUnit;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/29
 */
public class TestThreadAPI2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始");
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
//                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("子线程被唤醒");
                System.out.println("4: " + Thread.currentThread().getState()); // 线程休眠被唤醒后. 跳过休眠，进入RUNNABLE状态
                throw new RuntimeException(e);
            }
            System.out.println("子线程结束");
        });
        System.out.println("1: " + t1.getState()); // NEW
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("2: " + t1.getState()); // TIMED_WAITING
        t1.interrupt();
        t1.join();
        System.out.println("3: " + t1.getState()); // TERMINATED
        System.out.println("主线程结束");
    }
}
