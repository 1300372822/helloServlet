package com.sgg.JUC.threadPool;

import java.util.concurrent.*;

/**
 * 获得java获得/使用 java多线程的方式，线程池
 *
 *          Executors.newScheduledThreadPool(10);
 *         Executors.newFixedThreadPool(10);//定长
 *         Executors.newSingleThreadExecutor();//一池单线程
 *         Executors.newCachedThreadPool();//一池可扩展线程
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

//        init();
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
               5,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()); 抛异常RejectedExecutionException
//                new ThreadPoolExecutor.CallerRunsPolicy()); //交给调用线程（main线程）处理，
                new ThreadPoolExecutor.DiscardOldestPolicy()); //，


        try{

            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    public static void init() {
        //        System.out.println(Runtime.getRuntime().availableProcessors());
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个线程

        //模拟10个用户办理业务，每个用户就是一个来自外部的请求线程
        try{

            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                Thread.sleep(200);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
        //关闭
    }
}
