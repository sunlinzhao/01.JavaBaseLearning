package com.slz.javalearing.day04;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/31
 */
public class TestHero {
    public static void main(String[] args) {
        Attack shoot = new Shooter();
        Attack thrower = new Thrower();
        shoot.start();
        thrower.start();
    }
}
