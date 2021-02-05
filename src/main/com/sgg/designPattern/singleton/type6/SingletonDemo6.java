package com.sgg.designPattern.singleton.type6;

public class SingletonDemo6 {

}
class Singleton{

    private static volatile Singleton singleton;
    private Singleton(){};

    //提供一个静态的公有方法，加入双重检查代码，解决线程安全问题，同时解决懒加载问题
    public static Singleton getInstance(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}