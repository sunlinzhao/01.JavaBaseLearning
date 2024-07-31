package com.slz.javalearing.day18;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/30
 */
public class TestDeadLock {
    private static final Object obj1 = new Object();
    private static final Object obj2 = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (obj1){
                System.out.println(Thread.currentThread().getName() + "获取到条件1");
                synchronized (obj2){
                    System.out.println(Thread.currentThread().getName() + "获取到条件2");
                }
            }
            System.out.println(Thread.currentThread().getName() + "满足所有条件, 可以执行");
        }, "线程1").start();
        new Thread(()->{
            synchronized (obj2){
                System.out.println(Thread.currentThread().getName() + "获取到条件2");
                synchronized (obj1){
                    System.out.println(Thread.currentThread().getName() + "获取到条件1");
                }
            }
            System.out.println(Thread.currentThread().getName() + "满足所有条件, 可以执行");
        }, "线程2").start();
    }
}
