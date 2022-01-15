package com.sgg.niuke.test;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 9
 * [[2,3,4],[4,5]]  双指针
 */
public class JZ41 {
    public static void main(String[] args) {

    }
}
class Solution41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int middle = sum/2+1;
        if (middle>0){
            for (int i = 0; i < middle; i++) {
                ArrayList<Integer> childList = new ArrayList<>();
                for (int j = 0; j < 1; j++) {

                }
            }
        }
        return null;
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int middle = sum/2+1;
        int left=0;
        int right = 0;
        if (middle>0){
            for (int i = 0; i < middle; i++) {
                ArrayList<Integer> childList = new ArrayList<>();
                for (int j = 0; j < 1; j++) {

                }
            }
        }
        return null;
    }
}