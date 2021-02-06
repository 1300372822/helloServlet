package com.sgg.designPattern.factorymethod.pizzastore.order;

import com.sgg.designPattern.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract  class OrderPizza {

    //构造器
//    public OrderPizza(){
//        Pizza pizza = null;
//        String orderType ;  //订购披萨的类型
//        do {
//            orderType =   getType();
//        if (orderType.equals("greek")){
//            pizza = new GreekPizza();
//            pizza.setName("希腊披萨");
//        }else if (orderType.equals("cheese")) {
//            pizza = new CheesePizza();
//            pizza.setName("奶酪披萨");
//        }else if (orderType.equals("pepper")){
//            pizza = new PepperPizza();
//            pizza.setName("胡椒披萨");
//        }
//        else {
//            break;
//        }
//        //输出pizza制作过程
//            pizza.prepare();
//        pizza.bake();
//        pizza.cut();
//        pizza.box();
//        }while (true);
//    }
    //定义一个简单工厂了=类
//    SimpleFactory simpleFactory ;
    //定义一个抽象方法，createPizza ，让各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);
    //构造器
    public OrderPizza(){
        Pizza pizza = null;
        String orderType ;
        do {
            orderType = getType();
            pizza = createPizza(orderType);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);

    }
    //写一个方法，可以获取客户希望订购的披萨种类
    private String getType(){
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input pizza 种类");
        String s = null;
        try {
            s = strin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return s;

    }


}
