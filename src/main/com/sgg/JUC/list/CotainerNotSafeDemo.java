package com.sgg.JUC.list;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CotainerNotSafeDemo {

    public static void main(String[] args) {
//        hashsetMethod();
//        Map<String,String> map = new HashMap<>();
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0;i<30;i++){
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }

    }

    public static void hashsetMethod() {
        Set<String> set = new HashSet<>();//hash底层是hashmap
        set.add("aaa");
    }
}
