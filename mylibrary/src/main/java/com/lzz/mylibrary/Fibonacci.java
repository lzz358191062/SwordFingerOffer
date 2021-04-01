package com.lzz.mylibrary;

/**
 * 求斐波那契数列的第 n 项，n <= 39。
 *
 * @author lzz
 * @time 21-2-2 下午4:45
 */
public class Fibonacci {

    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            System.out.println(getFibonacci(i) + " = " + getFibonacciOther(i));
        }
    }

    private static int getFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }

        return f[n];
    }

    private static int getFibonacciOther(int n) {
        if (n <= 1) {
            return n;
        }
        int pre2 = 0;
        int pre1 = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }

        return result;
    }


}
