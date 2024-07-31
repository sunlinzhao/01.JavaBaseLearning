package com.slz.javalearing.day06;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/4
 */
public class Husky extends Dog{ // 哈士奇
    public String temper; // 脾气

    public Husky(String name, String type, int age, String temper) {
        super(name, type, age);
        this.temper = temper;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){ // 【非空性】
            return false;
        }
        if(obj==this){ // 【自反性】
            return true;
        }
        if(obj instanceof Husky) { // 【一致性 / 传递性】
            Husky husky = (Husky) obj; // 如果不是 Husky 及其子类，就不会进入这个判断，比如其父类，就直接调用父类 equals 方法
            return this.temper.equals(husky.temper) && super.equals(obj);
        }
        return super.equals(obj); // 【对称性】 父类，就直接调用父类 equals 方法
    }
}
