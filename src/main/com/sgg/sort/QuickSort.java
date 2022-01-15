package com.sgg.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        //{-9,78,0,23,-67,70}
//        int[] arr = {-9,78,0,23,-67,70};
        int[] arr = {11,7,9,13,8,21,63,10};
        sort2(arr,0,7);
        System.out.println(Arrays.toString(arr));

    }
    public static void sort(int[] arr,int left ,int right){

        int i = left;
        int j = right;
        int x = arr[left];
        while (i<j){
            while (i<j && arr[j]>x){//从右向左找比x小的
                j--;
            }
            if(i<j){//交换
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j] = temp;
            }
            while (i<j  && arr[i]<x){//从左向右找比x大的
                i++;
            }
            if (i<j){//交换
                int temp  = arr[j];
                arr[j]=arr[i];
                arr[i] = temp;
            }
            //把基准数据给正确位置
        }
        if (i-1>left)sort(arr,left,i-1);
        if (j+1<right)sort(arr,i+1,right);



    }

    public static void sort2(int[] arr,int left ,int right){

        int i = left;
        int j = right;
        int x = arr[left];
        while (i<j){
            while (i<j && arr[j]>x){//从右向左找比x小的
                j--;
            }
            if(i<j){
                arr[i]=arr[j];
            }
            while (i<j  && arr[i]<x){//从左向右找比x大的
                i++;
            }
            if (i<j){
                arr[j]=arr[i];
            }

        }
            arr[i]=x;
            sort(arr,left,i-1);
            sort(arr,i+1,right);
        //把基准数据给正确位置



    }

}
