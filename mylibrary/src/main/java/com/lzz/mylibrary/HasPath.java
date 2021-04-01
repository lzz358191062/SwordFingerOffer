package com.lzz.mylibrary;

/**
 * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
 *
 * @author lzz
 * @time 21-3-25 下午5:29
 */
class HasPath {

    public static void main(String[] args) {
        char[] source = "ABCESFCSADEE".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] target = "ABCCED".toCharArray();
        HasPath obj = new HasPath();
        boolean hasPath = obj.hasPath(source, rows, cols, target);
        System.out.println("has path = " + hasPath);
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (judge(matrix, i, j, rows, cols, flag, str, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k) {
        int index = cols * i + j;
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index]) {
            return false;
        }
        if (k == str.length - 1) {
            return true;
        }
        flag[index] = true;
        if (judge(matrix, i + 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j + 1, rows, cols, flag, str, k + 1) ||
                judge(matrix, i - 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j - 1, rows, cols, flag, str, k + 1)) {
            return true;
        }
        flag[index] = false;
        return false;
    }
}
