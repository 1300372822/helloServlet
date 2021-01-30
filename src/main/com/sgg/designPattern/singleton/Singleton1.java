package com.sgg.designPattern.singleton;

public class Singleton1 {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        System.out.println(instance==instance1);
        System.out.println("instance.hashCode="+instance.hashCode());
        System.out.println("instance1.hashCode="+instance1.hashCode());
    }
}

//饿汉式（静态变量）
class Singleton{
    //1.私有化构造方法，外部不能new
     private Singleton(){};
    //2.本类内部创建对象实例
    private final static  Singleton instance = new Singleton();
    //3.静态方法(提供一个公有的静态方法)
    public static Singleton getInstance(){
        return instance;
    }
}
