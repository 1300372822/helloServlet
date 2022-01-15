package com.sgg.niuke.test;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜索树）
 * [4,8,6,12,16,14,10]
 * true
 */
public class JZ23 {
    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
//        int[] arr = {4,8,6,12,16,14,10};
//        int[] arr = {4,6,7,5};
//        int[] arr = {7,4,6,5};
//        int[] arr = {6,7};
        int[] arr = {};
        boolean b = solution23.VerifySquenceOfBST(arr);
        System.out.println(b);
    }
}
class Solution23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0)return false;
        if (sequence.length==1)return true;
        int rootValue = sequence[sequence.length-1];//根节点值
        int index = 0;//右子树下标
        for (int i = 0; i < sequence.length-1; i++) {
            if (sequence[i]>rootValue){//说明是右子树 找到第一个比根节点大的
                 index= i;
                break;
            }
        }
        if (index==0){
            //说明是左子树
        }
        for (int i = 0; i < index; i++) {
            if (sequence[i]>rootValue){
                return false;
            }
        }
        if (sequence[index]>rootValue){
            //防止index=0的情况 {6，7}
            //右子树存在时
            for (int i = index; i < sequence.length-1; i++) {
                //遍历右子树
                if (sequence[i] < rootValue) {
                    return false;
                }
            }
        }


        //递归左子树右子树
        return VerifySquenceOfBST(Arrays.copyOf(sequence,index+1))
                &&VerifySquenceOfBST(Arrays.copyOfRange(sequence,index,sequence.length-1));
    }

    public boolean helper(int [] sequence){
        return true;
    }
}
