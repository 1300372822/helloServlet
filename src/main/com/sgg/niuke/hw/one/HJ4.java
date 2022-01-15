package com.sgg.niuke.hw.one;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.util.Scanner;

/**
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * <p>
 * abc
 * 123456789
 * <p>
 * abc00000
 * 12345678
 * 90000000
 */
public class HJ4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            if (!str.isEmpty()) {
                int i = str.length() % 8;
                int m = str.length() / 8;

                for (int j = 0; j < m<<3; j = j + 8) {
                    System.out.println(str.substring(j, j + 8));
                }
                if (i != 0) {
                    String substring = "";
                    if (m>0){
                        substring = str.substring(8 * m , str.length());
                    }else {
                        substring = str;
                    }

                    StringBuffer sb = new StringBuffer(substring);
                    for (int j = 0; j < 8 - i; j++) {
                        sb.append(0);
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }
}
