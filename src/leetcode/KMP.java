package leetcode;

/**
 * 〈功能概述〉<br>
 *
 * @className: leetcode.KMP
 * @package: PACKAGE_NAME
 * @author: wangtong
 * @date: 1/5/21 2:01 PM
 **/

public class KMP {
    public static int[] getNext(String ps) {

        char[] p = ps.toCharArray();

        int[] next = new int[p.length];

        next[0] = -1;

        int j = 0;

        int k = -1;

        while (j < p.length - 1) {

            if (k == -1 || p[j] == p[k]) {

                next[j++] = k++;

            } else {

                k = next[k];

            }

        }

        return next;

    }

    public static int KMP_1(String ts, String ps) {

        char[] t = ts.toCharArray();

        char[] p = ps.toCharArray();

        int i = 0; // 主串的位置

        int j = 0; // 模式串的位置

        int[] next = getNext(ps);

        while (i < t.length && j < p.length) {

            if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0

                i++;

                j++;

            } else {

                // i不需要回溯了

                // i = i - j + 1;

                j = next[j]; // j回到指定位置

            }

        }

        if (j == p.length) {

            return i - j;

        } else {

            return -1;

        }

    }

    public static void main(String[] args){
        String s = "abcdabcaaa";
        String t = "caa";
        int m = KMP_1(s,t);
    }
}
