package com.sgg.niuke.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * {5,4,#,3,#,2,#,1}
 * [5,4,3,2,1]
 */
public class JZ22 {

    public static void main(String[] args) {

    }
}
class Solution22 {
    ArrayList<Integer> arrayList = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root!=null)return new ArrayList<>(0);
        queue.add(root);//根节点入队
        while (queue.size()>0){
            TreeNode node = queue.poll();
            arrayList.add(node.val);
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null){
                queue.add(node.right);
            }
        }


        return arrayList;
    }
}