package com.sgg.niuke.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 构建二叉树
 */
public class TreeUtil {
    public static TreeNode createTree(Integer[] array){
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        //利用队列构建二叉树
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (++index<array.length&&array[index]!=null){
                node.left=new TreeNode(array[index]);
                queue.add(node.left);
            }
            if (++index<array.length&&array[index]!=null){
                node.right = new TreeNode(array[index]);
                queue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {

//将int数组转换为Integer数组
        int[] nums = {1,2,3};
//先将int数组转换为数值流
        IntStream stream = Arrays.stream(nums);
//流中的元素全部装箱，转换为流 ---->int转为Integer
        Stream<Integer> integerStream = stream.boxed();
//将流转换为数组
        Integer[] integers = integerStream.toArray(Integer[]::new);
        Integer[] arr= {4,8,6,12,16,14,10};
        TreeNode tree = createTree(arr);
        System.out.println("");

    }
}
