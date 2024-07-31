package com.slz.javalearing.day20;

import java.io.*;
import java.net.Socket;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/29
 */
public class uploadClient  {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 6666);
        FileInputStream fileInputStream = new FileInputStream("D:\\MyProject\\Java\\JavaLearning\\javabase\\resource\\hello.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        OutputStream outputStream = client.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] b = new byte[1024];
        int x;
        while ((x=bufferedInputStream.read(b))!=-1){
            bufferedOutputStream.write(b, 0, x);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
        System.out.println("上传成功！");
        client.close();
    }
}
