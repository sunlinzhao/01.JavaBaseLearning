package com.slz.javalearing.day13;

import java.util.Stack;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/17
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1); // 压栈
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.search(3)); // 查找元素，返回所在位置
        System.out.println(stack.search(5));
        System.out.println(stack.size());
        while (!stack.isEmpty() || !stack.empty()){ // 判断是否为空
            System.out.println(stack.pop()); // 出战
        }
    }
}
