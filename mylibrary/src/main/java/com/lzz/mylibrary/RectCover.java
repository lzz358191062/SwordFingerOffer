package com.lzz.mylibrary;

/**
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 * 作者：CyC2018
 * 链接：https://www.nowcoder.com/discuss/198840?type=1
 * 来源：牛客网
 * <p>
 * 要覆盖 2*n 的大矩形，可以先覆盖 2*1 的矩形，再覆盖 2*(n-1) 的矩形；或者先覆盖 2*2 的矩形，再覆盖 2*(n-2) 的矩形。而覆盖 2*(n-1) 和 2*(n-2) 的矩形可以看成子问题。该问题的递推公式如下：
 *
 * @author lzz
 * @time 21-2-5 上午10:45
 */
public class RectCover {
    public static void main(String[] args) {
        RectCover object = new RectCover();


        for (int i = 0; i < 5; i++) {
            System.out.println(" i = " + i + " result = " + object.getRectCover(i));
        }
    }

    public int getRectCover(int n) {
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
}
