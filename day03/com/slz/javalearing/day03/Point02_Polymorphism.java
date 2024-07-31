package com.slz.javalearing.day03;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/30
 */
public class Point02_Polymorphism {
    public static void main(String[] args) {
        F f = new S(); // 向上转型
        f.show();
        S s = (S) f; // 向下转型
        s.show1();
//        S s1 = (S) new F(); // 只能强制转换父类的引用，不能强制转换父类的对象(如果强制转换父类对象，编译可以通过，运行时报错)
        if(s instanceof S) {
            System.out.println("这是S类的()或其父类的对象");
        }
        if(new S() instanceof F) {
            System.out.println("这是S类的()或其父类的对象");
        }
    }
}

class F {
    public void show(){
        System.out.println("这是父类方法show");
    }
    public static void fun(){
        System.out.println("这是父类静态方法");
    }
}

class S extends F{
    public void show(){
        System.out.println("这是子类方法show");
    }
    public void show1(){
        System.out.println("这是子类方法show1");
    }

    // static 方法不能被重写，另外构造方法，private方法、final方法也不能被重写
//    public static void fun(){
//        System.out.println("这是子类静态方法");
//    }
}

