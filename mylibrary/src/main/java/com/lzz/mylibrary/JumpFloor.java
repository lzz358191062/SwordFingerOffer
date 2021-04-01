package com.lzz.mylibrary;

import java.util.Arrays;

/**
 * 跳台阶
 *
 * @author lzz
 * @time 21-2-5 上午11:17
 */
public class JumpFloor {

    public static void main(String[] args) {
        JumpFloor object = new JumpFloor();
        for (int i = 0; i < 5; i++) {
            System.out.println(" result other = " + object.JumpFloorii(i) + " result my = " + object.JumpFloor(i));
        }
        System.out.println(" JumpFloorII(6)  = " + object.JumpFloorII(3));
        System.out.println(" JumpFloorIII(6)  = " + object.JumpFloorIII(3));
        System.out.println(" JumpFloorIIII(6)  = " + object.JumpFloorIIII(3));
    }

    /**
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * @author lzz
     * @time 21-2-5 上午11:20
     */
    public int JumpFloor(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 2;
        int pre2 = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public int JumpFloorii(int n) {
        if (n <= 2)
            return n;
        int pre2 = 1, pre1 = 2;
        int result = 1;
        for (int i = 2; i < n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

// ----------------------------------------------------------------------------------------------------------------------


    /**
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * @author lzz
     * @time 21-2-5 下午2:34
     */
    public int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

    public int JumpFloorIII(int target) {
        return (int) Math.pow(2, target - 1);
    }

    public int JumpFloorIIII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }
}
