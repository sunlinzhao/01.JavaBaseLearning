package com.slz.javalearing.day08;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/6
 */
public enum Status {
    IN("入库", 1), OUT("出库", 2); // 实参
    public String show; // 给枚举量添加属性，定义枚举类对应的常量，必须是private
    public int index;
    Status() {
    }
    Status(String show, int index) { // 顺序要对应（形参）；构造函数，默认私有的
        this.show = show;
        this.index = index;
    }
    @Override
    public String toString() {
        return show + "_" + index;
    }
}
