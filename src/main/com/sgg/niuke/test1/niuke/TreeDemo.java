package com.sgg.niuke.test1.niuke;

import java.util.ArrayList;
import java.util.List;

public class TreeDemo {

    public static void main(String[] args) {
        //给定一串数  {5,3,7,2,4,6,8},3
        //        构建二叉搜索树

        TreeNodeOpe ope = new TreeNodeOpe();
//        {8,6,10,5,7,9,11} {1,#,2,#,3,#,4,#,5},3  {},0
        TreeNode tree = ope.createTree(new int[]{5, 3, 7, 2, 4, 6, 8});
//        TreeNode tree1 = ope.createTree(new int[]{});
        List zx = new ArrayList();
        ope.zx(tree,zx);
//        ope.infixOrder(tree1);
//        System.out.println(ope.aList.get(3-1).val);
        System.out.println(zx.get(2));
        TreeNode tree2 = ope.createTree(new int[]{8,6,10,5,7,9,11});
        ope.infixOrder(tree2, 1);
        System.out.println("node"+ope.node1.val);


    }
}
//定义树数据结构
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class TreeNodeOpe{
    //方法一 借助一颗数组二叉树
    public List<TreeNode> aList = new ArrayList();
    //方法二 借助变量
    public TreeNode node1;
    int count = 0;
    //生成一棵二叉树  将数组转为树
    public TreeNode createTree(int[] arrs){
        TreeNode node = new TreeNode(arrs[0]);
//        for (int i = 0; i < arrs.length; i++) {
//            node.left=new TreeNode(arrs[i+1]);
//            node.right = new TreeNode(arrs[i+2]);
//        }
        node.left=new TreeNode(arrs[1]);
        node.right = new TreeNode(arrs[2]);
        node.left.left=new TreeNode(arrs[3]);
        node.left.right=new TreeNode(arrs[4]);
        node.right.left = new TreeNode(arrs[5]);
        node.right.right = new TreeNode(arrs[6]);
      return node;

    }

    //中序遍历树
    public List zx(TreeNode pRoot,List list){
        if (pRoot.left!=null){
            zx(pRoot.left,list);
        }
       list.add(pRoot.val);
        if (pRoot.right!=null){
            zx(pRoot.right,list);
        }
        return list;
    }

    void infixOrder(TreeNode root){
        if (root.left!=null){
            infixOrder(root.left);
        }
        aList.add(root);
        if (root.right!=null){
            infixOrder(root.right);
        }
    }
    void infixOrder(TreeNode root,int k){
        if (root.left!=null){
            infixOrder(root.left,k);
        }
        count++;
        if (count==k){
            node1 = root;
            return ;
        }
        //当找到第k小元素后就不需要在循环了
        if (node1==null && root.right!=null){
            infixOrder(root.right,k);
        }

    }


}