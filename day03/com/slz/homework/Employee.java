package com.slz.homework;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/31
 */
public abstract class Employee {
    private int salary; // 薪资
    public String name; // 姓名
    private int diff = 0; // 薪资扣除
    public abstract void showSalary();

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }
}
