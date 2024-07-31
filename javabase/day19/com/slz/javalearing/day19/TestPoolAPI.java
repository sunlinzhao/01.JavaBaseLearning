package com.slz.javalearing.day19;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/4
 */
public class TestPoolAPI {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> taskList = Arrays.asList(() -> {
            System.out.println("任务1执行...");
            Thread.sleep(1000);
            System.out.println("任务1执行完毕");
            return 1;
        }, () -> {
            System.out.println("任务2执行...");
            Thread.sleep(2000);
            System.out.println("任务2执行完毕");
            return 2;
        }, () -> {
            System.out.println("任务3执行...");
            Thread.sleep(500);
            System.out.println("任务3执行完毕");
            return 3;
        });
//        testSubmit(executorService);
//        testInvokeAll(executorService, taskList);
        testInvokeAny(executorService, taskList);
        Thread.sleep(5000);
        executorService.shutdown();
    }
    public static void testInvokeAny(ExecutorService executorService, List<Callable<Integer>> taskList) throws ExecutionException, InterruptedException {
        Integer integer = executorService.invokeAny(taskList); // 其中任意一个返回结果后, 其它线程结束执行
        System.out.println(integer);
    }
    public static void testInvokeAll(ExecutorService executorService, List<Callable<Integer>> taskList) throws InterruptedException {
        List<Future<Integer>> futures = executorService.invokeAll(taskList); // 等待所有任务执行完一起返回
        futures.forEach((x)->{
            try {
                System.out.println(x.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public static void testSubmit(ExecutorService executorService) throws ExecutionException, InterruptedException {
        Future<Integer> submit = executorService.submit(() -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            return sum;
        });
        System.out.println(submit.get());
    }
}
