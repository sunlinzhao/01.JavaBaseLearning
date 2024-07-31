package com.slz.javalearing.day20;

import java.io.*;
import java.net.*;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/29
 */
public class TestURL {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL url = new URL("https://img1.baidu.com/it/u=3766269883,2205628513&fm=253&fmt=auto&app=120&f=JPEG?w=606&h=342");
        int port = url.getPort();
        String file = url.getFile();
        String host = url.getHost();
        URI uri = url.toURI();

        System.out.println(port);
        System.out.println(file);
        System.out.println(host);
        System.out.println(uri);

        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\MyProject\\Java\\JavaLearning\\javabase\\resource\\test\\download.jpg");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] bytes = new byte[1024];
        int x;
        while ((x=bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes, 0, x);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
