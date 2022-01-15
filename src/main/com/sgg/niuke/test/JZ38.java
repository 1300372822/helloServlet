package com.sgg.niuke.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 输入：{1,2,3,4,5,#,6,#,#,7}
 * 输出 4
 */
public class JZ38 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);

        root5.left = root7;
        root2.left= root4;
        root2.right= root5;
        root3.left = root6;
        root.left = root2;
        root.right = root3;

        Solution38 solution = new Solution38();
        int i = solution.TreeDepth(root);
        System.out.println(i);

    }
}
class Solution38{

    public int TreeDepth(TreeNode root) {
        int depth=0;
        if (root==null)return 0;
        //广度优先遍历树(层次遍历 核心在于记录每一个层次个数)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while (queue.size() != 0) {
            size = queue.size();//存储每一层节点个数
            while (size!=0){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                size--;
            }depth++;
        }
        return depth;
    }

}
