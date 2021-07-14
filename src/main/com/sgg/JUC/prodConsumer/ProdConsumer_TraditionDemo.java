package com.sgg.JUC.prodConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：一个初始值为0的变量，俩个线程对其交替操作，一个加1 一个减一 来5轮
 * 1.线程  操作（方法）  资源类
 * 2.判断 干活 通知
 * 3. 防止虚假唤醒机制
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Produce").start();
        }
        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "BB").start();
        }
        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "CC").start();
        }

        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "consumer").start();
        }


    }

}
class ShareData{//资源类
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment() throws  Exception{
        lock.lock();
        //1.判断
        while (number!=0){// In other words,
       //waits should always occur in loops  防止虚假唤醒
            //等待，不能生产
            condition.await();
        }
        //2.干活
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3.通知唤醒
        condition.signalAll();
        lock.unlock();

    }

    public void decrement() throws  Exception{
        lock.lock();
        //1.判断
        while (number==0){//多线程用while 不用if
            //等待，不能消费
            condition.await();
        }
        //2.干活
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3.通知唤醒
        condition.signalAll();
        lock.unlock();

    }


}
