package com.sgg.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {

    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
//        conditionAwaitSignal();
//       synchronizedMethod();

//        parkUnpark();
        twoPark();
    }

    public static void parkUnpark() {
        Thread a = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t" + "------------come in");
            LockSupport.park();//被阻塞。。。。等待通知等待放行，他需要许可证
            System.out.println(Thread.currentThread().getName() + "\t" + "------------被唤醒");
        },"a");
        a.start();

        try {
            TimeUnit.SECONDS.sleep(3l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread b = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t" + "------------通知");
            LockSupport.unpark(a);
        });
        b.start();
    }

    public static void twoPark() {



        Thread a = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "------------come in");
            LockSupport.park();//被阻塞。。。。等待通知等待放行，他需要许可证
            LockSupport.park();//俩次park会阻塞

            System.out.println(Thread.currentThread().getName() + "\t" + "------------被唤醒");
        },"a");
        a.start();

        Thread b = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t" + "------------通知");
            LockSupport.unpark(a);
        });
        b.start();
    }

    public static void conditionAwaitSignal() {
        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t" + "----come in");
            try {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "------------被唤醒");
            } finally {
                lock.unlock();
            }
        }, "conditionA").start();
        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t" + "----come in");
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "------------通知");
                condition.signal();

            } finally {
                lock.unlock();
            }
        }, "conditionB").start();


    }

    private static void synchronizedMethod() {
        new Thread(() -> {
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "------------come in");
                try {
                    objectLock.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "\t" + "------------被唤醒");

            }
        }, "A").start();


        new Thread(() -> {
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "------------通知");

                objectLock.notify();
            }

        }, "B").start();
    }


}
