package org.yj.java.core.Collection;

import java.util.Arrays;

/**
 * 自己实现ArrayList
 * 
 * @author yaojun
 * @version 1.0
 * @date 2019/1/2 10:39
 */
public class MyArrayList<T> {

    /**
     * 默认数组大小
     */
    public static final int DEFAULT_CAPACITY = 10;

    /**
     * 当前元素个数，同时也指向当前插入元素的位置
     */
    private int size = 0;

    private Object[] elementData;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initialCapacity:" + initialCapacity);
        }
        elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T element) {
        // 什么时候扩容
        if (size == elementData.length) {
            Object[] newElementData = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
            elementData = newElementData;
        }
        elementData[size++] = element;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        return (T) elementData[index];
    }

    public void remove(T element) {
        // element，将它和所有元素挨个比较，获得第一个比较为true的，返回。
        for (int i = 0; i < size; i++) {
            // 容器中所有的比较操作，都是用的equals而不是==
            if (element.equals(get(i))) {
                // 将该元素从此处移除
                remove(i);
                return;
            }
        }
    }

    public void remove(int index) {
        // 需要移动的元素数量，比如数组长度是10，删除索引为5的元素，那么索引为6/7/8/9的元素
        // 需要前移，所以需要移动的元素数量为4
        int numMoved = elementData.length - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }

    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            myArrayList.add(i + "");
        }
        myArrayList.add("1");
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());
        System.out.println("isEmpty：" + myArrayList.isEmpty());
        System.out.println(myArrayList.get(5));
        myArrayList.remove("1");
        System.out.println(myArrayList);
    }
}
