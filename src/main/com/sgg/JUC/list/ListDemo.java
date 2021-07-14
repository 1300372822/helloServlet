package com.sgg.JUC.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * 集合类不安全问题
 */
public class ListDemo {


    public static void main(String[] args) {
        //ConcurrentModificationException
//        arrayListMethod();
//        collectionMethod();
        copyOnwriteMethod();
        /**
         * 1.故障现象
         *     java.util.ConcurrentModificationException
         * 2.导致原因
         *   并发争抢修改导致
         * 3.解决方案
         * 3.1 new Vector()
         * 3.2 Collections.synchronizedList(new ArrayList<>());
         * 3.3 new CopyOnWriteArrayList<>();
         * 4.优化建议（同样的错误不超过俩次）
         */
    }

    /**
     * 方案一
     */
    public static void arrayListMethod() {

        List<String> list = new ArrayList<String>();
        List<String> safeList = new Vector<>();
//        list.add(new Object());
        for (int i=0;i<30;i++){
            new Thread(()->{
//             list.add(UUID.randomUUID().toString().substring(0,8));不安全
             safeList.add(UUID.randomUUID().toString().substring(0,8));
              System.out.println(list);
            },i+"").start();
        }
    }

    /**
     * 方案二
     */
    public static void collectionMethod(){
        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        list.add(new Object());
        for (int i=0;i<30;i++){
            new Thread(()->{
             list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },i+"").start();
        }
    }

    /**
     * 方案三
     * 写时复制
     * 读写分离的思想
     */
    public static void copyOnwriteMethod(){
        List<String> list = new CopyOnWriteArrayList<>();
//        list.add(new Object());
        for (int i=0;i<30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },i+"").start();
        }
    }


    /*

    复制出一个新的容器Object[] newElements,然后新的容器Object[] newElements里添加元素，添加完元素之后，再将原容器的引用指向
    新的容器setArray(newElements);这样做的好处是可以对copyOnwirte容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。
    所以CopyOnwrite容器也是一种读写分离的思想，读和写不同的容器
    public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();
        }
    }*/
}
