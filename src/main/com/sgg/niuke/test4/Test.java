package com.sgg.niuke.test4;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * 前序遍历  中序遍历  确定一颗二叉树
 */
public class Test {
    
    public static void main(String[] args) {

    }
    
    
    public static TreeNode getTree(int[] pre, int[] middle) {
        int index = 0;
        for (int i = 0; i < pre.length; i++) {
            
        }
        return null;
    }
    public static TreeNode build(int preStart,int inStart ,int[] pre, int[] middle){
        if (preStart>pre.length||inStart>middle.length)
            return null;
        int index = 0;
        for (int i = 0; i < pre.length; i++) {
            if (pre[index]==middle[i]){
                index = i;
                break;
            }
        }

        return null;
    }
}
