package com.lzz.mylibrary;

/**
 * 将一个字符串中的空格替换成 "%20"。
 * <p>
 * Input:
 * "A B"
 * <p>
 * Output:
 * "A%20B"
 *
 * @author lzz
 * @time 21-1-26 下午2:09
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String str = "A B C";
        System.out.println(str);
        System.out.println(replaceSpace(new StringBuffer(str)));
    }

    public static String replaceSpace(StringBuffer str) {
        int p1 = str.length() - 1;
        for (int i = 0; i < p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int p2 = str.length() - 1;
        while (p1 > 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }
}
