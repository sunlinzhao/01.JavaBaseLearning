package com.slz.homework.demo2;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/2
 */
public class Factory {
    public People getPeople(String s){
        if("man".equals(s)){
            return new Man();
        } else if("woman".equals(s)){
            return new Woman();
        }
        return null;
    }
}
