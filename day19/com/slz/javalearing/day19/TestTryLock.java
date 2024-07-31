package com.slz.javalearing.day19;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/2
 */
public class TestTryLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread t1 = new Thread(()->{
           try{
               System.out.println("t1 尝试获取锁...");
               // 尝试获取锁。获取锁失败返回false，获取锁成功返回true，立即返回
               boolean b = reentrantLock.tryLock();
               if(!b){
                   System.out.println("t1 获取锁失败!");
                   return;
               }
               System.out.println("t1 获取到锁，开始执行...");
               TimeUnit.SECONDS.sleep(6);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           } finally {
               reentrantLock.unlock();
               System.out.println("t1 释放锁");
           }
        });
        Thread t2 = new Thread(()->{
            try {
                System.out.println("t2 尝试获取锁...");
                // 尝试获取锁。最长等待3秒，获取锁失败返回false，获取锁成功返回true，3秒内返回
                boolean b = reentrantLock.tryLock(3, TimeUnit.SECONDS);
                if(!b){
                    System.out.println("t2 获取锁失败!");
                    return;
                }
                System.out.println("t2 获取到锁，开始执行...");

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
        t1.join();
        t2.join();
        System.out.println(reentrantLock.isLocked());
    }
}
