package com.sgg.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        //测试队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show)  : 显示队列");
            System.out.println("e(exit)  : 退出程序");
            System.out.println("a(add)  : 添加数据到队列");
            System.out.println("g(get)  : 从队列取出数据");
            System.out.println("h(head)  : 取出头部数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.printf("请输入一个数据");
                    int a = scanner.nextInt();
                    arrayQueue.addQueue(a);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'h':
                    try {
                       int c =  arrayQueue.getFirstData();
                        System.out.println("队列头的数据为："+c);
                    }catch (Exception e){
                        System.out.printf(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int bb = arrayQueue.getQueue();
                        System.out.println("取出的数据是："+ bb);

                    }catch (Exception e){
                        System.out.printf(e.getMessage());
                    }
                    break;
            }
        }
    }
}

//使用数组模拟队列
class ArrayQueue {
    private int maxSize;   //数组最大容量
    private int front;      //队列头
    private int rear;       //队列尾
    private int[] arr;     //存放数据 模拟队列

    //创建队列的构造方法
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front=-1;    //指向队列头部
        rear=-1;    //队列尾

    }

    //判断队列是否满
    public boolean isFull(){
        return maxSize == rear+1;
//        if (maxSize<rear+1){
//            return false;
//        }
//        return true;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //添加数据到队列
    public void addQueue(int data){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能添加数据");
            return;
        }
        arr[rear+1] = data;
        rear++;
    }
    //获取队列的数据出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，不能获取数据");
        }
        front++;
        int data = arr[front] ;
        return data;
    }
    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("队列空");
            return;
        }
        for (int i = front; i < rear; i++) {
            System.out.println(arr[i+1]);
        }
    }
    //显示队列的头数据，不是取出数据
    public int getFirstData(){
        if(isEmpty()){
            System.out.println("队列空");
            throw new RuntimeException("队列空，不能获取数据");
        }
        return  arr[front+1];
    }
    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }
}
