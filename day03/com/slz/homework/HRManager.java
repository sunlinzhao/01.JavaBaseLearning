package com.slz.homework;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/31
 */
public class HRManager extends Employee{
    HRManager(String name){
        this.name = name;
    }
    @Override
    public void showSalary(){
        System.out.println("我是" + name + ", 我的薪水是：" + getSalary());
    }

    public void giveSalary(Employee employee){
        if(employee instanceof  Programmer){
            employee.setSalary(18000 - employee.getDiff());
        } else if(employee instanceof  Tester) {
            employee.setSalary(10000 - employee.getDiff());
        } else if (employee instanceof Designer) {
            employee.setSalary(7000 - employee.getDiff());
        }
    }

    public void giveDiff(Employee employee, int diff){
        employee.setDiff(diff);
    }
}
