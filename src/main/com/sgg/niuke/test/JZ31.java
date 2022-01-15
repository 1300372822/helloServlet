package com.sgg.niuke.test;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数
 * 例如，1~13中包含1的数字有1、10、11、12、13因此共出现6次
 */
public class JZ31 {

    public static void main(String[] args) {

    }
}
class Solution31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            for (int j = 0;j<s.length();j++){
                if (s.charAt(j)=='1'){
                    result++;
                }
            }
        }
        return result;
    }
}
