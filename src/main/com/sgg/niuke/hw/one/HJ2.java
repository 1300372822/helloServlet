package com.sgg.niuke.hw.one;

import java.util.Scanner;

/**
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 * 输出输入字符串中含有该字符的个数。
 *
 * ABCabc
 * A
 * 2
 */
public class HJ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            String s = in.nextLine();
            char[] chars = str.toCharArray();
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (s.equalsIgnoreCase(String.valueOf(chars[i])))
                    count++;
            }
            System.out.println(count);
        }
    }
}
