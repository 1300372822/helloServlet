package com.sgg.niuke.hw.one;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，
 * 他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，
 * 把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
 * 按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作
 * (同一个测试用例里可能会有多组数据(用于不同的调查)，希望大家能正确处理)。
 */
public class HJ3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()){
            int num = in.nextInt();//获取个数
            TreeSet set = new TreeSet();
            for (int i = 0; i < num; i++) {
                set.add(in.nextInt());
            }

            Iterator iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }

        }
    }
}
