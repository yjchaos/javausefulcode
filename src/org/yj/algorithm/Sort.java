package org.yj.algorithm;

import sun.applet.Main;

import java.util.Arrays;

/**
 * 排序算法
 *
 * @author yaojun
 * @version 1.0
 * @date 2018/12/26 10:43
 */
public class Sort {
    private int[] intArray = new int[]{1, 8, 3, 9, 2, 7, 4, 6, 5, 0};

    public static void main(String[] args) {
        System.out.println("java 排序算法测试");
        Sort sort = new Sort();
//        sort.bubbleSort(sort.intArray);
        sort.bubbleSortOptimize(sort.intArray);
    }

    /**
     * 冒泡排序法
     */
    private void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("bubble sort result:" + Arrays.toString(array));
    }

    /**
     * 冒泡排序法优化
     */
    private void bubbleSortOptimize(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //flag表示这一轮冒泡是否有元素交换位置，如果没有则表明数组已经有序，直接break，不用再继续进行下一轮冒泡了
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println("bubble sort optimize result:" + Arrays.toString(array));

    }
}
