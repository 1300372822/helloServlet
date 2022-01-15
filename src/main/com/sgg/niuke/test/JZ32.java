package com.sgg.niuke.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class JZ32 {
    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
//        int[] numbers = {3,32,321};
        int[] numbers = {};
        String s = solution32.PrintMinNumber(numbers);
        System.out.println(s);
    }
}
class Solution32 {
    public String PrintMinNumber(int [] numbers) {

        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            count +=(numbers[i]+"").length();
        }
        boolean[] visit = new boolean[numbers.length];
        Integer temp = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MAX_VALUE);
        getStr(list,"",count,numbers,visit);
        if (list.get(0)==null)return "";
        return list.get(0)+"";
    }

    public void getStr(List<Integer> list, String str, int length, int[] numbers, boolean[] visit){
        if(numbers.length==0){
            list.set(0,null);
            return;
        }
        if (length==str.length()){
            //终止条件
            if (list.get(0)>Integer.valueOf(str))
            list.set(0,Integer.valueOf(str));
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            //递归
            getStr(list,str+numbers[i],length,numbers,visit);
            //撤销选择
            visit[i] = false;
        }

    }
}