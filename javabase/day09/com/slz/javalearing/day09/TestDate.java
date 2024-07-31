package com.slz.javalearing.day09;

import java.util.Date;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/6
 */
public class TestDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date); // CST : Chinese Standard Time
        System.out.println(date.toLocaleString());

        Date date1 = new Date(System.currentTimeMillis() - 2000);
        Date date2 = new Date(System.currentTimeMillis() + 2000);
        System.out.println(date1.before(date2));
        System.out.println(date2.before(date1));
        System.out.println(date1.after(date2));
        System.out.println(date2.after(date1));
        System.out.println(date.compareTo(date1));
        System.out.println(date.compareTo(date2));
        System.out.println(date1.equals(date2));
        System.out.println(date1.equals(date1));
    }
}
