package com.sgg.lock.fair;

/**
 * 可重入锁（递归锁）
 * 线程可以进入一个他已经拥有着的同步代码块
 *
 *
 * 11	 invoke sendSms
 * 11	 ********invoke sendEmail
 * 12	 invoke sendSms
 * 12	 ********invoke sendEmail
 */
public class LockDemo {
    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"thread1").start();


        new Thread(()->{
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"thread2").start();
    }
    }

class Phone{
    public synchronized void sendSms() throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t invoke sendSms ");
        sendEmail();
    }
    public synchronized void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t ********invoke sendEmail ");
    }
}