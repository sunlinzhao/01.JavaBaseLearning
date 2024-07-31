package com.slz.javalearing.day12;

import java.util.Objects;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/14
 */
public class Staff implements Comparable<Staff> {
    private String name;
    private Integer age;

    public Staff() {
    }

    public Staff(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(name, staff.name) && Objects.equals(age, staff.age);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Staff o) {
        // 按照哪个属性进行排序
        // 小于传入参数，返回-1，相同，返回0，大于返回1
        return this.age - o.getAge();
    }
}
