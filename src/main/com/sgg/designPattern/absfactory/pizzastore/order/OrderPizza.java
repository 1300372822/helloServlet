package com.sgg.designPattern.absfactory.pizzastore.order;

import com.sgg.designPattern.absfactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    AbsFactory factory;
    public void setAbsFactory(AbsFactory factory){
        Pizza pizza = null;
        String orderType ;
        this.factory = factory;
        do {
            orderType = getType();
            pizza = factory.createPizza(orderType);
            if (pizza!=null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购失败");
                break;
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
