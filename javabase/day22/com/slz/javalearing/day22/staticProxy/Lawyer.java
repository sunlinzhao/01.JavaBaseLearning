package com.slz.javalearing.day22.staticProxy;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/30
 */
public class Lawyer implements Court{ // 律师类（代理）
    private Defendant defendant;

    public Lawyer(Defendant defendant) {
        this.defendant = defendant;
    }

    private void collect(){
        System.out.println("收集证据...");
    }
    private void defend(){
        System.out.println("进行辩护...");
    }
    @Override
    public void litigate() {
        collect();
        defendant.litigate();
        defend();
    }
}
