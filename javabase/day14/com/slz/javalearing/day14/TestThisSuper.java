package com.slz.javalearing.day14;

import java.util.function.Consumer;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/19
 */
public class TestThisSuper {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.test2(123);
    }
    public void test(Integer x){
        System.out.println("消费了:" + x);
    }
    public void test1(Integer x){
        Consumer<Integer> consumer = this::test; // this 引用自身类的实例方法
        consumer.accept(x);
    }
}
class MyClass extends TestThisSuper{
    public void test2(Integer x){
        Consumer<Integer> consumer = super::test; // super 引用父类的实例方法
        consumer.accept(x);
    }
}