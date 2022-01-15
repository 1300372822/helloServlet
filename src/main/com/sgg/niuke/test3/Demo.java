package com.sgg.niuke.test3;

/**
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Demo {

    public static void main(String[] args) {
        long i = method(100);
        System.out.println(i);
    }

    public static long method(int n){
        if (n==1||n==2) return n;
        long a = 1;
        long b = 2;
        for (int i = 3; i <=n; i++) {
            long temp = b;
            b=a+b;
            a = temp;
        }
        return b;
    }
}
