package com.sgg.niuke.hw.two;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 给定n个字符串，请对n个字符串按照字典序排列。
 */
public class HJ14 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        String[] arr = new String[count];
        for (int i = 0; i < count; i++) {
            String str = in.next();
            arr[i] = str;
        }
        Arrays.sort(arr);
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
