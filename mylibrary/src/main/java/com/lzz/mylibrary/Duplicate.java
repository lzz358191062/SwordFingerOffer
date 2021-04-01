package com.lzz.mylibrary;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 返回描述：
 * 如果数组中有重复的数字，函数返回true，否则返回false。
 * 如果数组中有重复的数字，把重复的数字放到参数duplication[0]中。（ps:duplication已经初始化，可以直接赋值使用。）
 *
 * @author lzz
 * @time 21-1-25 下午2:13
 */
public class Duplicate {
    public static void main(String[] args) {
        System.out.println("hello world");
        int[] list = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];
        System.out.println("rv = " + doDuplicate(list, duplication));
        System.out.println("duplication[0] = " + duplication[0]);
    }

    public static boolean doDuplicate(int[] list, int[] duplication) {
        if (list == null || list.length == 0) {
            return false;
        }
        for (int i = 0; i < list.length; i++) {
            while (list[i] != i) {
                System.out.println("list[" + i + "]" + list[i]);
                if (list[i] == list[list[i]]) {
                    duplication[0] = list[i];
                    return true;
                }
                swap(list, i, list[i]);
            }
        }
        return false;
    }

    private static void swap(int[] list, int i, int j) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }


}