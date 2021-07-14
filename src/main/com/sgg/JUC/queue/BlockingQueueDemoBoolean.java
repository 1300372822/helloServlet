package com.sgg.JUC.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemoBoolean {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("aa"));
        System.out.println(blockingQueue.offer("bb"));
        System.out.println(blockingQueue.offer("cc"));
        System.out.println(blockingQueue.offer("cc"));
        //System.out.println(blockingQueue.add("xx"));// 队列满 抛异常IllegalStateException: Queue full
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());


    }
}
