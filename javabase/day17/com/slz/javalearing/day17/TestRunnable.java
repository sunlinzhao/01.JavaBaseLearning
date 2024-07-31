package com.slz.javalearing.day17;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/27
 */
public class TestRunnable {
    public static void main(String[] args) {
        System.out.println("主线程开始");
        MyRunnableImpl myRunnable = new MyRunnableImpl();
//        myRunnable.run(); // 直接调用 run() 方法不会开辟子线程
        Thread thread = new Thread(myRunnable);
        thread.start(); // Runnable 实现类，需要借助 Thread 另外开启子线程
        Thread thread1 = new Thread(()->{
            System.out.println("子线程" + Thread.currentThread().getName() +"执行");
        });
        thread1.start();
        new Thread(()->System.out.println("子线程" + Thread.currentThread().getName() +"执行"), "hello").start(); // 第二个参数是线程的名字
        System.out.println("主线程结束");
    }
}
class MyRunnableImpl implements Runnable{

    @Override
    public void run() {
        System.out.println("子线程" + Thread.currentThread().getName() +"执行");
    }
}