package com.slz.javalearing.day06;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/4
 */
public class Book implements Cloneable {
    public String name;
    public int price;
    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 只有基本类型字段，调用Object的clone方法即可，属于浅拷贝
    }
}
