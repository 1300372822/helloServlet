package com.sgg.JUC.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, String.valueOf(5)).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
//                Thread.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());
                Thread.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, String.valueOf(6)).start();
    }
}
