package com.sgg.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEnterLockDemo2 {

    static Lock lock  =  new ReentrantLock();
    public static void main(String[] args) {
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("======外层");
                lock.lock();
                try{
                    System.out.println("======内层");
                }finally {
                    lock.unlock();
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }finally {
                //实现加锁次数和释放锁次数不一样时，容易导致死锁
                lock.unlock();
            }
        },"t1").start();
    }
}
