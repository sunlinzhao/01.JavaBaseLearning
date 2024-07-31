package com.slz.javalearing.day13;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/16
 */
public class TestLinkedHashMap {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new LinkedHashMap<>(); // 按放入顺序存放（链表）和遍历访问
        map1.put("张三", 14);
        map1.put("李四", 15);
        map1.put("王五", 16);
        Set<Map.Entry<String, Integer>> entrySet = map1.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
