package com.slz.javalearing.day06;

import java.util.Objects;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/3
 */
public class Dog {
    public String name;
    public String type;
    public int age;

    public Dog(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){ // 判断为空 【非空性】
            return false;
        }
        if(this==obj){
            return true; // 占用同一块地址，则值一定相等 【自反性】
        }
        if(obj instanceof Dog){ // 判断同一类型 【一致性、传递性】
            Dog dog = (Dog) obj;
            return this.name.equals(dog.name) && this.type.equals(dog.type) && this.age== dog.age;
        }
        return super.equals(obj); // 不是同一类型，调用父类equals方法比较 【对称性】
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, age);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                '}';
    }
}
