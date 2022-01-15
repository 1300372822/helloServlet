package com.sgg.niuke.hw.one;

import java.util.*;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 * 9876673
    37689

 *
 */
public class HJ9 {
    public static void main(String[] args) {
        Set set = new TreeSet();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = chars.length-1; i >=0 ; i--) {
            if (!set.contains(chars[i])){
                set.add(chars[i]);
                sb.append(chars[i]);
            }
        }
        Iterator iterator = set.iterator();

        System.out.println(Integer.parseInt(sb.toString()));
    }
}
