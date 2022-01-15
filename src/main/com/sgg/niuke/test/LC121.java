package com.sgg.niuke.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class LC121 {
    public static void main(String[] args) {
        SolutionLC121 solutionLC121 = new SolutionLC121();
        int[] arr1 = {7,1,5,3,6,4};
//        int[] arr = {2,1};
        int[] arr = {1,4,2};
        int i = solutionLC121.maxProfit(arr);
        int i1 = solutionLC121.maxProfit3(arr1);
        System.out.println(i);
        System.out.println(i1);
    }
}
class SolutionLC121 {
    public int maxProfit(int[] prices) {
        int i=0;
        int j = prices.length-1;
        int left=prices[0];
        int right = prices[1];
        while(j<prices.length-1){
            if(left>prices[++i]&&i<j){
                left = prices[i];
            }
            if(right<prices[++j]&&i<j){
                right =prices[j];
            }
        }
        if (left>right)return 0;
        return right - left;
    }

    //动态规划  双指针
    public int maxProfit2(int[] prices) {
        if (prices.length<=1) return 0;
        int min = prices[0],max=0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }
    public int maxProfit3(int[] prices) {
        if (prices.length<=1) return 0;
        int min = prices[0],max=prices[0];
        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            //找左边最小的和右边最大的保持差值最大
            if (prices[i]<min){
                min = prices[i];
                max = prices[i];
            }
            if ((prices[i]-min)>maxPro)
            {
                max = prices[i];
                maxPro = prices[i]-min;
            }

        }
        return max-min;
    }
    public void test(){
        ArrayList arrayList = new ArrayList();
        arrayList.contains("");
        new HashSet<>().contains("");
    }


}