package com.slz.javalearing.day16;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/23
 */
public class TestFileWriter {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter(".\\javabase\\resource\\hello.txt");
        fileWriter.write("我是大傻逼");
        fileWriter.flush(); // 刷入磁盘
        fileWriter.write("我是大傻逼");
        for (int i = 0; i < 10000; i++) {
            fileWriter.write(i + "\t");
            if (i%100==0) fileWriter.write("\n");
        }
        fileWriter.close(); // 只有【关闭了/刷入磁盘/缓冲区满了】才算真正写入文件
        // 使用try catch 自动关闭资源
        try(FileWriter fileWriter1 = new FileWriter(".\\javabase\\resource\\hello1.txt")){
            for (int i = 0; i < 10000; i++) {
                fileWriter1.write(i + "\t");
                if (i%100==0) fileWriter1.write("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
