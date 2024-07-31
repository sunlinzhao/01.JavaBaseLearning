package com.slz.javalearing.day19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/3
 */
public class TestNewCachedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(); // 可缓存线程池，没有最大线程数限制，没有核心线程，都是应急线程。60秒空闲后被销毁
        for (int i = 0; i < 50; i++) {
//            TimeUnit.SECONDS.sleep(1);
            int finalI = i;
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + ": 执行任务 " + finalI);
            });
        }
        executorService.shutdown();
    }
}
