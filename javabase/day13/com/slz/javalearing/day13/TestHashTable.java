package com.slz.javalearing.day13;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/17
 */
public class TestHashTable {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>(); // 键值都不能为空
//        hashtable.put(null, 13);
//        hashtable.put("abc", null);

        Map<String, Integer> map = new HashMap<>(); // 键值都可以为空
        map.put(null, null);
    }
}
