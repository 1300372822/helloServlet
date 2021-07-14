package com.sgg.lock.fair;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockDemo {

    public static void main(String[] args) {


        Lock lock = new ReentrantLock(true);
        lock.lock();
    }
}
