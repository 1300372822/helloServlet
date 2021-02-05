package com.sgg.designPattern.principle.liskov;

public class Liskov {

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.func1(8,7));
    }
}
//创建一个更加基础的基类
class Base{

}
//A类
class A extends  Base{
    //返回俩个数的差
    public int func1(int num1,int num2){
        return num1 - num2;
    }
}
//B类继承了A
//增加了一个新功能，完成俩个数相加
class B extends Base{
    //如果B类需要使用A类的方法，使用组合关系
    private A a = new A();


    public int func1(int num1,int num2){
        return num1+num2;
    }
    public int func2(int a,int b){
        return func1(a,b)+9;
    }

    //仍然想使用A类的方法
    public int func3(int a,int b){
        return this.a.func1(a,b);
    }
}
