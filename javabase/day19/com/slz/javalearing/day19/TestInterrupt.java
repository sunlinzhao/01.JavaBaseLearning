package com.slz.javalearing.day19;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/2
 */
public class TestInterrupt {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            lock.lock();
        }).start();
        Thread.sleep(1000);
        Thread thread = new Thread(() -> {
            lock.lock();
//            try {
//                lock.lockInterruptibly();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });
        thread.start();
        thread.interrupt();
    }
}
