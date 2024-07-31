package com.slz.javalearing.day10;

import java.util.Arrays;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/11
 */
public class MyArray {
    private Object[] elementDate; // 存储数据的数组
    private int size; // 数组存储元素个数
    private static final int DEFAULT_CAPACITY = 10; // 默认初始空间大小
    private static final Object[] EMPTY_ELEMENTDATE = {}; // 空数组

    public MyArray() {
        elementDate = new Object[DEFAULT_CAPACITY];
    }

    public MyArray(int initialCapacity) {
        if (initialCapacity > 0)
            elementDate = new Object[initialCapacity];
        else if (initialCapacity == 0) {
            elementDate = new Object[]{};
        } else {
            throw new IllegalArgumentException("数组初始化参数异常：" + initialCapacity);
        }
    }

    public int size() {
        return size;
    }

    public void add(Object obj) { // 添加
        if (size >= elementDate.length)
            elementDate = grow();
        elementDate[size] = obj;
        size++;
    }

    public void add(int index, Object obj) { // 插入
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("索引异常" + index);
        }
        if (size >= elementDate.length)
            elementDate = grow();
        System.arraycopy(elementDate, index, elementDate, index+1, size-index);
        elementDate[index] = obj;
        size++;
    }

    public Object remove(int index){ // 删除
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("索引异常" + index);
        }
        Object obj = elementDate[index];
        size--;
        if(size>index){
            System.arraycopy(elementDate, index+1, elementDate, index, size-index);
        }
        elementDate[size] = null;
        return obj;
    }

    public Object get(int index) { // 检索
        if (index < elementDate.length && index >= 0) {
            return elementDate[index];
        } else {
            throw new IllegalArgumentException("索引长度异常");
        }
    }

    public void clear() { // 清除
//        elementDate = EMPTY_ELEMENTDATE;
        int to = size;
        size = 0;
        for (int i = 0; i < to; i++) {
            elementDate[i] = null;
        }
    }

    // 扩容
    public Object[] grow() {
        return Arrays.copyOf(elementDate, elementDate.length * 2); // 每次扩容两倍
    }
}
