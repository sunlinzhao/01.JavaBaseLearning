package com.slz.javalearing.day16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/26
 */
public class TestWriter {
    public static void main(String[] args) throws IOException {
        // 字符数组 / 字符串 写入
//        FileWriter fileWriter = new FileWriter(".\\javabase\\resource\\hello.txt");
//        char[] chars = {'中', '国', '人'};
//        String str = "我是中国人";
//        fileWriter.write(chars);
//        fileWriter.write(chars, 0, 2);
//        fileWriter.write(str, 0, 2);
//        fileWriter.write(str);
//        fileWriter.close();

        // 构造方法一
//        FileWriter fileWriter1 = new FileWriter(".\\javabase\\resource\\hello.txt");
        // 构造方法二 第二个参数true，表示追加写入
        FileWriter fileWriter2 = new FileWriter(".\\javabase\\resource\\hello.txt", true);
        fileWriter2.write("中国人不骗中国人");
        fileWriter2.close();
        // 构造方法三 转入File对象
        File file = new File(".\\javabase\\resource\\hello.txt");
//        FileWriter fileWriter3 = new FileWriter(file);
        // 构造方法四
        FileWriter fileWriter4 = new FileWriter(file, true);
        fileWriter4.write("我是中国人");
        fileWriter4.close();
        // 构造方法五 指定编码方式
        FileWriter fileWriter5 = new FileWriter(file, StandardCharsets.UTF_8);
    }
}
