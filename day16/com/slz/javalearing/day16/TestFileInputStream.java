package com.slz.javalearing.day16;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/27
 */
public class TestFileInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(".\\javabase\\resource\\hello.txt");
        // 字节流转换为字符流
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int read;
        while ((read = inputStreamReader.read()) != -1) {
            System.out.print((char) read); // 中文会出现乱码，需要将字节流转化为字符流
        }
        fileInputStream.close();
        // 读取二进制文件
        File src = new File(".\\javabase\\resource\\image0.png");
        File dest = new File(".\\javabase\\resource\\test\\image0_1.png");
        copyByteFile(src, dest);
    }

    public static void copyByteFile(File src, File dest) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(src);
        FileOutputStream fileOutputStream = new FileOutputStream(dest);
        // 反复对文件进行读取，用 Buffered 更合理一些，效率更高
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int flag;
        while ((flag = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(flag);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
