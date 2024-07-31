package com.slz.javalearing.day17;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/29
 */
public class TestThreadAPI {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{});
        t1.start(); // start() 只能调用一次
//        t1.start(); // start() 只能调用一次
        // 线程优先级
        Thread t2 = new Thread(()->{
            int i=0;
            while(true){
                System.out.println(Thread.currentThread().getName() + ":" + i++);
            }
        }, "线程1");
        Thread t3 = new Thread(()->{
            int i=0;
            while(true){
                System.out.println("\t\t" + Thread.currentThread().getName() + ":" + i++);
            }
        }, "线程2");
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());
        t2.start();
        t3.start();
    }
}
