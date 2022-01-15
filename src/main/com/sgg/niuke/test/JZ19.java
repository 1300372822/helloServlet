package com.sgg.niuke.test;

import java.util.ArrayList;

/**顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * [[1,2],[3,4]]
 * [1,2,4,3]
 */
public class JZ19 {
    public static void main(String[] args) {
//        int[][] arr = {{1,2},{3,4}} ;
        int[][] arr = {{1},{2},{3},{4}} ;

        Solution19 solution19 = new Solution19();
        ArrayList<Integer> list = solution19.printMatrix(arr);
        for (Integer integer : list) {
            System.out.print(integer+"\t");
        }
    }
}
class Solution19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int lenth = matrix.length;

        //获取矩阵的长和宽
        int m = matrix.length;//行数
        int n = matrix[0].length;//列数
        //设定边界
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while (true){
            for (int i = left;i <=right; i++) {//从左到右  行不变，改变列的下标
                list.add(matrix[up][i]);
            }
            if (++up>down){
                break;
            }
            for (int i = up; i <= down; i++) {//从上到下 列不变，改变行的下标
                list.add(matrix[i][right]);
            }
            if (--right<left){
                break;
            }
            for (int i = right; i >=left ; i--) {//从右向左
                list.add(matrix[down][i]);
            }
            if (--down<up){
                break;
            }
            for (int i = down; i >=up ; i--) {//从下到上
                list.add(matrix[i][left]);
            }
            if (++left>right){
                break;
            }
        }

        return list;
    }
}

