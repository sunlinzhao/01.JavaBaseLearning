package com.slz.javalearing.day13;

import java.util.ResourceBundle;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/17
 */
public class TestResourceBundle {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("test"); // 只写文件名，不写扩展名
        System.out.println(bundle.getString("username"));
        System.out.println(bundle.getString("password"));
    }
}
