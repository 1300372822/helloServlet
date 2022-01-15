package com.sgg.niuke.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * "ab"  输入
 *["ab","ba"] 输出
 */
public class JZ27 {

    public static void main(String[] args) {
        double a = 25/2;
        System.out.println(a);
    }
}
class Solution2 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(chars[i]);

        }

        return null;
    }

    public void backtrack(char[] chars, String temp, boolean[] visited, Set<String> res){
        //边界条件判断
        if (temp.length() == chars.length){
            res.add(temp);
            return;
        }
        //每一个节点都要从头开始选
        for (int i = 0; i < chars.length; i++) {
            //已经选择过的就不能再选了
            if (visited[i])
                continue;
            visited[i]=true;
            backtrack(chars,temp+chars[i],visited,res);
            visited[i]=false;
//            Arrays.
//            backtrack();

        }
    }
}
