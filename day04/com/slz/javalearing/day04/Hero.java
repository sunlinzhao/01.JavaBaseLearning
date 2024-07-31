package com.slz.javalearing.day04;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/31
 */
public abstract class Hero implements Attack{
}

class Shooter extends Hero{
    @Override
    public void start(){
        System.out.println("射箭 -> -> ->");
    }
}

class Thrower extends Hero{
    @Override
    public void start(){
        System.out.println("投石 -o -o -o");
    }
}
