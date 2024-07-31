package com.slz.javalearing.day12;

import java.util.LinkedList;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/14
 */
public class TestLinkList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("aaa");
        linkedList.add("bbb");
        linkedList.add("ccc");
        linkedList.addFirst("000");
        linkedList.addLast("999");
        linkedList.add(0, "666");
        for (String s : linkedList) {
            System.out.println(s);
        }
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.remove("ccc");
    }
}
