package com.sgg.lock.readWrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 缓存 读 写 清空
 */
class MyCache{//资源类

    private volatile Map<String,Object> map = new HashMap<>();
    private Lock lock  = new ReentrantLock();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    /**
     *   存在问题 写操作：原子+独占  整个过程必须是一个完整的统一体 写操作不能被打断，写完前 别的线程不能读取。
     * @param key
     * @param value
     * @throws InterruptedException
     */
    public void put(String key,Object value) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"\t 正在写入："+key);
        Thread.sleep(300);
        map.put(key,value);

        System.out.println(Thread.currentThread().getName()+"\t 写入完成："+key);

    }
    public Object get(String key){
        System.out.println(Thread.currentThread().getName()+"\t 正在读取：");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object result =  map.get(key);
        System.out.println(Thread.currentThread().getName()+"\t 读取完成："+result);
        return result;
    }

    public void putLock(String key,Object value) throws InterruptedException {
        try {
        reentrantReadWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+"\t 正在写入："+key);
            Thread.sleep(300);
            map.put(key,value);

            System.out.println(Thread.currentThread().getName()+"\t 写入完成："+key);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }
    public Object getLock(String key){
        try {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"\t 正在读取：");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result =  map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成："+result);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }
        return null;
    }


}
/**
 * 读写锁
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行
 * 如果有一个线程想要去写共享资源类，就不应该有其他线程可以对该资源进行读或写
 *
 * 小总结：
 *    读-读能共存
 *    读-写不能共存
 *    写-写不能共存
 *
 *    写操作：原子+独占  整个过程必须是一个完整的统一体 写操作不能被打断，写完前 别的线程不能读取。
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i <5 ; i++) {
            final int tempInt = i;
            new Thread(()->{
                try {
                    myCache.putLock(tempInt+"",tempInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

        for (int i = 0; i <5 ; i++) {
            final int tempInt = i;
            new Thread(()->{
//                myCache.get(tempInt+"");
                myCache.getLock(tempInt+"");
            },String.valueOf(i)).start();
        }

    }
}


