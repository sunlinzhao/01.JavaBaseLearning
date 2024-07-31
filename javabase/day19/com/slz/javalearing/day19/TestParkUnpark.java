package com.slz.javalearing.day19;

import java.util.concurrent.locks.LockSupport;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/4
 */
public class TestParkUnpark {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            LockSupport.park(); // 线程阻塞, 处于休眠状态, 直到许可证可用, 或者被中断
            System.out.println("t1 执行");
        });
        t1.start();
        Thread.sleep(1000);
        new Thread(()->{
            System.out.println("t2 执行");
            LockSupport.unpark(t1); // 唤醒特定线程, 解除该线程阻塞,如果该线程没有启动则无效
        }).start();
    }
}
