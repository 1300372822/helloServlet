package com.sgg.niuke.test;

import java.util.ArrayList;
import java.util.List;

/**
 *  线索二叉树
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 注意:
 * 1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，
 * 树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
 * 2.返回链表中的第一个节点的指针
 * 3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
 * 4.你不用输出或者处理，示例中输出里面的英文，比如"From left to right are:"
 * 这样的，程序会根据你的返回值自动打印输出
 */
public class JZ26 {
    public static void main(String[] args) {
        Integer[] integers = {10, 6, 14, 4, 8, 12, 16};
        TreeNode tree = TreeUtil.createTree(integers);
        Solution26 solution26 = new Solution26();
        TreeNode convert = solution26.Convert(tree);
        System.out.println();
    }
}
class Solution26 {
    //方法1 list保存中序遍历结果
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null) return null;
        List<TreeNode> list = new ArrayList<>();
        inorder(list,pRootOfTree);
        //根据list中元素和树 建立连接
        TreeNode head = list.get(0);
        TreeNode cur = head;
        for (int i = 1; i < list.size(); i++) {
            TreeNode node = list.get(i);
            cur.right = node;
            node.left = cur;
            cur = cur.right;
        }
       return head;
    }
    public void inorder(List<TreeNode> list,TreeNode node){
        if (node==null) return;
        if (node.left!=null){
            inorder(list,node.left);
        }
        list.add(node);
        if (node.right!=null){
            inorder(list,node.right);
        }
    }
    TreeNode pre = null;
    //先遍历右子树
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree==null)return null;
        Convert2(pRootOfTree.right);
        if (pre!=null){
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert2(pRootOfTree.left);
        return pre;
    }

}