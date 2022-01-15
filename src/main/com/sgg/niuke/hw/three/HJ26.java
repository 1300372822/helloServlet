package com.sgg.niuke.hw.three;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * 如，输入： Type 输出： epTy
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * 如，输入： BabA 输出： aABb
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * 如，输入： By?e 输出： Be?y
 */
public class HJ26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(sort(str));
        }
    }
    public static String sort(String str){
        char[] chars = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i]))
            list.add(chars[i]);
        }

        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1)-Character.toLowerCase(o2);
            }
        });
        StringBuffer buffer = new StringBuffer();
        for (int i = 0,j=0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))){
                buffer.append(list.get(j++));
            }else {
                buffer.append(str.charAt(i));
            }
        }
        return buffer.toString();
    }

}
