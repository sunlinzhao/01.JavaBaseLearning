package com.slz.javalearing.day08;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/6
 */
public class TestBigInteger {
    public static void main(String[] args) {
        BigInteger bi1 = new BigInteger("123456789123456789");
        System.out.println(bi1);

        BigInteger bi2 = BigInteger.valueOf(123456789L);
        System.out.println(bi2);

        double d1 = 3.14;
        int x = 10;
        System.out.println(d1*x);

        BigDecimal bd1 = new BigDecimal("3.14");
        BigDecimal bd2 = new BigDecimal("10");
        System.out.println(bd1.multiply(bd2));;

        System.out.println(bd1.intValue());
        System.out.println(bi2.intValue());

        BigDecimal bd3 = bd1.divide(bd2, RoundingMode.UP);
        System.out.println(bd3);

        BigDecimal[] bds = bd1.divideAndRemainder(bd2);
        System.out.println(bds[0]);
        System.out.println(bds[1]);
    }
}
