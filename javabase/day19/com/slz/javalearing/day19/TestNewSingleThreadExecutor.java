package com.slz.javalearing.day19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/3
 */
public class TestNewSingleThreadExecutor {
    public static Integer x = 0;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor(); // 单线程化线程池，最多只有一个线程工作，其它任务放在阻塞队列中，适用于任务按照提交次序一个一个的逐个执行
        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + ": 执行了任务" + x++);
            });
        }
        executorService.shutdown();
    }
}
