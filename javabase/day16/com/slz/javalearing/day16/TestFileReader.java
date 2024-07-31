package com.slz.javalearing.day16;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/26
 */
public class TestFileReader {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(".\\javabase\\resource\\hello.txt");
        // 文件读取 1
//        int read;
//        while ((read = fileReader.read()) != -1) {  // 每次读取一个字符，返回读取到的字符，返回int类型，如果达到流的结尾，就返回-1
//            System.out.print((char) read);
//        }
        // 文件读取 2
//        char[] chars = new char[1024];
//        int len = fileReader.read(chars);// 将字符存入数组中，并返回一共读取到多少个字得
//        System.out.println("一共读取到" + len + "个字符");
//        System.out.println(new String(chars, 0, len));
        // 文件读取 3
        char[] chars = new char[1024];
        fileReader.skip(4); // 跳过前4个数据
        int len = fileReader.read(chars, 0, 20);
        System.out.println("一共读取到" + len + "个字符");
        System.out.println(new String(chars, 0, len));
    }
}
