package com.slz.javalearing.day06;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/3
 */
public class Test {
    public static void main(String[] args) {
        Dog dog1 = new Dog("大黄", "中华田园犬", 5);
        Dog dog2 = new Dog("小白", "哈士奇", 3);
        Dog dog3 = new Dog("大黄", "中华田园犬", 5);
        Dog dog4 = new Dog("大黄", "中华田园犬", 5);

        Husky husky1 = new Husky("小白", "哈士奇", 3, "暴躁");
        Husky husky2 = new Husky("小黑", "哈士奇", 3, "温和");
        Husky husky3 = new Husky("小白", "哈士奇", 3, "温和");

        System.out.println(dog2.equals(husky1));
        System.out.println(husky1.equals(dog2));
        System.out.println(husky2.equals(dog2));
        System.out.println(dog2.equals(husky2));

        System.out.println(husky2.equals(husky3));

//        System.out.println(dog1.equals(dog1)); // 自反性
//
//        System.out.println(dog2.equals(dog1)); // 对称性
//        System.out.println(dog1.equals(dog2));
//
//        System.out.println(dog1.equals(dog3)); // 传递性
//        System.out.println(dog3.equals(dog4));
//        System.out.println(dog1.equals(dog4));
//
//        System.out.println(dog1.equals(null)); // 非空性
        System.out.println(dog1.hashCode());
        System.out.println(dog2.hashCode());
        System.out.println(dog3.hashCode());

        System.out.println(dog1.toString());
        System.out.println(husky2.toString());
    }
}
