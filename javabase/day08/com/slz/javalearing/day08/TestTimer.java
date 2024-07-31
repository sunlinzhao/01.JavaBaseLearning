package com.slz.javalearing.day08;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/6
 */
public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // 匿名内部类
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 0, 1000);
//        timer.cancel(); // 取消定时任务
    }
}
