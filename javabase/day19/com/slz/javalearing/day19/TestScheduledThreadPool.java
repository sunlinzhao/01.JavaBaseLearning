package com.slz.javalearing.day19;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/4
 */
public class TestScheduledThreadPool {
    public static void main(String[] args) throws InterruptedException {
//        serialSchedule(); // Timer 实现串行化定时任务
        concurrencySchedule(); // ScheduledExecutorService 并发执行定时任务
    }

    public static void serialSchedule() throws InterruptedException { // 串行化定时任务
        Timer timer = new Timer(); // 串行化定时任务
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("任务1执行");
                int x = 5 / 0; // 串行执行，一旦前面的任务异常停止掉，后面的任务就无法执行了
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("任务2执行");
            }
        };
        timer.schedule(task1,1000); // 延后1秒执行
        timer.schedule(task2,1000); // 延后1秒执行
        TimeUnit.SECONDS.sleep(2);
        timer.cancel();
    }
    public static void concurrencySchedule(){ // 并发定时任务
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        // 延迟执行
        scheduledExecutorService.schedule(()->{
            System.out.println("任务一执行...");
        }, 1, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(()->{
            System.out.println("任务二执行...");
        }, 1, TimeUnit.SECONDS);
        // 反复执行
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("任务三执行...");
        }, 1, 2, TimeUnit.SECONDS); // 初始延迟一秒，每两秒执行一次
//        scheduledExecutorService.shutdown();
    }
}
