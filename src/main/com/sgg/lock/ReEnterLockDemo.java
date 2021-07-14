package com.sgg.lock;

/**
 * 可重入锁：可重复可递归调用的锁
 *
 * 在一个Synchorized修饰的方法或代码块的内部
 * 调用本类的的其他synchronized修饰的方法或者代码块时，是永远可以得到的
 */
public class ReEnterLockDemo {

    static Object objectLockA = new Object();
   public static void m1(){
       new Thread(new Runnable() {
           @Override
           public void run() {
               synchronized (objectLockA) {
                   System.out.println(Thread.currentThread().getName() + "\t"+"--------------外层调用");
                   synchronized (objectLockA){
                       System.out.println(Thread.currentThread().getName() + "\t"+"--------------内层调用");
                   }
               }
           }
       },"t1").start();
   }
   public static void m2(){
       new Thread().start();
   };
    public static void main(String[] args) {
m2();
    }
}
