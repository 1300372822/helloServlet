package com.sgg.niuke.test2;

public class TreeTest {
    public static void main(String[] args) {
        int[] att1 = {1,2,4,7,3,5,6,8};
        int[] att2 = {4,7,2,1,5,3,8,6};

        DfsTree dfsTree = new DfsTree();
        TreeNode node = dfsTree.reConstructBinaryTree(att1, att2);
        System.out.println("5444");
    }
}
