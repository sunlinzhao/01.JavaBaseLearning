package com.slz.javalearing.day13;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/17
 */
public class TestProperties {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(TestProperties.class.getClassLoader().getResourceAsStream("test.properties"));
        System.out.println(properties.getProperty("username"));
        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
