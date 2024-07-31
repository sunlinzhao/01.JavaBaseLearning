package com.slz.javalearing.day16;

import java.io.*;
import java.util.Scanner;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/27
 */
public class TestSystemInOut {
    public static void main(String[] args) throws IOException {
        // 从键盘接收参数
        // 方法一
        Scanner scanner = new Scanner(System.in);
        // 方法二
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine(); // 读取一行字符串
        System.out.println(s);
        bufferedReader.close();
        // 标准输出
        PrintStream printStream = System.out;
        printStream.print("hello");
        // 标准错误输出
        System.err.print("错误"); // 红色字体
        // 标准输入输出的扭转操作
        FileInputStream fileInputStream = new FileInputStream(".\\javabase\\resource\\hello.txt");
        System.setIn(fileInputStream); // 重新分配”标准“输入流，将键盘接受输入扭转到文件
        FileOutputStream fileOutputStream = new FileOutputStream(".\\javabase\\resource\\hello2.txt");
        System.setOut(new PrintStream(fileOutputStream)); // 重新分配”标准“输出流，，将输出到显示器扭转到文件
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
        String s1;
        while ((s1=bufferedReader1.readLine())!=null){
            System.out.println(s1);
        }
        bufferedReader1.close();
    }
}
