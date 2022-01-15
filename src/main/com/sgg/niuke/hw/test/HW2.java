package com.sgg.niuke.hw.test;

import java.util.*;

public class HW2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] s = str.split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i <arr.length ; i++) {
           arr[i] = Integer.parseInt(s[i]);
        }
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        List<Integer> list = new ArrayList();//存第一个list每个数出现的次数
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer value = entry.getValue();
            list.add(value);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        int mostValue = list.get(list.size()-1);//众数出现的次数
        List<Integer> newList = new ArrayList();//新的list
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer value = entry.getValue();
            if (value == mostValue){
                for (int i = 0; i < mostValue; i++) {
                    newList.add(entry.getKey());
                }

            }
        }

        newList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        if (newList.size()%2==0){
            int i = newList.size()/2;
            int num = newList.get(i)+newList.get(i-1);
            System.out.println(num/2);
        }else {
            System.out.println(newList.get(newList.size()/2));
        }

    }
}
