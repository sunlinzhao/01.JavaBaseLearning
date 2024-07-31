package com.slz.javalearing.day13;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/17
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>(); // LinkedList 实现了 Deque 接口, Deque 继承自 Queue 接口, 基于链表实现;
        Queue<Integer> queue2 = new ArrayDeque<>(); // ArrayDeque 实现了 Deque 接口, Deque 继承自 Queue 接口, 基于数组实现;
        queue2.add(1); // 向队列中添加元素，
        queue2.offer(2); // 向队列中添加元素，
    }
}
