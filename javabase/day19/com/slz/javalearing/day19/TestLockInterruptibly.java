package com.slz.javalearing.day19;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/2
 */
public class TestLockInterruptibly {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread t1 = new Thread(()->{
            try {
                System.out.println("t1 尝试获取锁");
                reentrantLock.lockInterruptibly(); // 可中断锁
                System.out.println("t1 获取到锁");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("t1 被中断");
                throw new RuntimeException(e);
            }finally {
                reentrantLock.unlock();
                System.out.println("t1 释放锁");
            }
        });
        Thread t2 = new Thread(()->{
            try{
                System.out.println("t2 尝试获取锁");
                reentrantLock.lockInterruptibly();
                System.out.println("t2 获取到锁");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                reentrantLock.unlock();
                System.out.println("t2 释放锁");
            }
        });
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        if (t2.isAlive()){ // 由于t1一直持有锁，导致t1被阻塞，所以t2需要被打断
            t2.interrupt(); // 打断t2
        } else {
            System.out.println("t2 执行完成");
        }
        t1.join();
        t2.join();
        System.out.println(reentrantLock.isLocked()); // 查看锁是否被释放
    }
}
