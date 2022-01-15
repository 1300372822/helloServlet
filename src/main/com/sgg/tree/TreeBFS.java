package com.sgg.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {

    public static void treeBFS(TreeNode root){
            if (root==null)return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.println(poll.val);
            //如果左子树不为空就把左子树加入队列
            if (poll.left!=null)
            queue.add(poll.left);
            if (poll.right!=null)
                queue.add(poll.right);

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
