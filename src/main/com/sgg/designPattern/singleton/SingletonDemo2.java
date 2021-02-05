package com.sgg.designPattern.singleton;

public class SingletonDemo2 {

    public static void main(String[] args) {

    }
}

/**
 *
 */
//饿汉式（静态变量）
class Singleton2{
    //1.私有化构造方法，外部不能new
    private Singleton2(){};
    //2.本类内部创建对象实例
    private final static  Singleton2 instance;
    //3.静态代码块中创建单例对象
    static {
        instance = new Singleton2();
    }
    //3.静态方法(提供一个公有的静态方法)
    public static Singleton2 getInstance(){
        return instance;
    }
}
