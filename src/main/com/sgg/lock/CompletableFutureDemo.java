package com.sgg.lock;

import java.util.concurrent.CompletableFuture;

/**
 * 1.小白进入餐厅点饭
 * 2.厨师做饭
 * 3.小白打王者
 */
public class CompletableFutureDemo {


    public static void main(String[] args) {
        System.out.println("小白进入餐厅");
        System.out.println("小白点了番茄蛋饭+一碗米饭");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            System.out.println("厨师炒菜");
            try {
                Thread.sleep(200);
                System.out.println("厨师打饭");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "番茄蛋饭+一碗米饭做好了";
        }).thenCompose(dis-> CompletableFuture.supplyAsync(()->{
            return dis+"";
        }));

        System.out.println("小白在打王者");
        System.out.println(String.format("%s,小白开吃",cf1.join()));

    }
}
