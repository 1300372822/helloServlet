package com.sgg.lock.count;

public class ThreadDemo {

    public static void main(String[] args) {
        thredMe();
    }

    public static void thredMe(){
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t  线程");
        }).start();

    }
}
