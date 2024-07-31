package com.slz.javalearing.day05;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/3
 */
public class TestThrow {
    public static void main(String[] args) {
        Student student = new Student("李", 1);
        try {
            check(student);
        } catch (NameException | AgeException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
    }
    public static void check(Student student) throws NameException{
        if(student.age < 2 || student.age > 12){
            throw new AgeException("年龄要在2-12之间"); // 运行时异常
        }
        if(student.name.length()<2){
            throw new NameException("名字长度要大于2"); // 检查时异常
        }
    }
}

class Student {
    public String name;
    public int age;
    Student(String name, int age){
        this.name = name;
        this.age = age;
    }
}
