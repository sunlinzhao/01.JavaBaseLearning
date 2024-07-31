package com.slz.javalearing.day19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/3
 */
public class TestNewFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3); // 线程池最大只有三个线程执行，其它线程存放在无界的阻塞队列里等待执行
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Thread(()->{
                System.out.println(Thread.currentThread().getName() + ": 执行任务");
            }));
        }
        executorService.shutdown();
    }
}
