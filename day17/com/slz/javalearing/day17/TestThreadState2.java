package com.slz.javalearing.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/28
 */
public class TestThreadState2 {
    /*从Java 8开始，即便没有明确声明为final，只要在lambda表达式外部定义的变量在其赋值后不再有其他赋值操作，
    那么这个变量也被视为“有效地final”，可以在lambda表达式中使用。这意味着编译器会检查变量是否在赋值后不再改变，
    如果是，则允许在lambda中使用。*/
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始");
        String lockedObject = "Give Me";
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(()->{
            try {
                t1.join(); // t2 线程等待 t1 线程结束，属于无限时等待状态
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(()->{
            synchronized (lockedObject){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t4 = new Thread(()->{
            synchronized (lockedObject){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("t3: " + t3.getState()); // 获取到锁时，处于 RUNNABLE 状态，否则属于 BLOCKED 阻塞态
        System.out.println("t4: " + t4.getState()); // 获取到锁时，处于 RUNNABLE 状态，否则属于 BLOCKED 阻塞态
        Thread.sleep(1000);
        System.out.println("t1: " + t1.getState()); // 子线程睡眠，处于 TIMED_WAITING 状态，限时等待状态
        System.out.println("t2: " + t2.getState()); // t2 线程等待 t1 线程结束，属于无限时等待状态 WAITING
        System.out.println("主线程结束");
    }
}
