package com.sgg.niuke.test;

/**
 *
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为 O(n).
 *
    [1,-2,3,10,-4,7,2,-5]

    输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 */
public class JZ30 {

    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        Solution solution = new Solution();
        int i = solution.FindGreatestSumOfSubArray(arr);
        System.out.println(i);
        int j = solution.FindGreatestSumOfSubArray2(arr);
        System.out.println(j);
    }
}
class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        //转移公式dp[i]=dp[i]+max(dp[i-1],0);
        //边界条件dp[0]=array[0]
        int[] dp = new int[array.length];
        dp[0]=array[0];
        //记录最大值
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i]=array[i]+Math.max(dp[i-1],0);
            max = Math.max(dp[i],max);
        }
        return max;
    }
    //优化空间
    public int FindGreatestSumOfSubArray2(int[] array) {
        //转移公式dp[i]=dp[i]+max(dp[i-1],0);
        //边界条件dp[0]=array[0]

        int temp =array[0];
        //记录最大值
        int max = temp;
        for (int i = 1; i < array.length; i++) {
            temp=array[i]+Math.max(temp,0);
            max = Math.max(temp,max);
        }
        return max;
    }


}