package com.lzz.mylibrary;

/**
 * 将旋转数组对半分可以得到一个包含最小元素的新旋转数组，以及一个非递减排序的数组。
 * 新的旋转数组的数组元素是原数组的一半，从而将问题规模减少了一半，这种折半性质的
 * 算法的时间复杂度为 O(logN)（为了方便，这里将 log2N 写为 logN）。
 *
 * @author lzz
 * @time 21-2-6 下午2:18
 */
public class MinNumberInRotateArray {


    int[] num = {5, 6, 7, 8, 9, 10, 0, 1, 1, 1};

    public static void main(String[] args) {
        MinNumberInRotateArray obj = new MinNumberInRotateArray();
        int min = obj.minNumberInRotateArray();
        System.out.println(" min num = " + min);
    }

    private int minNumberInRotateArray() {
        int l = 0;
        int h = num.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (num[m] == num[l] && num[m] == num[h]) {
                return minNumber(num, l, h);
            } else if (num[m] <= num[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return num[l];
    }

    private int minNumber(int[] num, int l, int h) {
        for (int i = l; i < h - 1; i++) {
            if (num[i] > num[i + 1]) {
                return num[i + 1];
            }
        }
        return num[l];
    }
}
