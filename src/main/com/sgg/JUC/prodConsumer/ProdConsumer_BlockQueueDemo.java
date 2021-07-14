package com.sgg.JUC.prodConsumer;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{
    private volatile boolean FLAG = true; //默认开启，进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void  myProd() throws Exception{
        String data = null;
        boolean retValue;
        while (FLAG){
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");

            }

            Thread.sleep(1000);
        }

        System.out.println(Thread.currentThread().getName()+"\t 大老板叫停，表示FLAG=FALSE 停止生产");
    }
    public void myConsumer() throws Exception{
        String result = "";
        while (FLAG){
           result =  blockingQueue.poll(2L,TimeUnit.SECONDS);

           if (null==result || result.equals("")){
               FLAG = false;
               System.out.println(Thread.currentThread().getName()+"\t 超过2秒中没有取到蛋糕，消费推出");
               System.out.println();
               System.out.println();
               return;
           }
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+result+"成功");
        }

    }

    public void stop() throws Exception{
        this.FLAG = false;
    }
}
/**
 *
 *volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
 */
public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "consumer").start();
        //暂停一会线程
        TimeUnit.SECONDS.sleep(5);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒钟时间到，大老板main线程叫停 活动结束");

        myResource.stop();

    }
}
