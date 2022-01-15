package com.sgg.test;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Test1 {

    public static void main(String[] args) {
        int method = method(5);
        System.out.println(method);
    }
    public static int method(int n){
        if (n==1||n==2)return n;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = b;
            b=a+b;
            a=temp;
        }
        return b;
    }

}
