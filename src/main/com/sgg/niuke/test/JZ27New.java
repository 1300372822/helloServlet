package com.sgg.niuke.test;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列，
 * 你可以以任意顺序返回这个字符串数组。例如输入字符串abc,
 * 则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母
 */
public class JZ27New {
    public static void main(String[] args) {
    Solution27New solution27New = new Solution27New();
        ArrayList<String> abc = solution27New.Permutation("abc");
        System.out.println(Arrays.toString(abc.toArray()));


        ArrayList<String> abc1 = solution27New.per("abc");
        System.out.println(Arrays.toString(abc1.toArray()));
    }
}
class Solution27New {
    public ArrayList<String> per(String str){
        char[] chars = str.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        boolean[] vis = new boolean[chars.length];
        getStr(chars,vis,set,"");
        Object[] objects = set.toArray();
        for (Object object : objects) {
            arrayList.add((String)object);
        }
        return  arrayList;
    }
    public void getStr(char[] chars, boolean[] visited,Set<String> set,String str){
        //边界条件判断，当选择的字符长度等于原字符串长度的时候，说明原字符串的字符都已经选完了
        if (chars.length==str.length()){
            set.add(str);
            return;
        }
        //每一个节点我们都要从头开始选
        for (int i = 0; i < chars.length; i++) {
            //已经选择过的就不能再选了
            if (visited[i]){
                continue;
            }
            //表示选择当前字符
            visited[i] = true;
            str = str+chars[i]; //会产生分支污染
            //把当前字符选择后，到树的下一层继续选
//            getStr(chars,visited,set,str+chars[i]);
            getStr(chars,visited,set,str);
            //递归往回走的时候要撤销选择
            //str = str.substring(0,str.length()-1);
            visited[i]=false;
        }
    }

    public ArrayList<String> Permutation(String str) {
        List<List<String>> lists = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList1 = new ArrayList<>();
       pailie(str,new ArrayList<>(),lists);
        for (int i = 0; i < lists.size(); i++) {
            List<String> list = lists.get(i);
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));
            }
            arrayList.add(sb.toString());
        }
        Set<String> set = new HashSet<>();
        for (String s : arrayList) {
            set.add(s);
        }
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            arrayList1.add(iterator.next());
        }
        return arrayList1;
    }
    public void pailie(String str, ArrayList<String> list, List<List<String>> res){
        if (str.length()==0){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            StringBuffer sb = new StringBuffer();
            String s = sb.append(str.substring(0, i)).append(str.substring(i + 1, str.length())).toString();
            list.add(str.charAt(i)+"");
            pailie(s,list,res);
            list.remove(list.size()-1);//撤销操作
        }
    }

}