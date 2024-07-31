package com.slz.javalearing.day16;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/26
 */
public class TestBufferWriter {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter(".\\javabase\\resource\\hello.txt", true);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, 8000); // 第二个参数指定缓冲区大小
        bufferedWriter.write("我爱中国");
//        bufferedWriter.write("\r\n");
        bufferedWriter.newLine();
        bufferedWriter.write("我爱中国");
        bufferedWriter.close();
    }
}
