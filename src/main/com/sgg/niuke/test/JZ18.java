package com.sgg.niuke.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * {8,6,10,5,7,9,11}输入
 * {8,10,6,11,9,7,5}输出
 */
public class JZ18 {

    public static void main(String[] args) {
        TreeNode pRoot = new TreeNode(8);
        TreeNode lRoot1 = new TreeNode(6);
        TreeNode lRoot2 = new TreeNode(5);
        TreeNode lRoot3 = new TreeNode(9);
        TreeNode rRoot1 = new TreeNode(10);
        TreeNode rRoot2 = new TreeNode(7);
        TreeNode rRoot3 = new TreeNode(11);
        pRoot.left = lRoot1;
        pRoot.right = rRoot1;

        lRoot1.left = lRoot2;
        lRoot1.right = rRoot2;

        rRoot1.left = lRoot3;
        rRoot1.right = rRoot3;
        Solution18 solution = new Solution18();
        solution.Mirror(pRoot);

        System.out.println(pRoot);

    }
}

class Solution18 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror(TreeNode pRoot) {
        // write code here
//        TreeNode cur = new TreeNode();
//        pre(pRoot);
        if (pRoot==null) return pRoot;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            System.out.println(pRoot.val);
            TreeNode poll = queue.poll();
            //交换node的俩个子节点
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;
            //节点加入到队列中
            if (poll.left!=null){
                queue.add(poll.left);
            }
            if (poll.right!=null){
                queue.add(poll.right);
            };
        }
        return pRoot;
    }
    public void pre(TreeNode pRoot){
        if (pRoot.left!=null && pRoot.right!=null){
            int temp =0;
            temp = pRoot.left.val;
            pRoot.left.val = pRoot.right.val ;
            pRoot.right.val = temp;
            pre(pRoot.left);
            pre(pRoot.right);
        }
    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
