package com.sgg.niuke.hw.two;

import java.util.Scanner;

/**
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * 1516000
   0006151

 */
public class HJ11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        String s = Integer.valueOf(i).toString();
        StringBuffer sb = new StringBuffer();
        for (int j = s.length()-1; j >=0 ; j--) {
            sb.append(s.charAt(j));
        }
        System.out.println(sb.toString());
    }
}
