package com.slz.javalearing.day17;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/27
 */
public class TestThread {
    public static void main(String[] args) {
        System.out.println("主线程开始执行");
        MyThread myThread01 = new MyThread();
        Thread myThread02 = new Thread(()->{ // 也可以用 匿名内部类 / lambda 表达式的创建线程
            System.out.println("子线程" + Thread.currentThread().getName() +"执行");
        });
        MyThread myThread03 = new MyThread();
        myThread01.setName("01");
        myThread02.setName("02");
        myThread03.setName("03");
        myThread01.start(); // 开启一个子线程，自动调用run方法
        myThread02.start();
        myThread03.start();
        System.out.println("主线程执行结束");

        new Thread(()->{
            System.out.println("lambda 创建的线程");
        }).start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("子线程" + Thread.currentThread().getName() +"执行");
    }
}