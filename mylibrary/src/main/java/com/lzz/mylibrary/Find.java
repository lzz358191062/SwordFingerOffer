package com.lzz.mylibrary;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * 复制代码
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * @author lzz
 * @time 21-1-25 下午3:23
 */
public class Find {

    public static void main(String[] args) {
        int[][] arrary = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println("二维数组包含目标数 = " + Find(7, arrary));
        System.out.println("二维数组包含目标数 = " + FindtTwo(7, arrary));
    }

    public static boolean Find(int target, int[][] array) {
        int h = array[0].length;
        int w = array.length - 1;
        for (int i = w; i > 0; i--) {
            int j = 0;
            while (j < h) {
                if (array[j][i] > target) {
                    break;
                } else if (array[j][i] < target) {
                    j++;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean FindtTwo(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int column = array[0].length;
        int row = array.length;
        int i = column - 1;
        int j = 0;
        while (i > 0 && j < row - 1) {
            if (array[i][j] > target) {
                j--;
            } else if (array[j][i] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
