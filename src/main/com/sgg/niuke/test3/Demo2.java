package com.sgg.niuke.test3;


/**
 * 一个很大的数字数组，怎么快速找到这个数组的中位数
 */
public class Demo2 {

    public static void main(String[] args) {
        int[] arr = {10,8,45,96,12};
        int[] arr2 = {15,8,45,96,12,16,17};
        int[] arr3 = {15,8,45,96,12,16};
//        int middleLeft = getMiddle(arr3,arr3.length/2-1,0,arr3.length-1);
//        int middleRight = getMiddle(arr3,arr3.length/2,0,arr3.length-1);
//        int middle = getMiddle(arr, arr.length / 2, 0, arr.length - 1);
        int middle2 = getMiddle(arr2, arr2.length / 2, 0, arr2.length - 1);

//        System.out.println(middle);
        System.out.println(middle2);
//        System.out.println((middleLeft+middleRight)/2);
    }
    public static int getMiddle(int[] arr,int middle,int left,int right){

        int start = left;
        int end = right;
        int temp = arr[start];
        while (left<right){
            while (arr[right]>temp&&left<right){
                right -- ;
            }
            int a = arr[right];
            arr[right] = temp;
            arr[left] = a;
            while (arr[left]<temp&&left<right){
                left++;
            }
            int b = arr[left];
            arr[left] = temp;
            arr[right] = b;
        }
        if (middle==left){
            return temp;
        }
        if (middle>left){
            //中位数在右侧
            return getMiddle(arr,middle,left+1,end);
        }else {
            //中位数在左侧
           return getMiddle(arr,middle,start,left-1);
        }

    }


}
