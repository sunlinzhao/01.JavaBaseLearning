package com.slz.javalearing.day20;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/5
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        // 等待连接
        System.out.println("服务端等待连接...");
        Socket client = serverSocket.accept();
        InetAddress inetAddress = client.getInetAddress();
        System.out.println("来自 [" + inetAddress.getHostName() + ":" + client.getLocalPort() + "] 请求已连接!");
        // 获取输入流
        InputStream clientInputStream = client.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(clientInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // 获取输出流
        OutputStream clientoutputStream = client.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(clientoutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        // 从键盘读取
        Scanner scanner = new Scanner(System.in);
        while (true){
            String s = bufferedReader.readLine(); // BufferedReader 的 readLine 读到换行符才会结束,否则一直阻塞
            System.out.println("[客户端]: " + s);
            if ("bye".equals(s)){
                break;
            }
            System.out.print("> ");
            String s1 = scanner.nextLine();
            bufferedWriter.write(s1 + "\n"); // BufferedReader 的 readLine 读到换行符才会结束,否则一直阻塞
            bufferedWriter.flush(); // 立即刷入
        }

        // 关闭连接
        scanner.close();
        bufferedReader.close();
        bufferedWriter.close();
        client.close();
        serverSocket.close();
    }
}
