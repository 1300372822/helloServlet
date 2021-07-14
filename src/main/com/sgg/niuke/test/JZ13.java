package com.sgg.niuke.test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class JZ13 {
    public static int[] reOrderArray (int[] array) {
        // write code here
        Queue<Integer> oddQueue = new LinkedList<Integer>();//奇数队列
        Queue<Integer> evenQueue = new LinkedList<Integer>();//偶数队列
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==0){
                evenQueue.add(array[i]);
            }else {
                oddQueue.add(array[i]);
            }
        }
        int[] newArr = new int[array.length];
        List<Integer> list = new ArrayList();
        while (!oddQueue.isEmpty()){
            list.add(oddQueue.poll());
        }
        while (!evenQueue.isEmpty()){
            list.add(evenQueue.poll());
        }
        Object[] objects = list.toArray();
        Integer[] integers = new Integer[array.length];
        for (int i = 0; i < objects.length; i++) {
            integers[i] = (Integer) objects[i];
        }
        int[] x = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        return x;
    }

    public static int[] reOrderArray2 (int[] array) {
        // write code here
        Queue<Integer> oddQueue = new LinkedList<Integer>();//奇数队列
        Queue<Integer> evenQueue = new LinkedList<Integer>();//偶数队列
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==0){
                evenQueue.add(array[i]);
            }else {
                oddQueue.add(array[i]);
            }
        }
        int[] newArr = new int[array.length];
        List<Integer> list = new ArrayList();

        for (int i=0;i<array.length;i++){
            if (!oddQueue.isEmpty()){
                array[i]=oddQueue.poll();
            }else {
                array[i]=evenQueue.poll();
            }
        }

        return array;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] ints = reOrderArray(arr);
        System.out.println();
        System.out.println("----------------------");
    }
}
