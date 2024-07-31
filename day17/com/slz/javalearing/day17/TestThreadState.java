package com.slz.javalearing.day17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/28
 */
public class TestThreadState {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始");
        Thread t1 = new Thread(()->{
            try {
                FileReader fileReader = new FileReader("javabase/resource/data.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String s;
                Integer flag = 0;
                while ((s=bufferedReader.readLine())!=null){
                    if(flag.equals(66)) {
                        System.out.println(Thread.currentThread().getState()); // 读取文件属于BIO阻塞，系统层面看线程是阻塞状态，但是JAVA层面线程是RUNNABLE状态
                    }
                    flag++;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(t1.getState()); // 获取线程状态，NEW：创建了线程对象，但是没有调用start()方法
        t1.start();
        Thread.sleep(1000); // 等到子线程执行结束
        System.out.println(t1.getState()); // 子线程执行结束，线程状态是 TERMINATED
        System.out.println("主线程结束");
    }
}
