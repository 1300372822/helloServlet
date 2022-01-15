package com.sgg.niuke.hw.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*        编写一个函数，计算字符串中含有的不同字符的个数。
        字符在ASCII码范围内(0~127，包括0和127)，换行表示结束符，不算在字符里。
        不在范围内的不作统计。多个相同的字符只计算一次
        例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。

        abc
        3
        */
public class HJ10 {

    public static void main(String[] args) {
        Map map = new HashMap();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])){
                map.put(chars[i],"");
                count++;
            }
        }
        System.out.println(count);
    }
}
