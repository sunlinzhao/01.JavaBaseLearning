package com.slz.javalearing.day17;

import java.util.concurrent.TimeUnit;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/29
 */
public class TestInterruput {
    public static void main(String[] args) throws InterruptedException {
        // sleep wait join 被打断，打断标记会被清除
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": 休眠被打断");
                System.out.println(Thread.currentThread().isInterrupted()); // 获取打断标记
                throw new RuntimeException(e);
            }
        }, "t1");
        t1.start();
        t1.interrupt();
        // 打断正常运行的线程，打断标记不会被清除
        Thread t2 = new Thread(()->{
            while (true){
                if(Thread.currentThread().isInterrupted()){ // 判断打断标记
                    System.out.println(Thread.currentThread().getName() + ": 正常运行被打断");
                    System.out.println(Thread.currentThread().isInterrupted());
                    break;
                }
            }
        }, "t2");
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t2.interrupt();
    }
}
