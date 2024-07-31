package com.slz.javalearing.day19;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/3
 */
public class TestCondition {
    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static Condition condition1 = reentrantLock.newCondition(); // 条件一等待集合
    public static Condition condition2 = reentrantLock.newCondition(); // 条件二等待集合
    public static Condition condition3 = reentrantLock.newCondition(); // 条件二等待集合
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try{
                System.out.println("t1 尝试获取锁...");
                reentrantLock.lock();
                System.out.println("t1 获取到锁");
                condition1.await(); // 等待条件一满足
                System.out.println("t1 条件1满足");
                condition2.await(); // 等待条件二满足
                System.out.println("t1 条件2满足");
                condition3.await(); // 等待条件三满足
                System.out.println("t1 条件3满足");
                System.out.println("t1 执行完成");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                reentrantLock.unlock();
                System.out.println("t1 释放锁");
            }
        });
        Thread t2 = new Thread(()->{
            try{
                System.out.println("t2 尝试获取锁...");
                reentrantLock.lock();
                condition2.await();
                System.out.println("t2 获取到锁");
                System.out.println("t2 执行完成");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                reentrantLock.unlock();
                System.out.println("t2 释放锁");
            }
        });

        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            try{
                reentrantLock.lock(); // 获取到锁才能执行
                condition1.signal(); // 唤醒条件1中的等待线程
            } finally {
                reentrantLock.unlock();
            }
        }).start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            try{
                reentrantLock.lock(); // 获取到锁才能执行
                condition2.signalAll(); // 唤醒条件2中的所有等待线程
            } finally {
                reentrantLock.unlock();
            }
        }).start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            try{
                reentrantLock.lock(); // 获取到锁才能执行
                condition3.signal(); // 唤醒条件3中的等待线程
            } finally {
                reentrantLock.unlock();
            }
        }).start();
    }
}
