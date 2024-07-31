package com.slz.javalearing.day19;

import java.util.concurrent.SynchronousQueue;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/3
 */
public class TestSynchronousQueue {
    public static void main(String[] args) {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
            new Thread(()-> {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("生产了: " + i);
                        synchronousQueue.put(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("消费了: " + synchronousQueue.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
