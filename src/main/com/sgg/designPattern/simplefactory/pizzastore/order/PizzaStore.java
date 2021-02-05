package com.sgg.designPattern.simplefactory.pizzastore.order;

//相当于一个客户端，发出订购
public class PizzaStore {
    public static void main(String[] args) {
//        new OrderPizza();
        new OrderPizza(new SimpleFactory());
        System.out.println("退出了程序");
    }
}
