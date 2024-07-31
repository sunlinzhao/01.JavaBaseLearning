package com.slz.javalearing.day22;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/7/30
 */
public @interface Anno1 {
    String hello() default "sb"; // 使用注解时的一个配置参数，方法的名称，就是参数的名称，方法的返回值类型，就是参数的类型
    int hello1() default 0;
    Class<?> hello2() default String.class;

    Anno2 hello4() default @Anno2;
    int[] hello5() default {};
    Gender hello3() default Gender.WOMAN;

}
enum Gender{
    MAN, WOMAN
}
