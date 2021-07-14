package com.sgg.niuke.test2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DfsTree {

    /**
     *
     * @param pre 先序
     * @param in  中序
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0 )return null;

        TreeNode node = new TreeNode(pre[0]);
        //在中序遍历中找到前序的根
        for (int i =0;i<in.length;i++){
            if (in[i]==pre[0]){
                //左子树
                node.left= reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),
                        Arrays.copyOfRange(in,0,i));
                //右子树
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }

        return  node;

    }

    public void createT(int [] pre,int [] in,TreeNode treeNode) {
        System.out.println(pre.length);
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

            leftlenth = Arrays.stream(in).boxed().collect(Collectors.toList()).indexOf(pre[0]);

        }
        treeNode.val = pre[0];
        System.out.println(leftlenth);

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