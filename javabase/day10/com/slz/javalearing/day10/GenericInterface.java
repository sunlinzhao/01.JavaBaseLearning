package com.slz.javalearing.day10;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/11
 */
public interface GenericInterface<T> {
    void show(T val);
}
class impl1 implements GenericInterface<String>{ // 这种实现不够灵活，只能指定某一种类型的实现
    @Override
    public void show(String val) {
        System.out.println(val);
    }
}
class impl2<T> implements GenericInterface<T>{ // 直接用泛型类去实现泛型接口，更加灵活，等到实例化时才需要指定类型
    @Override
    public void show(T val) {
        System.out.println(val);
    }
}
