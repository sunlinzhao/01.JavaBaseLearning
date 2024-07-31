package com.slz.javalearing.day08;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/6
 */
public class TestEnum {
    public static void main(String[] args) {
        System.out.println(Status.IN);
        for (Status s: Status.values()) {
            System.out.println(s);
        }
        Status s1 = Status.IN;
        Status s2 = Status.OUT;
        switch (s2){
            case IN:
                System.out.println("入库");
                break;
            case OUT:
                System.out.println("出库");
                break;
            default:
                System.out.println("未知");
        }
        System.out.println(s1.toString());
        System.out.println(Status.OUT.ordinal()); // 获取枚举成员的索引位置
        System.out.println(Status.IN.ordinal()); // 获取枚举成员的索引位置

        Status s3 = Status.valueOf("IN"); // 将字符串转换为枚举实例
        System.out.println(s3);

        System.out.println(Status.OUT.compareTo(Status.IN)); // compareTo(): 比较两个枚举成员在定义
    }
}
