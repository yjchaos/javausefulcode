package org.yj.java.core.Collection;

import java.util.HashMap;

/**
 * @author yaojun
 */
public class MyHashSet<T> {

    private static final Object PRESENT = new Object();

    HashMap<T, Object> hashMap;

    public MyHashSet() {
        hashMap = new HashMap<>();
    }

    public int size() {
        return hashMap.size();
    }

    public void add(T o) {
        hashMap.put(o, PRESENT);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (Object key : hashMap.keySet()) {
            sb.append(key + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");

        System.out.println(set);
    }
}
