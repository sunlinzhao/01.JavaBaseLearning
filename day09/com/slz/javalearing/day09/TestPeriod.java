package com.slz.javalearing.day09;

import com.slz.homework.demo2.People;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/10
 */
public class TestPeriod {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2022, 8, 13);
        LocalDate date2 = LocalDate.of(2024, 9, 15);

        // 方法 1
        Period between = Period.between(date1, date2);
        System.out.println("year: " + between.getYears());
        System.out.println("month: " + between.getMonths());
        System.out.println("day: " + between.getDays());
        // 方法 2
        System.out.println("days: " + ChronoUnit.DAYS.between(date1, date2));
        System.out.println("years: " + ChronoUnit.YEARS.between(date1, date2));
        System.out.println("months: " + ChronoUnit.MONTHS.between(date1, date2));
        // 方法 3
        System.out.println(date2.toEpochDay() - date1.toEpochDay());
    }
}
