package com.slz.javalearing.day16;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/26
 */
public class TestBufferedReader {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(".\\javabase\\resource\\hello.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        while ((s = bufferedReader.readLine())!=null) // 每次读取一行，返回一个字符串
            System.out.println(s);
        bufferedReader.close();
    }
}
