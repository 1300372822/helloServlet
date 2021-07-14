package com.sgg.JUC.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemoTimeOut {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        try {
            System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("b",2L, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("c",2L, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("d",2L, TimeUnit.SECONDS));



        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
