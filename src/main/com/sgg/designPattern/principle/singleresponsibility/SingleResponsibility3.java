package com.sgg.designPattern.principle.singleresponsibility;

public class SingleResponsibility3 {
    public static void main(String[] args) {

    }
}
//方式三
//1.这种方法没有对原来的类做大的修改，只是增加了方法
//2.这里虽然没有在类这个级别上遵守单一职责原则，但是在方法级别上，仍然遵守单一职责原则
class Vehicle2{
    public void run(String vehicle){
        System.out.println(vehicle+" 在公路上跑。。。。。。。。。。");
    }
    public void runAir(String vehicle){
        System.out.println(vehicle+" 在天空上运行。。。。。。。。。。");
    }
    public void runWater(String vehicle){
        System.out.println(vehicle+" 在水中运行。。。。。。。。。。");
    }
}
