package com.sgg.niuke.hw;

public class Demo2 {

    public static void main(String[] args) {
        int[] arr = {1,4,3};
        System.out.println(findLackNum(arr));
        System.out.println(findLackNum2(arr,7));
        System.out.println(findLackNum3(arr));
    }

    public static int findLackNum(int[] arr){
        int num =0;
        int num1 = 0;
        for (int i = 0; i < arr.length; i++) {
            num = arr[i]^num;
            num1 = (i+1)^num1;
        }

        num=num^(num1^arr.length+1);
         return num;

    }

    public static int findLackNum2(int[] arr,int n){
        //利用求和的方式 sum2-sum=1
        int num = arr[0];
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        for (int i = 0; i <= n; i++) {
            sum2 =i+sum2;
        }
        return sum2-sum;

    }
    public static int findLackNum3(int[] arr){
        //利用求和的方式 sum2-sum=1
        int res=0;
        for (int i = 0; i < arr.length; i++) {
            res = res+i+1-arr[i];
        }
        return res+ arr.length+1;

    }



}
