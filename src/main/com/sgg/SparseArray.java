package com.sgg;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组  11*11
        //0:表示没有棋子，1表示黑子 2表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始二维数组：");
        for (int[] rows : chessArr1) {
            for (int data : rows) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将二维数组转换为稀疏矩阵
        //1.遍历二维数组查询非0个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j]>0){
                    sum++;
                }
            }
        }
        int cheesArr2[][] = new int[sum][3];
        cheesArr2[0][0] = 11;
        cheesArr2[0][1] = 11;
        cheesArr2[0][2] = sum;
        int count =0;
        for (int i = 0; i < 11; i++) {
            for (int j =0;j<11;j++){
                count++;
                cheesArr2[count][0]=i;
                cheesArr2[count][1]=j;
                cheesArr2[count][2]=chessArr1[i][j];
            }
        }


    }
}
