package com.sgg.JUC.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.CAS是什么？ ===》compare and swap
 *   比较并交换
 *
 *   ABA问题，只有当线程a读取volatile修饰的变量的时候才会去内存可见，
 */
public class CasDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        System.out.println(atomicInteger.compareAndSet(10,2021)+"\t current data: "+ atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(10,2022)+"\t current data: "+ atomicInteger.get());
        int andIncrement = atomicInteger.getAndIncrement();
        System.out.println(andIncrement);
        System.out.println(atomicInteger);

    }
}
