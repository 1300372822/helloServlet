package com.sgg.niuke.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。1<=数组长度<=50000，0<=数组元素<=10000
 *
 * [1,2,3,2,2,2,5,4,2]
 * 2
 */
public class JZ28 {
    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        int[] ints = {1,2,3,2,2,2,5,4,2};
        int i = solution28.MoreThanHalfNum_Solution(ints);
        System.out.println(i);
    }

}
class Solution28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length==1)return array[0];
        int midLength = array.length/2;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                if (map.get(array[i])>=midLength){
                    return array[i];
                }
                map.put(array[i],map.get(array[i])+1);
            }else {
                map.put(array[i],1);
            }
        }
        return -1;
    }
}