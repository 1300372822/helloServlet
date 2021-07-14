package com.sgg.JUC.aqs;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AQSDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        //带入一个银行办理业务的案例来模拟我们的AQS如何进行线程的和通知唤醒机制
        //3个线程模拟3个来银行网点，受理窗口办理业务的顾客
        //A 顾客就是第一个客户
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("------------- A come in");
                TimeUnit.SECONDS.sleep(20);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "A").start();
        //第二个顾客，第二个线程-----》由于受理业务的窗口只有一个（只能一个线程持有锁），此时B只能等待
        //进入候客区
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("------------- B come in");
                TimeUnit.SECONDS.sleep(20);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "B").start();






    }
}
