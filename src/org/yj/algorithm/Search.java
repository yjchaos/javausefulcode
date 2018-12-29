package org.yj.algorithm;

/**
 * 搜索算法
 * @author yaojun
 * @version 1.0
 * @date 2018/12/26 11:23
 */
public class Search {

    private int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        System.out.println("java 搜索算法测试");
        Search search = new Search();
        search.binarySearch(search.intArray, 10);
    }

    /**
     * 二分法查找，前提是数组必须有序
     */
    private int binarySearch(int[] array, int value) {
        System.out.println("search value:" + value);
        int low = 0;
        int high = intArray.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (value == intArray[middle]) {
                System.out.println("index of number is:" + middle);
                return middle;
            } else if (value > intArray[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        System.out.println("can not find:" + value);
        return -1;
    }
}
