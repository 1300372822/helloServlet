package com.sgg.lock.count;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 人到齐了才能开会
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println(Thread.currentThread().getName()+"\t ********召唤神龙");
        });

        for (int i = 0; i < 7; i++) {
            final int temp = i;
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 收集到："+temp+"龙珠");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, String.valueOf(i)).start();
        }

    }
}
