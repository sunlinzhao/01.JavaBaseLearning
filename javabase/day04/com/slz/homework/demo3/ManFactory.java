package com.slz.homework.demo3;

import com.slz.homework.demo2.Man;
import com.slz.homework.demo2.People;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/2
 */
public class ManFactory implements Factory{
    @Override
    public People getPeople() {
        return new Man();
    }
}
