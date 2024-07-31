package com.slz.javalearing.day17;

import java.util.concurrent.*;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/27
 */
public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                int sum = 0, i=1;
//                while (i<=100){
//                    sum+=i;
//                    i++;
//                }
//                return sum;
//            }
//        });
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            int sum = 0, i=1;
            while (i<=100){
                sum+=i;
                i++;
            }
            Thread.sleep(3000);
            return sum;
        });
        new Thread(futureTask).start();
//        Thread.sleep(2000);
//        futureTask.cancel(true);
        System.out.println(futureTask.isCancelled());
        System.out.println(futureTask.isDone());
        System.out.println(futureTask.get(20000, TimeUnit.MILLISECONDS));
    }
}
