package com.slz.javalearing.day13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/16
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("张三", 14);
        map1.put("李四", 15);
        map1.put("王五", 16);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("赵六", 13);
        map2.put("李四", 20);
        map2.put("钱八", 22);
        map1.putAll(map2);

        Set<Map.Entry<String, Integer>> entrys = map1.entrySet();
        for (Map.Entry<String, Integer> entry : entrys) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
