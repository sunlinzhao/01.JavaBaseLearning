package com.slz.homework.demo3;

import com.slz.homework.demo2.People;
import com.slz.homework.demo2.Woman;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/2
 */
public class WomanFactory implements Factory{
    @Override
    public People getPeople() {
        return new Woman();
    }
}
