package com.slz.javalearing.day17;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/29
 */
public class TestYield {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            int i=0;
            while (true){
                Thread.yield();
                System.out.println("\t\t" + Thread.currentThread().getName() + ":" + i++);
            }
        }, "线程1");
        Thread t2 = new Thread(()->{
            int i=0;
            while (true){
                System.out.println(Thread.currentThread().getName() + ":" + i++);
            }
        }, "线程2");
        t1.start();
        t2.start();
    }
}
