package com.slz.javalearing.day19;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/2
 */
public class TestFairAndUnfair {
    static class Data{
        int i= 0;
        ReentrantLock reentrantLock;

        public Data(ReentrantLock reentrantLock) {
            this.reentrantLock = reentrantLock;
        }
        void test(){
            while (i<=1000){
                try {
                    reentrantLock.lock();
                    i++;
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }
    public static void main(String[] args) {
        ReentrantLock fairLock = new ReentrantLock(true); // 公平
        ReentrantLock unfairLock = new ReentrantLock(); // 非公平
        Data data = new Data(unfairLock);

        Thread t1 = new Thread(()->{
            data.test();
        }, "t1");
        Thread t2 = new Thread(()->{
            data.test();
        }, "t2");

        t1.start();
        t2.start();
    }
}