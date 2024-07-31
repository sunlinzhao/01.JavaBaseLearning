package com.slz.javalearing.day14;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/17
 */
public class Test {
    public static void main(String[] args) {
        // 1. 无参（小括号不能省略），无返回值，只有一行语句（大括号可以省略）
        MyInter myInter = ()-> System.out.println("test");
        // 2. 无参（小括号不能省略），无返回值，有多行语句（大括号不能省略）
        MyInter1 myInter1 = ()->{
            System.out.println("test1");
            System.out.println("test2");
        };
        // 3. 有一个参数（小括号可以省略），无返回值，只有一行语句（大括号可以省略）
        MyInter2<Integer> myInter2 = i -> System.out.println("test" + i);
        // 4. 有一个参数（小括号可以省略），有返回值，只有一行语句（大括号可以省略）, 省略大括号的同时，return 语句也要省略掉
        MyInter3 myInter3 = x -> Math.abs(x);
        // 5. 有多个参数（小括号不可以省略），有返回值，有多行语句（大括号不能省略）
        MyInter4 myInter4 = (x, y) -> {
            int sum = 0;
            sum = (int) Math.pow(x, y);
            return sum;
        };
//        MyInter4 myInter5 = (x, y) -> (int) Math.pow(x, y);
    }
}
interface MyInter {
    void test(); // 无参，无返回值
}
interface MyInter1{
    void test(); // 无参，无返回值
}
interface MyInter2<T>{
    void test(T t); // 有一个参数，无返回值
}
interface MyInter3{
    Integer abs(Integer x); // 有一个参数，有返回值
}
interface MyInter4{
    int pow(int x, int y); // 有两个参数，有返回值
}