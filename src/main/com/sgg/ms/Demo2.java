package com.sgg.ms;

/**
 * 2.给定一个只包含 '(' 和 ')' 的字符串，
 * 找出最长的包含有效括号的子串的长度。（要求包含unit，test ，testcase）
 * 例如：输入："()(())"       输出：6
 */
public class Demo2 {

    public static void main(String[] args) {

    }
    public static int subStrLength(String str){
        char[] chars = str.toCharArray();
        int[] arr = new int[chars.length];
        int index = str.indexOf("(");
        int p =0;
        int e = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==')'){
                p = i-arr[i-1]-1;
                if (p>=0 && chars[p]=='('){
                    arr[i] = arr[i-1]/2;
                }
            }
        }

        return 0;
    }
}
