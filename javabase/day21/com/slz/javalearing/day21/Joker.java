package com.slz.javalearing.day21;

import java.io.IOException;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/29
 */
public class Joker <T>{
    private String name;
    private Integer age;
    int param1;
    public double param2;
    protected long param3;


    public Joker() {
    }

    private Joker(String name) {
        this.name = name;
    }

    public Joker(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void test1() throws IOException {}
    private void test2(String msg){
        System.out.println("收到：" + msg);
    }

    @Override
    public String toString() {
        return "Joker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
