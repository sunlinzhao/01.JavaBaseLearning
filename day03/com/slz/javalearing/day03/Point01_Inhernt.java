package com.slz.javalearing.day03;

import java.util.Random;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/30
 */
public class Point01_Inhernt {
    public static void main(String[] args) {
        Aodi aodi = new Aodi(); //
        C c1 = new C(1);
        System.out.println(c1.i);
        System.out.println(c1.j);

        C c2 = new C(1);
        System.out.println(c2.i);
        System.out.println(c2.j);
    }

}

class C {
    public final int i = 0; // 编译期常量
    public final int j = new Random().nextInt(10); // 非编译期常量
    public final int x;
//    {
//        x = 100;
//    }

    public C(int x) {
        this.x = x;
    }

//    public final static int y = 10;
    public final static int y;

    static {
        y = 10;
    }

}

class A{
    public void fun1(){
    }

    public final void fun2(){}
    public void fun2(int x){} // final方法可以被重载，但不能被子类重写

}
class B extends A {
    @Override
    public void fun1() {
        super.fun1();
    }
    @Override
    public void fun2(int x){ // 如果重载的方法是非final的，则可以被子类重写
    }
}