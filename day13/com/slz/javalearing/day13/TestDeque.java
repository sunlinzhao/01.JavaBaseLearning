package com.slz.javalearing.day13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/17
 */
public class TestDeque {
    public static void main(String[] args) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new LinkedList<>();
        deque2.add(1);
        deque2.addLast(2);
        deque2.addFirst(3);
        System.out.println(deque2);
    }
}
