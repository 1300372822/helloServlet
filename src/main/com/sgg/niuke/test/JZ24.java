package com.sgg.niuke.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * {10,5,12,4,7},22
 * [[10,5,7],[10,12]]
 */
public class JZ24 {
    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        Integer[] integers = {10,5,12,4,7};
//        Integer[] integers = {10,5,12,4,7};
        TreeNode tree = TreeUtil.createTree(integers);
        solution24.FindPath(tree,15);
    }
}
class Solution24 {
    ArrayList<ArrayList<Integer>> arrayList = new ArrayList();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        findHelper(root,target,new ArrayList<>());
        System.out.println(arrayList.toString());
        return arrayList;
    }
    public void findHelper(TreeNode root,int sum,ArrayList<Integer> list){
        if (root==null)return ;
//            list.add(root.val);
        ArrayList<Integer> subList = new ArrayList<>(list);
        subList.add(new Integer(root.val));
            sum = sum-root.val;
            if (root.left==null&&root.right==null){//说明是叶子节点
                if (sum==0){
                    arrayList.add(subList);
                }
            }

             findHelper(root.left,sum,subList);
             findHelper(root.right,sum,subList);

    }
}