package com.slz.javalearing.day12;

import java.util.HashSet;
import java.util.Set;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/14
 */
public class TestHash {
    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>(); // 唯一性， 无序性
        mySet.add("aaa");
        mySet.add("bbb");
        mySet.add("ccc");
        mySet.add("ddd"); // equals() 判澌两个数据是否等,如果相等、则将原有数覆盖
        System.out.println(mySet);
        mySet.remove("ccc");
        System.out.println(mySet);
        mySet.add("aaa");
        System.out.println(mySet);
    }
}
