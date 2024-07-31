package com.slz.javalearing.day19;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/2
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }
    public static boolean isPrime(int num){
        if(num==1) return false;
        if(num==2) return true; // 质数从2开始算
        int sqrt = (int)Math.sqrt(num);
        for(int i=2; i<=sqrt; i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
