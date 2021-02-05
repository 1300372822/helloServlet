package com.sgg.designPattern.principle.segregation;

public class Segregation1 {

}

//接口
interface Inteface1{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}
class B implements Inteface1{

    @Override
    public void operation1() {
        System.out.println("B 实现了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了operation3");
    }

    @Override
    public void operation4() {
        System.out.println("B 实现了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("B 实现了operation5");

    }
}
class D implements Inteface1{

    @Override
    public void operation1() {
        System.out.println("D 实现了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("D 实现了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("D 实现了operation3");
    }

    @Override
    public void operation4() {
        System.out.println("D 实现了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D 实现了operation5");

    }
}
class A{        //A类通过接口Interface1 依赖（使用B）类，但是只会用到1，2，3
    public void depend1(Inteface1 i){
        i.operation1();
    }
    public void depend2(Inteface1 i){
        i.operation2();
    }
    public void depend3(Inteface1 i){
        i.operation3();
    }
}
class C{        //C类通过接口Interface1 依赖（使用D）类，但是只会用到1，4，5方法
    public void depend1(Inteface1 i){
        i.operation1();
    }
    public void depend4(Inteface1 i){
        i.operation4();
    }
    public void depend5(Inteface1 i){
        i.operation5();
    }
}