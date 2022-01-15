package com.sgg.ms;

import com.sgg.niuke.test.TreeUtil;

/**
 * 1.如果一个人在知道了股票每天的股价以后，对该股票进行投资，
 * 问什么时候买入和卖出(注意这里有先后顺序）能取得最大的收益。
 * 其数学模型就是，给定一个整数数组，a[1],a[2],...,a[n]，
 * 每一个元素a[i]可以和它左边（a[i-1],a[i-2],...,a[0]）元素做差，
 * 求这个数组中最大的差值。<br><br>（要求包含unit，test ，testcase）
 */
public class Demo1 {

    public static void main(String[] args) {
        int[] arr = {1,5,8,6,4};
        System.out.println(method(arr));

    }

    public static int method(int[] arr){
        if (arr.length==1)return arr[0];
        int temp=0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int k = arr[i]-arr[j];
                if (k>temp){
                    temp = k;
                }
            }
        }
        return temp;
    }
}
