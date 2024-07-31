package com.slz.javalearing.day16;

import java.io.*;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/27
 */
public class TestObjectOutputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("曹孟德", 27);
        File file = new File(".\\javabase\\resource\\obj.stu");
        // 序列化
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
        // 反序列化
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student s = (Student) objectInputStream.readObject();
        System.out.println(s);
        objectInputStream.close();
        // 序列化相关问题
        Student student1 = new Student("张三", 18, new Book("厚大法考"));
        File file1 = new File(".\\javabase\\resource\\obj1.stu");
        FileOutputStream fileOutputStream1 = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
        objectOutputStream1.writeObject(student1);
        objectOutputStream1.close();

    }
}

class Student implements Serializable { // Serializable 不需要实现任何方法，只是一个可以被序列化的声明
    private static final long serialVersionUID = 3519662762363735564L; // IDEA 自动生成的版本号
    public static int test; // static 字段不会被实例化
//    private static final long serialVersionUID = 123L; // 显式生成版本号
    public String name;
    public Integer age;
    public transient Book book; // transient 关键字可以指定某些字段不被序列化，比如不可序列化类型、密码等
//    public Book book;

    public Student(String name, Integer age) { // 方法不会被实例化
        this.name = name;
        this.age = age;
    }

    public Student(String name, Integer age, Book book) {
        this.name = name;
        this.age = age;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", book=" + book +
                '}';
    }
}
class Book {
    public String name;

    public Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
