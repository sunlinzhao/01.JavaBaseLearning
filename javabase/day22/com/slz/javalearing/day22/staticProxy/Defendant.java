package com.slz.javalearing.day22.staticProxy;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/30
 */
public class Defendant implements Court{ // 被告人类
    @Override
    public void litigate() {  // 辩护方法
        System.out.println("我没罪啊！！！");
    }
}
