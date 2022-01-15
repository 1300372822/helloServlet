package com.sgg.niuke.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 0 <= k <= input.length <= 10000
 * 0 <= input[i] <= 10000
 * [4,5,1,6,2,7,3,8],4
 * [1,2,3,4]
 * 0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,
 * 8,22,17,6,22,6,22,26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,
 * 3,52,27,2,23,19,56,56,58,36,31,1,19,19,6,65,49,27,63,29,1,69,47,56,61,
 * 40,43,10,71,60,66,42,44,10,12,83,69,73,2,65,93,92,47,35,39,13,75
 */
public class JZ29 {
    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
//        int[] input = {4,5,1,6,2,7,3,8};
        int[] input = {};
        ArrayList<Integer> list = solution29.GetLeastNumbers_Solution(input, 0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        };
        Arrays.sort(input);
        System.out.println(input.toString());

    }
}

class Solution29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        getList(input,list,k,0,input.length-1);
        return list;
    }
    public void getList(int [] input, ArrayList<Integer> list,int k,int left,int right){
        if (left>right) return;
        int start = left;
        int end = right;
        int value = input[start];
        while (left<right){
            while (left<right&&value<=input[right]){
                right--;
            }
            swap(input,left,right);
            while (left<right&&input[left]<=value){
                left++;
            }
            swap(input,left,right);
        }

        if (k<left){
            getList(input,list,k,start,left-1);
        }else if (k>left+1){

            getList(input,list,k,left+1,end);
        }else {
            for (int i = 0; i < k; i++) {
                list.add(input[i]);
            }
        }


    }

    public void swap(int [] input,int left,int right){
        if (left==right)return;
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}
