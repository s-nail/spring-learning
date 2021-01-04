package com.mine.velocity;

import org.junit.Test;

public class ArrayTest {
    @Test
    public void test() {
        //int[] array = new int[]{3, 4, 5, 6, 7, 1, 2};
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        int targetNo = 7;

        int index = binarySearch(array, targetNo);
        System.out.println(index);
    }

    /**
     * 二分查找方法
     *
     * @param array 数组
     * @param key   目标值
     * @return 目标key值对应的下标
     */
    private static int binarySearch(int[] array, int key) {
        if (array == null) {
            throw new RuntimeException("数组不能为空");
        }
        int startPosition = 0;
        int endPosition = array.length - 1;
        while (startPosition <= endPosition) {
            //右移1位，计算出数组的中间position
            int mid = (startPosition + endPosition) >> 1;
            int midVal = array[mid];
            if (key > midVal) {
                startPosition = mid + 1;
            } else if (key < midVal) {
                endPosition = mid - 1;
            } else {
                //命中key值，返回下标
                return mid;
            }
        }
        return -1;
    }
}