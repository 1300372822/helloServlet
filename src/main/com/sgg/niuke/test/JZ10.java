package com.sgg.niuke.test;

public class JZ10 {

    public static int rectCover1(int target) {
        if (target==1 || target == 2) return target;
        return rectCover1(target-1)+rectCover1(target-2);
    }
    public static int rectCover2(int target) {
        int[] arr = new int[target+1];
        if (target<=2)return target;
        arr[0]=0;arr[1]=1;arr[2]=2;
        for (int i = 3; i <=target; i++) {
            arr[i] = arr[i-1]+arr[i-2];
         }
        return arr[target];
    }
    public static int rectCover3(int target) {
        if (target<=2)return target;
        int a=1;
        int b = 2;
        for (int i = 3; i <=target; i++) {
            b=a+b;
            a =b-a;

        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(rectCover1(6));;
        System.out.println(rectCover2(6));;
        System.out.println(rectCover3(6));;
    }
}
