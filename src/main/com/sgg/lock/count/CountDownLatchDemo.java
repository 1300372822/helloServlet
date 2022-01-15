package com.sgg.lock.count;

import java.util.concurrent.CountDownLatch;

/**
 * 秦灭六国 统一华夏
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <7 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 国，被灭");
                countDownLatch.countDown();
            },CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t *************秦帝国，统一华夏");
    }
}
