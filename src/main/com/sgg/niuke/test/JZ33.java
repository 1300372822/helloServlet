package com.sgg.niuke.test;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
 */
public class JZ33 {

    public static void main(String[] args) {

    }
}
class Solution33 {
    public int GetUglyNumber_Solution(int index) {
        int[] arrays = new int[index];
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            int j = i;
            while (j>0){
                j=j%2;
            }
            while (j>0){
//                j=j
            }
            if (i%2==0){

            }
        }
        return 0;
    }
}