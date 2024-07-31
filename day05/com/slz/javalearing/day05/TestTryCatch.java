package com.slz.javalearing.day05;

import java.util.Scanner;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/3
 */
public class TestTryCatch {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            test();
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println(e.getMessage()); // 获取异常信息；
            System.out.println(e.toString()); // 获取异常类和信息；
            e.printStackTrace(); // 打印异常堆栈轨迹；
        } catch (Exception e){
            System.out.println("发生错误: " + e.toString());
        } finally {
            in.close();
            System.out.println("释放资源");
        }
    }
    public static void test(){
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(x/y);
        int[] m = new int[10];
        m[10] = 100;
    }
}
