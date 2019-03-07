package org.yj.java.core.collection;

import java.util.*;

/**
 * @author yaojun
 */
public class TestIterator {
    public static void main(String[] args) {
        // testIteratorList();
        // testIteratorSet();
        // testIteratorMap();

        testRemove();
    }

    /**
     * 迭代器遍历list
     */
    public static void testIteratorList() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        // 使用iterator遍历List
        for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
            String temp = iter.next();
            System.out.println(temp);
        }

    }

    /**
     * 迭代器遍历set
     */
    public static void testIteratorSet() {
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");

        // 使用iterator遍历Set
        for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
            String temp = iter.next();
            System.out.println(temp);
        }

    }

    /**
     * 迭代器遍历map
     */
    public static void testIteratorMap() {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(100, "aa");
        map1.put(200, "bb");
        map1.put(300, "cc");

        // 第一种遍历Map的方式
        Set<Map.Entry<Integer, String>> ss = map1.entrySet();
        for (Iterator<Map.Entry<Integer, String>> iter = ss.iterator(); iter.hasNext();) {
            Map.Entry<Integer, String> temp = iter.next();

            System.out.println(temp.getKey() + "--" + temp.getValue());

        }
        System.out.println("++++++++++++++++++++++++");
        // 第二种遍历Map的方式
        Set<Integer> keySet = map1.keySet();
        for (Iterator<Integer> iter = keySet.iterator(); iter.hasNext();) {
            Integer key = iter.next();
            System.out.println(key + "----" + map1.get(key));
        }
    }

    // 测试边遍历，边删除
    public static void testRemove() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("gao" + i);
        }

        // 使用for循环边遍历边删除，有可能出错，如下
        // for (int i = 0; i < list.size(); i++) {
        // String temp = list.get(i);
        // if (temp.endsWith("9")) {
        // list.remove(i);
        // }
        // System.out.println(list.size());
        // System.out.println(list.get(i));
        // }

        // 使用迭代器删除
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            String temp = iterator.next();
            if (temp.endsWith("9")) {
                iterator.remove();
            }
            System.out.println(list.size());
            System.out.println(temp);
        }
    }
}
