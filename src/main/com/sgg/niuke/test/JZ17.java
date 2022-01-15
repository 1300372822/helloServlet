package com.sgg.niuke.test;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * {8,8,#,9,#,2,#,5},{8,9,#,2}
 * true
 */
public class JZ17 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode root2 = new TreeNode(8);
        TreeNode root3 = new TreeNode(9);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(5);
        root1.left=root2;
        root2.left = root3;
        root3.left = root4;
        root4.left = root5;

        TreeNode B1 = new TreeNode(8);
        TreeNode B2 = new TreeNode(9);
        TreeNode B3 = new TreeNode(2);
        B1.left = B2;
        B2.left = B3;

        Solution17 solution17 = new Solution17();
        boolean b = solution17.HasSubtree(root1, B1);
        System.out.println(b);

    }
}
class Solution17{
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2==null||root1==null)
            return false;
        //先从根节点判断root2是不是root1的子结构，如果不是分别从俩个子树判断
        return  isSub(root1,root2)
                ||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);

    }

    public boolean isSub(TreeNode root1,TreeNode root2) {
        //如果子树遍历完了，说明是子结构
        if (root2==null)
            return true;
        //俩个节点不相等
        if (root1==null || root1.val!=root2.val){
            return false;
        }
        return isSub(root1.left,root2.left)&&isSub(root1.right,root2.right);


    }

}
