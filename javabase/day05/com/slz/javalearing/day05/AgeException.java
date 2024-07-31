package com.slz.javalearing.day05;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/3
 */
public class AgeException extends RuntimeException{ // 自定义运行时异常
    public AgeException() {
    }

    public AgeException(String message) {
        super(message);
    }
}
