package com.slz.javalearing.day22;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/30
 */

@Target({ElementType.TYPE}) // 可以使用在类、接口、枚举上
@Retention(RetentionPolicy.RUNTIME) // 运行时保留，因此可以通过反射机制读取这些注解
public @interface Config {
    String className();
    String propertyName();
    String propertyValue();
}
