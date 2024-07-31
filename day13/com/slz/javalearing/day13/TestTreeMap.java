package com.slz.javalearing.day13;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/16
 */
public class TestTreeMap {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new TreeMap<>(); // 键以树存储，使按键有序
        map1.put(22, "张三");
        map1.put(15, "李四");
        map1.put(18, "王五");
        Set<Map.Entry<Integer, String>> entrySet = map1.entrySet();
        for (Map.Entry<Integer, String> integerStringEntry : entrySet) {
            System.out.println(integerStringEntry.getKey() + "\t" + integerStringEntry.getValue());
        }
    }
}
