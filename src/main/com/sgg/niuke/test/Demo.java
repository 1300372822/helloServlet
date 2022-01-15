package com.sgg.niuke.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 8, 7, 6, 4, 3,};
        System.out.println(Arrays.toString(arr));
        ArrayList list = new ArrayList();
        list.remove(new Object());
        // 将数组中的元素6删除
        int d = 6;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 6) {
                arr[i] = arr[arr.length - 1];
                arr = Arrays.copyOf(arr, arr.length - 1);
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
