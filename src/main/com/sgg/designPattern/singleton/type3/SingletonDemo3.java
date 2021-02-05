package com.sgg.designPattern.singleton.type3;

public class SingletonDemo3 {
    public static void main(String[] args) {
        //懒汉式
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        System.out.println(instance==instance1);
        System.out.println("instance.hashCode="+instance.hashCode());
        System.out.println("instance1.hashCode="+instance1.hashCode());
    }
}
//懒汉式
class Singleton{
    private static Singleton instance;
    private Singleton(){}
    //提供一个静态的公有方法，当使用到该方法时，才去创建instance
    //即懒汉式
    public static Singleton getInstance(){
        if (instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}