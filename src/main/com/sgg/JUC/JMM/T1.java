package com.sgg.JUC.JMM;

public class T1 {

    volatile int n= 0;
    public void add(){

        System.out.println(new T1().n);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (n==0){

        }
        n++;
    }
}
