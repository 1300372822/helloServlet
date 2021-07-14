package com.sgg.JUC.JMM;

public class SingletoDemo {

    private SingletoDemo(){
        System.out.println(Thread.currentThread().getName()+"\t我是构造方法singleton");
    };
    private volatile static SingletoDemo instance;
    //DCL （Double Check Lock双重检锁）
    public static SingletoDemo getInstance(){
        if (instance==null){
            synchronized (SingletoDemo.class){
                if (instance==null){
                    instance = new SingletoDemo();
                }
            }
        }
        return instance;
    }
}
