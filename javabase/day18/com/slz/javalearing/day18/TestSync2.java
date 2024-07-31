package com.slz.javalearing.day18;

import com.slz.javalearing.day09.Test;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/30
 */
public class TestSync2 {
    public static void main(String[] args) throws InterruptedException {
        NumObj numObj = new NumObj();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                numObj.increment();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                numObj.decrement();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(numObj.getNum());
    }
}
class NumObj{
    private int x;
    public void increment(){ // 自增
        synchronized (this){
            this.x++;
        }
    }
    public synchronized void decrement(){ // 自减
        this.x--;
    }
    public synchronized int getNum(){ // 获取值
        return this.x;
    }

    public synchronized static void test(){
    }
    // 相当于
    public static void test1(){
        synchronized (NumObj.class){ // 在static 方法中，不能使用this
        }
    }
}