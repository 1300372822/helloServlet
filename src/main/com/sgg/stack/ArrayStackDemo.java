package com.sgg.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        //先创建一个ArrayStack对象表示栈
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈（入栈）");
            System.out.println("pop:表示从栈取出数据");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.printf("请输入一个数：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int a = arrayStack.pop();
                        System.out.printf("出栈的数据是："+a);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        }
    }
}
//定义一个ArrayStack 表示栈
class ArrayStack{
    private int maxSize;    //栈的大小
    private int[] stack;    //数组，数组模拟栈
    private int top = -1;   //top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈- push
    public void push(int value){
        if(isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈- pop
    public int pop(){
        //先判断栈是否空
        if(isEmpty()){
            //抛出异常
            throw  new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //显示栈的情况 (遍历栈)
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，没有数据");
           return;
        }
        //
        int i = top;
        while (true){
            if (i<0){
                break;
            }
            int value = stack[i];

            System.out.println(value);
            i--;
        }
    }

}