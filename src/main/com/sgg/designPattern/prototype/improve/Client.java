package com.sgg.designPattern.prototype.improve;


public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("原型模式完成对象的克隆");
       Sheep sheep = new Sheep("tom", 1, "白色");
        sheep.friend = new Sheep("aaa", 2, "白色");
        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();

        System.out.println(sheep+ "======"+sheep.hashCode()+"======"+sheep.getName().hashCode());
        System.out.println(sheep1+"======"+sheep1.hashCode()+"======"+sheep1.getName().hashCode());
        System.out.println(sheep2+"======"+sheep2.hashCode()+"======"+sheep2.getName().hashCode());
    }
}
