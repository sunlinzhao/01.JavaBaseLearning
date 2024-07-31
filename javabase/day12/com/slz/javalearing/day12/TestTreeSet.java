package com.slz.javalearing.day12;

import java.util.TreeSet;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/14
 */
public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(9);
        treeSet.add(7);
        treeSet.add(8);
        treeSet.add(6);
        System.out.println(treeSet); // [6, 7, 8, 9]
    }
}
