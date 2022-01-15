package com.sgg.niuke.test;

/**
 * 统计一个数字在升序数组中出现的次数。
 * [1,2,3,3,3,3,4,5],3
 * 4
 */
public class JZ37 {

    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();
        int[] array = {1,2,3,3,3,3,4,5};
        int i = solution37.GetNumberOfK(array, 3);
        System.out.println(i);
        int i1 = solution37.GetNumberOfK2(array, 3);
        System.out.println(i1);

    }
}

class Solution37 {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==k){
                count++;
            }
            if (array[i]>k)break;
        }
        return count;
    }

    /**
     * 二分法
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK2(int [] array , int k) {
        int lbound = 0;
        int rbound = 0;

        int left = 0;
        int right = array.length;
        //寻找左边界下界
        while (left<right){
            int middle = (left+right)/2;
            if (array[middle]<k){
                left = middle+1;
            }else {
                right = middle;
            }
        }
        lbound = left;
        //寻找有边界上界
        left = 0; right =array.length;
        while (left<right){
            int middle = (left+right)/2;
            if (array[middle]>k){
                right = middle;
            }else {
                left = middle+1;
            }
        }
        rbound = right;

        return rbound-lbound;


    }


}
