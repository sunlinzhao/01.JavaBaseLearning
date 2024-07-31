package com.slz.javalearing.day11;

import java.util.*;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/13
 */
public class TestIterator {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("a", "b", "c", "d", "e"); // 固定大小数组，不能添加/移除数据
        List<String> list = new ArrayList<>(); // 固定大小数组，不能添加/移除数据
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        // 正向遍历
        ListIterator<String> listIterator = list.listIterator();
        listIterator.add("e"); // 迭代器起始位置在 0, 则这里在0位置插入， 插入位置为迭代器当前位置之前
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        System.out.println("--------------");
        ListIterator<String> listIterator1 = list.listIterator(); // 重新获取起始位置
        while (listIterator1.hasNext()){
            System.out.println((listIterator1.nextIndex() + " : " + listIterator1.next())); // nextIndex(): 返回集合中迭代器位置元素的索引
        }
        System.out.println("--------------");
        // 反向遍历
        ListIterator<String> listIterator2 = list.listIterator(list.size()); // 指定呆迭代器起始位置
        while (listIterator2.hasPrevious()){
            System.out.println(listIterator2.previousIndex() + " : " + listIterator2.previous());
        }
        listIterator2.set("GGG"); // 修改迭代器所在位置的值
        System.out.println(list);

        for (String s : list) {
            System.out.println(s);
//            list.remove(s); // 集合循环遍历时，不支持删除操作
        }
        while (listIterator2.hasNext()){
            String s = listIterator2.next();
            if("GGG".equals(s)) {
                listIterator2.remove(); // 调用迭代器的 remove 方法
            }
        }
        System.out.println(list);
    }
}
