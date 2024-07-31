package com.slz.javalearing.day20;

import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/5
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6666);
        // 获取输出流
        OutputStream socketOutputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socketOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        // 获取输入流
        InputStream socketInputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(socketInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // 从键盘读取
        Scanner scanner = new Scanner(System.in);
        System.out.println("已连接到服务器，开始聊天。输入'bye'退出。");
        while (true) {
            System.out.print("> ");
            String s = scanner.nextLine();
            bufferedWriter.write(s + "\n"); // BufferedReader 的 readLine 读到换行符才会结束,否则一直阻塞
            bufferedWriter.flush();
            if ("bye".equals(s)) {
                break;
            }
            String s1 = bufferedReader.readLine(); // BufferedReader 的 readLine 读到换行符才会结束,否则一直阻塞
            System.out.println("[服务器]: " + s1);
        }

        // 关闭连接
        scanner.close();
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
