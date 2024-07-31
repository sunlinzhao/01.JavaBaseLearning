package com.slz.javalearing.day18;

import java.util.concurrent.TimeUnit;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/30
 */
public class TestSleepWait {
    private static final Object obj_lock = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            try {
                synchronized (obj_lock){
                    System.out.println("线程1 休眠...");
//                    Thread.sleep(20000); // sleep 不会释放对象锁
                    obj_lock.wait(2000); // wait 会释放对象锁
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程1 结束执行");
        });
        Thread t2 = new Thread(()->{
            synchronized (obj_lock){
                System.out.println("线程2 获取到锁并执行");
            }
        });
        t1.start();
        t2.start();
    }
}
