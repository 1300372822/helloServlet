package com.sgg.niuke.test;

import java.util.*;
import java.util.stream.Stream;

/**
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * [1,4,1,6]
 * [4,6]
 */
public class JZ40 {

    public static void main(String[] args) {

        int[] ints = {1,4,1,6};
        Solution40 solution40 = new Solution40();
        int[] ints1 = solution40.FindNumsAppearOnce(ints);
        System.out.println(Arrays.toString(ints1));
    }
}
class Solution40 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组 
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce (int[] array) {
        Map<Integer,Integer> map = new HashMap<>();
        // write code here
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
            }else {
                map.put(array[i],1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue()==1){
               list.add(entry.getKey());
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        //Integer[ ]转 int[ ]
//        int[] arr= Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        //将integer数组转换为int
        int[] ints = list.stream().mapToInt(Integer::valueOf).toArray();
        return ints;
    }
}