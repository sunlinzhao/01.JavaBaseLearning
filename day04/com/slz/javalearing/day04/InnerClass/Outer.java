package com.slz.javalearing.day04.InnerClass;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/2
 */
public class Outer {
    private int x = 100;
    private static int z = 10;

    class Inner { // 成员内部类
        public int x = 10;

        public void showX() {
            System.out.println("成员内部类调用外部类同名属性：" + Outer.this.x); // 成员内部类调用外部类同名属性
            System.out.println("成员内部类调用自身同名属性：" + x);
        }
    }

    static class StaticInner { // 静态内部类
        static public int y = 10;
        int k = 10;

        static void fun() {
        }
    }

    public void fun() {
        int m = 0;
        class InnerLocal { // 局部内部类
            void fun() {
                System.out.println(m);
            }
        }
        InnerLocal innerLocal = new InnerLocal();
        innerLocal.fun();
    }

    public static void main(String[] args) {
        Compute compute = new Compute() { // 匿名内部类 : 直接 new 一个接口并实现方法，没有名字
            @Override
            public void add(int x, int y) {
                System.out.println(x + y);
            }
        };
        compute.add(2, 3);

        Compute1 compute1 = new Compute1(){ // 匿名内部类 : 直接 new 一个父类并实现方法，没有名字
            @Override
            void add1(int x, int y) {
                System.out.println(x+y);
            }
        };
        compute1.add1(3, 3);
    }
}

interface Compute {
    void add(int x, int y);
}
abstract class Compute1 {
    abstract void add1(int x, int y);
}