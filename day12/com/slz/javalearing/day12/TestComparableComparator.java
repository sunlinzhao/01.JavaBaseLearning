package com.slz.javalearing.day12;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/14
 */
public class TestComparableComparator {
    public static void main(String[] args) {
        TreeSet<Staff> treeSet = new TreeSet<>(); // Comparable 实现比较
        treeSet.add(new Staff("李白", 22));
        treeSet.add(new Staff("李白", 25));
        treeSet.add(new Staff("李白", 18));
        treeSet.add(new Staff("李白", 20));
        treeSet.add(new Staff("李白", 19));
        System.out.println(treeSet);

        TreeSet<Staff> treeSet1 = new TreeSet<>(new Comparator<Staff>() { // Comparator 实现比较，匿名内部类
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.getAge()-o2.getAge();
            }
        }); // Comparator 实现比较
        treeSet1.add(new Staff("李白", 22));
        treeSet1.add(new Staff("李白", 25));
        treeSet1.add(new Staff("李白", 18));
        treeSet1.add(new Staff("李白", 20));
        treeSet1.add(new Staff("李白", 19));
        System.out.println(treeSet1);
    }
}
