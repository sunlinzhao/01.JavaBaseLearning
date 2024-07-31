package com.slz.javalearing.day17;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/29
 */
public class TestDaemon {
    public static void main(String[] args) {
        // 创建一个守护线程
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("守护线程正在运行...");
                        // 让线程睡眠1秒，模拟执行任务
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // 保持中断状态
                        System.out.println("守护线程被中断");
                        return; // 结束线程
                    }
                }
            }
        }, "DaemonThread");

        // 设置为守护线程
        daemonThread.setDaemon(true);

        // 启动守护线程
        daemonThread.start();

        // 主线程任务
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("主线程正在运行...");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        System.out.println("主线程结束，守护线程也将随之结束。");
    }
}
