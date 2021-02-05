package com.sgg.designPattern.principle.singleresponsibility;

public class SingleResponsibility {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("小汽车");
        vehicle.run("飞机");
    }
}
//交通工具类
//1.方式一的run方法中，违反了单一职责原则
//2.解决方案，根据交通工具运行方法不同时，分解成不同的类
class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle+" 在公路上跑。。。。。。。。。。");
    }
}
