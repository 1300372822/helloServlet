package com.sgg.JUC.thread;

import java.util.concurrent.*;

/**
 * java多线程中，第三种获得多线程的方式
 */
class MyThread implements Runnable{

    @Override
    public void run() {

    }
}

class Mythread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {

        System.out.println(Thread.currentThread().getName()+"\t come in");
        return 1024;
    }
}
public class CallableDemo {

    public static void main(String[] args) {

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Mythread2());
        Thread thread = new Thread(futureTask,"AAA");
        Thread thread2 = new Thread(futureTask,"VVV");
        thread.start();
        thread2.start();

        int result01 = 100;
        try {
            //futureTask.get() 要求获得callable线程的计算结果，如果没有计算完成就要去强求
            int result =  futureTask.get()+result01;
            System.out.println("*****************  result: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
