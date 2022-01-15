package com.sgg.niuke.hw.two;

import java.util.Scanner;

/**
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * 5 2
 */
public class HJ15 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = 0;
        while (num>0){
            if ((num&1)==1) count++;
            num = num>>1;
        }
        System.out.println(count);
    }
}
