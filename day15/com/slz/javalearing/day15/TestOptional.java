package com.slz.javalearing.day15;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/20
 */
public class TestOptional {
    public static void main(String[] args) {
//        Stream<String> stream = Arrays.asList("aa", "bb", "cc").stream();
//        Optional<String> first = stream.findFirst();
//        Optional<String> optional = Optional.empty(); // 返回一个空的Optional实例对象
//        System.out.println(optional.get()); // 空的实例get获取不会报空指针异常，而是返回 NoSuchElementException: No value present
        Optional<String> optional1 = Optional.of("aaa");
        System.out.println(optional1.get());
//        Optional<String> optional2 = Optional.of(getValue()); // of 要求返回非空值，否则会报空指针异常 NullPointerException
//        System.out.println(optional2.get());
        Optional<String> optional3 = Optional.ofNullable(getValue()); // ofNullable，可以返回空值. 为空时报异常 NoSuchElementException: No value present
        boolean present = optional3.isPresent(); // 同样需要判断是否为空
        if(present)
            System.out.println(optional3.get());
        System.out.println(optional3.orElse("hi")); // 返回值如果存在就输出，否则给出默认值，简化判断
        System.out.println(optional3.orElseGet(()->"hi"));

        Student student = new Student("杜甫", 20);
        Optional<Student> optional4 = Optional.ofNullable(student);
        System.out.println(optional4.orElse(new Student("李白", 18))); // orElse 无论Optional是否为空，都执行
        System.out.println(optional4.orElseGet(()->new Student("李白", 18))); // orElseGet 只有当Optional为空才执行，否则不执行

    }

    public static String getValue() {
        double d = Math.random();
        return d > 0.5 ? "hello" : null;
    }
}

class Student{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(String name, Integer age) {
//        System.out.println("执行了Student构造方法");
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}