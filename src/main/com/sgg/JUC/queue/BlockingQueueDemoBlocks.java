package com.sgg.JUC.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemoBlocks {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        try {
            blockingQueue.put("aa");
            blockingQueue.put("bb");
            blockingQueue.put("cc");
            System.out.println("================");
            blockingQueue.put("adsada");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //System.out.println(blockingQueue.add("xx"));// 队列满 抛异常IllegalStateException: Queue full

    }
}
