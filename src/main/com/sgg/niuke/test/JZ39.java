package com.sgg.niuke.test;

/**
 * 平衡二叉树
 */
public class JZ39 {
    public static void main(String[] args) {

    }
}
class Solution39{
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null)return true;
        int left = depth(root.left);
        int right = depth(root.right);
        boolean flag = true;
        if (left-right>1||left-right<-1)
            flag=false;
        return IsBalanced_Solution(root.right)&&IsBalanced_Solution(root.left)&&flag;
    }

    //dfs计算树的高度
    public int depth(TreeNode root){
        if (root==null)return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }

}
