package com.slz.javalearing.day05;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/3
 */
public class TestCheckException {
    public static void main(String[] args) {
        try {
            test1(); // 在这里处理方法向上抛出的异常
        } catch (InterruptedException e){
            System.out.println("捕获到异常:" + e.getMessage());
        }
    }

    public static void test1() throws InterruptedException{
        test(); // test的中有未处理的异常，这里不想处理的话，可以继续向上抛出
    }
    public static void test() throws InterruptedException{ // 向上抛出异常
        Thread.sleep(1000); // 检查型异常，可能会出现异常，这里不作处理时，可以向上抛出，谁来调用，谁来处理异常
    }
}
