package com.slz.homework;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/5/31
 */
public class MainTest {
    public static void main(String[] args) {
        HRManager hr = new HRManager("李清照");
        Employee prg = new Programmer("杜甫");
        Employee dsg = new Designer("李商隐");
        Employee tester = new Tester("白居易");

        hr.giveDiff(tester, 1000);

        hr.giveSalary(prg);
        hr.giveSalary(tester);
        hr.giveSalary(dsg);

        prg.showSalary();
        tester.showSalary();
        dsg.showSalary();
    }
}
