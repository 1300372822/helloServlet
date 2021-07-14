package com.sgg.JUC.queue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * ArrayBlockingQueue 是一个基于数组结构的有界阻塞队列，此队列FIFO（先进先出）原则对元素进行排序
 *
 * LinkedBlockingQueue 一个基于链表结构的阻塞队列，此队列按FIFO（先进先出）排序元素，吞吐量高于ArrayBlockingQueue
 *
 * SynchronousQueue  一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入一直处于阻塞状态，
 *
 * 1.队列
 * 2.阻塞队列
 *  2.1 阻塞队列有没有好的一面
 *  2.2 不得不阻塞，你如何管理
 *  
 * 3.
 */
public class BlockingQueueDemoException {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("aa"));
        System.out.println(blockingQueue.add("bb"));
        System.out.println(blockingQueue.add("cc"));
        //System.out.println(blockingQueue.add("xx"));// 队列满 抛异常IllegalStateException: Queue full
        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());

    }
}
