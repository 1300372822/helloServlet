package com.sgg.niuke.nc;

import java.util.Arrays;

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * 给定一个整数数组a,同时给定它的大小n和要找的K(1<=K<=n)，请返回第K大的数(包括重复的元素，不用去重)，保证答案存在。
 *[1,3,5,2,2],5,3
 * 2
 *
 * 参考快排的思路
 * 1. 分开之后中枢值所在的位置如果从后面数是第k个，我们直接返回中枢值即可。
 * 2. 如果从后面数大于k，说明要找的值还在后面这部分，我们只需按照同样的方式从后 面部分开始找即可。
 * 3. 如果从后面数小于k，说明要找的值在前面部分，我们同样从前面部分开始查找。
 * */
public class NC88 {

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] arr = {1,3,5,2,2};
        int kth = solution88.findKth(arr, 5, 3);
        System.out.println(kth);
    }
}
class Solution88 {
    public int findKth(int[] a, int n, int K) {
        // write code here

        int i =0;
        int j = n-1;
        int temp = a[0];
        while (i<j){
            while (a[j]>=temp&&i<j){
                j--;
            }
            if (a[j]<temp){//从右到左找比temp小的
                int b = a[i];
                a[i]=a[j];
                a[j] = b;
            }
            while (a[i]<=temp&&i<j){
                i++;
            }
            if (a[i]>temp){//从左向右找比temp大的
                int b = a[j];
                a[j]=a[i];
                a[i] = b;
            }
        }
        if(K==n-i)return a[i];
        if (K<(n-i)){//在右侧
            return findKth(Arrays.copyOfRange(a,i+1,n),n-i-1,K);
        }
        else{//在左侧
            K= K-(n-i);
            int[] ints = Arrays.copyOfRange(a, 0, i);
            return findKth(ints,i,K);
        }

    }
}
