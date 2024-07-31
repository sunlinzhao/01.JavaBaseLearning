package com.slz.javalearing.day20;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/29
 */
public class uploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\MyProject\\Java\\JavaLearning\\javabase\\resource\\test\\hello.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] b = new byte[1024];
        int x;
        while ((x = bufferedInputStream.read(b)) != -1) {
            bufferedOutputStream.write(b, 0, x);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
        System.out.println("接收成功！");
        accept.close();
        serverSocket.close();
    }
}
