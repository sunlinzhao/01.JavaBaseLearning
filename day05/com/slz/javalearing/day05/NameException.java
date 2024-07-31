package com.slz.javalearing.day05;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/3
 */
public class NameException extends Exception{ // 自定义检查时异常
    public NameException() {
    }
    public NameException(String message) {
        super(message);
    }
}
