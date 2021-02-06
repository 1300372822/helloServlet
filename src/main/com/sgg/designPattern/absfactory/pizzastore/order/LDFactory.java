package com.sgg.designPattern.absfactory.pizzastore.order;

import com.sgg.designPattern.absfactory.pizzastore.pizza.*;

public class LDFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza =  new LDPepperPizza();
        }
        return pizza;
    }
}
