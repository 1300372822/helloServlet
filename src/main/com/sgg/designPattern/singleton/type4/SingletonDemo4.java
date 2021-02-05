package com.sgg.designPattern.singleton.type4;

public class SingletonDemo4 {
}
//懒汉式(线程安全 同步方法)
class Singleton{
    private static Singleton instance;
    private Singleton(){}
    //提供一个静态的公有方法，当使用到该方法时，才去创建instance
    //即懒汉式
    public static synchronized Singleton getInstance(){
        if (instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}