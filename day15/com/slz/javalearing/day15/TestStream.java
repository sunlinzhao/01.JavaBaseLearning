package com.slz.javalearing.day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/19
 */
public class TestStream {
    public static void main(String[] args) {
        List<Hero> list = new ArrayList<>();
        list.add(new Hero("盖伦", 7000));
        list.add(new Hero("露娜", 5000));
        list.add(new Hero("后羿", 4000));
        list.add(new Hero("孙悟空", 6000));
        Stream<Hero> stream = list.stream(); // 将list转为stream接口; 链式编程
        Stream<Hero> stream1 = stream.filter(hero -> hero.getBlood() >= 5000);// filter 中的参数是断言型接口, 返回值仍然是 Stream
        List<Hero> newList = stream1.collect(Collectors.toList());
        newList.forEach(System.out::println);
        List<Hero> newList1 = list.stream().filter(hero -> hero.getBlood()>=5000).map(hero -> { // map 的参数是Function接口，有参数有返回值
            hero.setBlood(hero.getBlood()-500);
            return hero;
        }).collect(Collectors.toList());
        newList1.forEach(System.out::println);
    }
}
class Hero{
    private String name;
    private Integer blood;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBlood() {
        return blood;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    public Hero(String name, Integer blood) {
        this.name = name;
        this.blood = blood;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", blood=" + blood +
                '}';
    }
}