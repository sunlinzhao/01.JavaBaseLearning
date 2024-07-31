package com.slz.javalearing.day12;

import java.util.*;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/14
 */
public class TestCollections {
    public static void main(String[] args) {
        // Arrays Arrays 是针对int[] / Object[]数组的工具类(引用类型需要实现Comparable接口，或者sort传入Comparator比较器)；Collections 是针对集合类的工具类；
        char[] chars = {'b', 'c', 'a'};
        System.out.println(chars);
        Arrays.sort(chars);
        System.out.println(chars);

        Staff[] strings = {new Staff("李白", 23), new Staff("李白", 22), new Staff("李白", 18)};
        Arrays.sort(strings);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        Collections.sort(arrayList); // 默认升序
        System.out.println(arrayList);
        Collections.reverse(arrayList); // 反转
        System.out.println(arrayList);

        ArrayList<Staff> arrayList1 = new ArrayList<>();
        arrayList1.add(new Staff("李白", 22));
        arrayList1.add(new Staff("李白", 25));
        arrayList1.add(new Staff("李白", 18));
        arrayList1.add(new Staff("李白", 20));
        arrayList1.add(new Staff("李白", 19));
        Collections.sort(arrayList1, new Comparator<Staff>() { // 引用类型，带比较器的排序
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(arrayList1);
        System.out.println(Collections.binarySearch(arrayList1, new Staff("李白", 22))); // 二分查找，返回索引
        Collections.shuffle(arrayList1); // 随机打乱顺序
        System.out.println(arrayList1);
        Collections.swap(arrayList1, 0, 1); // 交换两个索引位置的元素
        System.out.println(arrayList1);
        System.out.println(Collections.max(arrayList1)); // 最大值
        System.out.println(Collections.min(arrayList1)); // 最小值
        System.out.println(Collections.frequency(arrayList1, new Staff("李白", 22))); // 统计频次

        List<Integer> list = Collections.synchronizedList(new ArrayList<>()); // 返回线程同步的List
        Set<Integer> set = Collections.synchronizedSet(new HashSet<>()); // 返回线程同步的Set
        Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>()); // 返回线程同步的Map

    }
}
