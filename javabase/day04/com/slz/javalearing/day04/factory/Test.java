package com.slz.javalearing.day04.factory;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/31
 */
public class Test {
    public static void main(String[] args) {
        Fruit fruit1 = Factory.getFruit("apple");
        Fruit fruit2 = Factory.getFruit("banana");
        if(fruit1!=null){
            fruit1.plant();
            fruit1.grow();
            fruit1.harvest();
        }
        if(fruit2!=null){
            fruit2.plant();
            fruit2.grow();
            fruit2.harvest();
        }
    }
    A a = new B();
}

abstract class A {

}

class B extends A {

}