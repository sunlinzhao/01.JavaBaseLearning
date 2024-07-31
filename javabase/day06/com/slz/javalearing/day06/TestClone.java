package com.slz.javalearing.day06;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/4
 */
public class TestClone {
    public static void main(String[] args) {
        Student student1 = new Student("李白", new Book("《计算机组成原理》", 12));
        try { // 捕捉异常
            // 【注意：这里是安全的父类强转子类，因为super这里调用的是父类方法，但是其运行的实例对象是子类类型，可以安全地转为子类，没有问题】
            Student student2 = (Student) student1.clone(); // 由于调用父类的clone方法，返回是Object类型，这里需要强转成Student
            student2.book.name = "《数据结构》";
            System.out.println(student1);
            System.out.println(student2);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
