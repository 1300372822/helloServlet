package com.sgg.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先需要创建一个二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3  = new HeroNode(3,"卢俊义");
        HeroNode node4  = new HeroNode(4,"林冲");
        //手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        binaryTree.setRoot(root);
        System.out.println("前序遍历");
        binaryTree.preOrder();
    }
}
class BinaryTree{
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }
    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
}
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public HeroNode(int no,String name){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //编写前序遍历的方法
    public void preOrder(){
        System.out.println(this.name);
        //递归遍历左子树
        if(this.left!=null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    //编写中序遍历的方法
    public void infixOrder(){
        //递归左子树遍历
        if (this.left!=null){
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
    //编写后序遍历的方法
    public void postOrder(){
        if (this.left!=null){
            this.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
}