package com.sgg.designPattern.simplefactory.pizzastore.order;

import com.sgg.designPattern.simplefactory.pizzastore.pizza.CheesePizza;
import com.sgg.designPattern.simplefactory.pizzastore.pizza.GreekPizza;
import com.sgg.designPattern.simplefactory.pizzastore.pizza.PepperPizza;
import com.sgg.designPattern.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

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
    SimpleFactory simpleFactory ;
    Pizza pizza = null;
    //构造器
    public OrderPizza(SimpleFactory factory){
        setSimpleFactory(factory);
    }
    public void setSimpleFactory(SimpleFactory simpleFactory){
        String orderType = "";  //用户输入的
         this.simpleFactory = simpleFactory; //设置简单工厂对象
        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);

            //输出pizza
            if(pizza!=null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();

            }else {
                System.out.println("订购披萨失败");
            }
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
