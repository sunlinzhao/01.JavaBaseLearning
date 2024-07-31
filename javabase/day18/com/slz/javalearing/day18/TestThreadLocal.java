package com.slz.javalearing.day18;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/1
 */
public class TestThreadLocal {
    public static void main(String[] args) throws InterruptedException {
        DataA dataA = new DataA();
        testNoTheadLocal(dataA);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("------------");
        DataB dataB = new DataB();
        testUseThreadLocal(dataB);
    }

    public static void testNoTheadLocal(DataA dataA){
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    dataA.setVal(Thread.currentThread().getName());
                    TimeUnit.MILLISECONDS.sleep(50);
                    System.out.println(Thread.currentThread().getName() + ":" + dataA.getVal());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
    public static void testUseThreadLocal(DataB dataB){
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    dataB.setVal(Thread.currentThread().getName());
                    TimeUnit.MILLISECONDS.sleep(50);
                    System.out.println(Thread.currentThread().getName() + ":" + dataB.getVal());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }).start();
        }
    }
}

class DataA{
    private String val;
    public String getVal() {
        return val;
    }
    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "DataA{" +
                "val='" + val + '\'' +
                '}';
    }
}

class DataB{
    private ThreadLocal<String> val = new ThreadLocal<>();
    public String getVal() {
        return this.val.get();
    }
    public void setVal(String val) {
        this.val.set(val);
    }
}
