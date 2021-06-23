package com.sgg.niuke.test2;

import java.util.Arrays;

public class DfsTree {

    /**
     *
     * @param pre 先序
     * @param in  中序
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0)return null;
        TreeNode node = new TreeNode(pre[0]);
        createT( pre, in,node);
        return  node;

    }

    public void createT(int [] pre,int [] in,TreeNode treeNode) {
        if(pre.length==0 && in.length==0){
            return;
        }
        int leftlenth=0;

        /*if(in!=null){
            for(int j = 0;j<in.length;++){
                if(in[j]==pre[0])
                    leftlenth=j;
            }
        }*/
        if (in!=null){
            leftlenth = Arrays.binarySearch(in,pre[0]);
        }
        treeNode.val = pre[0];

        if (leftlenth>=1){
            int[] newPre = Arrays.copyOfRange(pre, 1, leftlenth+1);
            int[] newIn = Arrays.copyOfRange(in, 0, leftlenth);

            TreeNode node = new TreeNode(newPre[0]);
            treeNode.left=node;
            createT(newPre,newIn,treeNode.left);
        }

        if (pre.length-leftlenth>=1){
            int[] rightPre = Arrays.copyOfRange(pre, leftlenth+1, pre.length+1);
            int[] riigehtIn = Arrays.copyOfRange(in, leftlenth+1, in.length+1);
            TreeNode node = new TreeNode(rightPre[0]);
            treeNode.right=node;
            createT(rightPre,riigehtIn,treeNode.right);

        }





    }


}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}