package com.sgg.niuke.dongtai;

import java.util.Arrays;

/** 动态规划（边界条件+递推公式）
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *递推公式如下：
 * dp[i][j]=dp[i-1][j]+dp[i][j-1]。
 * dp[i-1][j]表示的是从上面走过来的路径条数。
 * dp[i][j-1]表示的是从左边走过来的路径条数。
 * 边界条件（第一行和第一列都是1）
 * */
public class UniquePath {

    public static void main(String[] args) {
        int i = paths1(5, 3);
        System.out.println(i);
        int j = paths1(1, 1);
        System.out.println(j);
        int i1 = paths2(10, 6);
        int i2 = paths2(5, 3);
        System.out.println(i1);
        System.out.println(i2);
    }
    public static int paths1(int m, int n){
        int[][] dp = new int[m][n];
        //第一列都是1
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        //第一行都是1
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        //递推公式
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    //优化空间
    public static int paths2(int m, int n){
        int[] arr = new int[m];
        Arrays.fill(arr,1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[j] = arr[j]+arr[j-1];
            }
        }
        return arr[m-1];
    }
}
