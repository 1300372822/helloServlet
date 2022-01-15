package com.sgg.niuke.test;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数，并且调用 min函数、push函数 及 pop函数 的时间复杂度都是 O(1)
 * push(value):将value压入栈中
 * pop():弹出栈顶元素
 * top():获取栈顶元素
 * min():获取栈中最小元素
 */
public class JZ20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();

    }

}
 class Solution20 {

    Stack<Integer> stack = new Stack();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int min() {
        int min = stack.get(0);
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i)<min)
                min=stack.get(i);
        }
        return min;
    }

}

/**
 * 当压栈的值小于栈中最小值时，先把最小值入栈，然后再把 需要压栈的值入栈，
 * 最后再更新栈中最小值。如果压栈的值大于栈中最小值的时候，直 接压栈，
 *
 * 出栈的时候如果出栈的值等于最小值，说明最小值已经出栈了，要更 新最小值
 * 6,2,1,4
 */
class Solution202 {
    int min = Integer.MIN_VALUE;
    Stack<Integer> stack = new Stack();
    public void push(int node) {
        //如果小于最小值，更新最小值
        if (node<=min){
            stack.push(min);
            min = node;
        }else {
            stack.push(node);
        }

    }

    public void pop() {
        if (stack.pop()==min){
           min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }

}

/**
 * 双栈解决
 */
class Solution203 {

    Stack<Integer> stack = new Stack();
    Stack<Integer> minStack = new Stack();
    public void push(int node) {
        //如果小于最小值，更新最小值
        if (stack.isEmpty()|| node<=minStack.peek()){
            stack.push(node);
            minStack.push(node);
        }else {
            stack.push(node);
        }

    }

    public void pop() {
        if (stack.pop()==minStack.peek()){
           minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}

