package com.sgg.JUC.JMM;

import java.util.concurrent.atomic.AtomicInteger;

public class SeeDemo {

    public static void main(String[] args) {
        Mydata mydata = new Mydata();//
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t"+"修改前number="+mydata.number);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mydata.add();
            System.out.println(Thread.currentThread().getName()+"\t"+"修改后number="+mydata.number);


        },"AAA").start();
        System.out.println(Thread.currentThread().getName()+"\t"+"main number="+mydata.number);

        while(mydata.number==0){

        }
        System.out.println(Thread.currentThread().getName()+"\t"+"main number="+mydata.number);

    }


}
