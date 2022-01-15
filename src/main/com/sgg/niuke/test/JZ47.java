package com.sgg.niuke.test;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 示例1
 */
public class JZ47 {

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        int i = solution47.Sum_Solution(5);
        System.out.println(i);
    }
}
class Solution47 {
    int sum = 0;
    public int Sum_Solution(int n) {
        boolean x = n>0 && (sum = Sum_Solution(n-1)+n)>0;
        return sum;

    }
}