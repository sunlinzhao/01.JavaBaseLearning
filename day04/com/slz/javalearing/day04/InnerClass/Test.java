package com.slz.javalearing.day04.InnerClass;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/2
 */
public class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner(); // 通过外部类对象创建内部类对象

        Outer.StaticInner staticInner = new Outer.StaticInner();
        System.out.println(staticInner.k);
        System.out.println(Outer.StaticInner.y);

        MyOuter myOuter = new MyOuter();
        myOuter.fun();
    }
}

class MyOuter {
    public void fun(){
        int m = 0;
        class MyInner{
            void fun1(){
                System.out.println(m);
            }
        }
        MyInner myInner = new MyInner();
        myInner.fun1();
    }
}
