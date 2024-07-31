package com.slz.javalearing.day11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/13
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add(789) ;
        System.out.println(arrayList.toString());

        ArrayList<String> arrayList1 = new ArrayList<>(10); // 指定数组长度
        arrayList1.add("A");
        arrayList1.add("b");
        arrayList1.add("C");
        // 遍历方式：1. fori 2. foreach 3. iterator 4. lambda 方式略
        Iterator<String> iterator = arrayList1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // ArrayList 其它常用方法
        System.out.println(arrayList);
        arrayList.add(0, 666); // 指定位置插入元素
        System.out.println(arrayList);

        List<Integer> list = arrayList.subList(0,2);
    }
}
