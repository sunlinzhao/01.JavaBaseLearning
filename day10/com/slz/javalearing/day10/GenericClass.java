package com.slz.javalearing.day10;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/11
 */
public class GenericClass<T> {
    private  T val;

    public GenericClass() {
    }

    public GenericClass(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }
}
