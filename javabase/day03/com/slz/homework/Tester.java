package com.slz.homework;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/31
 */
public class Tester extends Employee{
    Tester(String name){
        this.name = name;
    }
    @Override
    public void showSalary(){
        System.out.println("我是" + name + ", 我的薪水是：" + getSalary());
    }
}
