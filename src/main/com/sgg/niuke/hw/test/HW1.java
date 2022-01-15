package com.sgg.niuke.hw.test;

import java.util.Arrays;
import java.util.Scanner;

public class HW1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        int num = 0;
        if (arr[0] >= 0) {
            num = arr[0] + arr[1];
            System.out.println(arr[0] + " " + arr[1] + " " + num);
            return;
        }
        if (arr[arr.length - 1] <= 0) {
            num = -(arr[arr.length - 2] + arr[arr.length - 1]);
            System.out.println(arr[arr.length - 2] + " " + arr[arr.length - 1] + " " + num);
            return;
        }
        num = Math.abs(arr[0]) + Math.abs(arr[1]);
        int pre = arr[0];
        int after = arr[1];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum < 0) {
                    sum = -sum;
                }
                if (sum < num) {
                    pre = arr[i];
                    after = arr[j];
                    num = sum;
                }
            }
        }
        System.out.println(pre+" "+after+" "+num);
    }
}
