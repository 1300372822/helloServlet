package com.sgg.niuke.test;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * [1,2,3,4,5],[4,3,5,1,2]
 * false
 */
public class JZ21 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,3,5,1,2};
//        int[] b = {4,3,5,2,1};
        Solution21 solution21 = new Solution21();
        boolean b1 = solution21.IsPopOrder(a, b);
        System.out.println(b1);
    }
}
class Solution21 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //将popA放入栈
        for (int i = popA.length-1; i >=0 ; i--) {
            popStack.push(popA[i]);
        }

        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty()){
                int top = popStack.peek();
                if (top== stack.peek()){
                    popStack.pop();
                    stack.pop();
                }else {
                    break;
                }

            }

        }
        if (stack.isEmpty())
        return true;
        return false;
    }
}