package com.sgg.designPattern.singleton.type7;

public class SingletonDemo7 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 =Singleton.getInstance();

        System.out.println(instance==instance1);
        System.out.println("instance.hashCode="+instance.hashCode());
        System.out.println("instance1.hashCode="+instance1.hashCode());
    }
}
class Singleton{
    //构造器私有化
    private Singleton(){}

    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
