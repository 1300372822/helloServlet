package com.sgg.niuke.test;

import com.sgg.set.HashSetDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 *
 * "google"
 * 4
 */
public class JZ34 {

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int google = solution34.FirstNotRepeatingChar("google");
        System.out.println(google);
    }
}
class Solution34 {
    public int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),-2);
            }else {
                map.put(str.charAt(i),i);
            }
        }
        int x =Integer.MAX_VALUE;
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue()>=0){
                if (x>entry.getValue()){
                    x = entry.getValue();
                }
            };
        }
        if (x==Integer.MAX_VALUE)
            x=-1;

        return x;
    }
    //方法2 使用函数
    public int FirstNotRepeatingChar2(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i))==str.lastIndexOf(str.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}