package com.slz.javalearing.day04;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/31
 */
public interface Test2 extends Test, Test1 { // 接口可以实现多继承
}

class implTest implements Test2 {
    @Override
    public void fun(){

    }
}
class implTest1 implements Test2, Test { // 一个接口可以被多个类实现, 一个类可以实现多个接口
    @Override
    public void fun(){

    }
}

class implTest2 extends implTest1 implements Test1, Test{
}