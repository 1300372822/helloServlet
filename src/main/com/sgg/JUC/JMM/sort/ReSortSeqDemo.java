package com.sgg.JUC.JMM.sort;

public class ReSortSeqDemo {

    int a =  0;
    boolean flag = false;
    //多线程环境中线程交替执行，由于编译器优化重排的存在
    //俩个线程中使用的变量能否保证一致性是无法确定的，结果无法预测
    public void writeMethod(){
        a=2;
        flag = true;
    }

    public void witer2(){
        if (flag){
            a = a+5;
            System.out.println("********retValue: "+a);
        }
    }
}
