package com.slz.javalearing.day19;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/2
 */
public class TestReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread t1 = new Thread(()->{
            int index = 1;
            try {
                reentrantLock.lock();
                System.out.println("---- 最开始加锁");
                while (true){
                    try {
                        reentrantLock.lock();
                        System.out.println("#### 第" + (++index) + "次加锁");
                        if (index==10){
                            break;
                        }
                    } finally {
                        reentrantLock.unlock();
                        System.out.println(">>>> 第" + (index) + "次解锁");
                    }
                }
            } finally {
//                reentrantLock.unlock();
                System.out.println("---- 最后解锁");
            }
        });
        t1.start();
        t1.join();
        System.out.println(reentrantLock.isLocked());
    }
}
