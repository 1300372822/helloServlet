package com.sgg.niuke.hw.three;

import java.util.*;

/**
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，
 * 则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 */
public class HJ23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int count =1;
                if (map.containsKey(c)){
                    count = map.get(c)+1;
                }
                map.put(c,count);
            }
            Set<Map.Entry<Character,Integer>> set = map.entrySet();
            StringBuffer sb = new StringBuffer();
            int index=0;
            int[] arr = new int[map.size()];
            for (Map.Entry<Character, Integer> entrySet : set) {
                //排序数组
                arr[index] = entrySet.getValue();
                index++;
            }
            Arrays.sort(arr);
            for (Map.Entry<Character, Integer> entrySet : set) {
               if (entrySet.getValue()==arr[0]) {
                   //找出最小的count
                   sb.append(entrySet.getKey());
               }
            }
            String sbStr = sb.toString();
            for (int i = 0; i < sbStr.length(); i++) {
                str = str.replaceAll(String.valueOf(sb.charAt(i)), "");
            }

            System.out.println(str);
        }

    }
}
