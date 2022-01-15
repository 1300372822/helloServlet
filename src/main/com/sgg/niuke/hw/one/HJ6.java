package com.sgg.niuke.hw.one;

import java.util.Scanner;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 */
public class HJ6 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long l = in.nextLong();
        long k =(long)Math.sqrt(l);
        for (long i = 2; i <= k; i++) {
            while (l%i==0){
                System.out.print(i+" ");
                l = l/i;
            }
        }
        System.out.println(l==1?"":l);
    }
}
