package com.sgg;

import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str
 * 中的每个非空单词之间存在着双向连接的对应规律。
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 */
public class Test4 {

    public static void main(String[] args) {
        test("abba","");
    }

    public static boolean test(String pattern,String str){
        String[] arr = str.split(" ");

        if (arr.length!=pattern.length())return false;
        for (int i = 0; i < pattern.length()-1; i++) {
            if (pattern.charAt(i)==pattern.charAt(i+1)){

                if (arr[i].equals(arr[i+1])){
                    continue;
                }else {
                    return false;
                }
            }
            if (pattern.charAt(i)!=pattern.charAt(i+1)){
                if (arr[i].equals(arr[i+1])){
                    return false;
                }
            }

        }
        return true;
    }

}
