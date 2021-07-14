package com.sgg.JUC.CAS;


import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

//ABA问题的解决  AtomicStampedReference
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();
        new Thread(()->{
            //暂停线程t2一秒钟，保证上面的线程完成了一次ABA问题
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicReference.compareAndSet(100,2021);
//            System.out.println(atomicReference.get());
        },"t2").start();


        System.out.println("=====================以下是ABA问题的解决=========================");


        new Thread(()->{
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号："+stampedReference.getStamp());

            //暂停线程t3一秒钟，保证上面的线程完成了一次ABA问题
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t第2次版本号："+stampedReference.getStamp());

            System.out.println("第二次修改前的值为: "+stampedReference.getReference());

            boolean b = stampedReference.compareAndSet(101, 100, stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println("第二次修改成功否："+b);
            System.out.println(Thread.currentThread().getName()+"\t第3次版本号："+stampedReference.getStamp());

        },"t3").start();
        new Thread(()->{
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号："+stampedReference.getStamp());

            //暂停线程t2一秒钟，保证上面的线程完成了一次ABA问题
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean rel = stampedReference.compareAndSet(100,2021,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t修改成功否："+rel+"\t值为："+stampedReference.getReference());
        },"t4").start();
    }
}
