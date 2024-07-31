package com.slz.javalearing.day19;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/3
 */
public class TestThreadPoolExecutor {
    public static void main(String[] args) {
        ThreadFactoryImpl threadFactory = new ThreadFactoryImpl();
        // 核心线程数2个，最多3个，有1个救急线程
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 60,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(2), threadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());
        threadFactory.setThreadName("线程1");
        executor.execute(()->{System.out.println("task 1: " + Thread.currentThread().getName());});
        threadFactory.setThreadName("线程2");
        executor.execute(()->{System.out.println("task 2: " + Thread.currentThread().getName());});
        threadFactory.setThreadName("线程3");
        executor.execute(()->{System.out.println("task 3: " + Thread.currentThread().getName());});
        threadFactory.setThreadName("线程4");
        executor.execute(()->{System.out.println("task 4: " + Thread.currentThread().getName());});
        threadFactory.setThreadName("线程5");
        executor.execute(()->{System.out.println("task 5: " + Thread.currentThread().getName());});
        threadFactory.setThreadName("线程6");
        executor.execute(()->{System.out.println("task 6: " + Thread.currentThread().getName());});

        executor.shutdown();
    }
}

class ThreadFactoryImpl implements ThreadFactory{
    private String threadName;

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, threadName);
    }
}
