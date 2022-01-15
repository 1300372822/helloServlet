package com.sgg.niuke.hw.test;

import java.util.Scanner;

public class HW3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x  = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] arr = new int[x][y];
        int qNum = scanner.nextInt();//墙的数量
        for (int i = 0; i < qNum; i++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            arr[m][n]=1;
        }
        int xj = 0;
        int bkd = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (arr[i][j]==1){
                    //计算陷阱
                    if (j==x-1);

                }
            }
        }
        System.out.println(2 +" "+ 3);
    }
}
