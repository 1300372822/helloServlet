package com.sgg.lock;

public class LockSupportDemoException1 {

    static Object objectLock = new Object();
    public static void main(String[] args) {

        new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t"+"------------come in");
                try {
                    objectLock.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"\t"+"------------被唤醒");

        },"A").start();


        new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t"+"------------通知");

                objectLock.notify();

        },"B").start();
    }
}
