package com.slz.javalearing.day17;

import java.util.concurrent.TimeUnit;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/29
 */
public class TestJoin {
    private static Integer x = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x = 100;
        });
        t1.start();
//        t1.join();
        t1.join(2000);
        System.out.println(x);
    }
}
