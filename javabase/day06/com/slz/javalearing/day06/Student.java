package com.slz.javalearing.day06;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/4
 */
public class Student implements Cloneable{ // 实现 Cloneable 接口，这是一个声明，只有实现了这个接口才可以使用clon
    public String name;
    public Book book;
    public Student(String name, Book book) {
        this.name = name;
        this.book = book;
    }
    @Override
    public Object clone() throws CloneNotSupportedException { // 改为 public 方法，并向上抛出 CloneNotSupportedException 异常
        // 【注意：这里是安全的父类强转子类，因为super这里调用的是父类方法，但是其运行的实例对象是子类类型】
        Student student =  (Student) super.clone(); // 调用Object的clone方法，处理基本类型字段
        student.book = (Book) book.clone(); // 处理引用类型字段
        return student;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", book=" + book.toString() +
                '}';
    }
}
