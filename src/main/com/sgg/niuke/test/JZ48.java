package com.sgg.niuke.test;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class JZ48 {

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int add = solution48.Add(3,3);
        System.out.println(add);
    }
}
class Solution48 {
    public int Add(int num1,int num2) {
        int num = num1 | num2;
        return num;
    }
}