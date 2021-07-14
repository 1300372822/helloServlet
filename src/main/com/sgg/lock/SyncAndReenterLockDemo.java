package com.sgg.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁定多个条件condition
 * ReeentrantLock用来实现分组唤醒需要唤醒的线程们，可以精确唤醒，而不是像synchronized要么随机唤醒一个线程要么唤醒全部线程
 * 题目：多线程之间按照顺序调用，实现A->B->C三个线程启动
 * AA打印5次，BB打印10次，CC打印15次
 * 紧接着
 * AA打印5次，BB打印10次，CC打印15次
 * <p>
 * 10轮
 */
class ShareData {
    private int number = 1; //A:1 B:2 C:3
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            //1.判断
            while (number != 1) {
                condition1.await();
            }
            //2.干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3.通知
            number = 2;//修改标志位
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try{
            //1.判断
            while (number!=2){
                condition2.await();
            }
            //2.干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3.通知
            number=3;//修改标志位
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try{
            //1.判断
            while (number!=3){
                condition3.await();
            }
            //2.干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3.通知
            number=1;//修改标志位
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class SyncAndReenterLockDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareData.print5();
            }
        }, "AA").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareData.print10();
            }
        }, "BB").start();

        new Thread(()->{
            for (int i = 0; i < 15; i++) {
                shareData.print15();
            }
        }, "CC").start();
    }
}
