package com.sgg.designPattern.factorymethod.pizzastore.order;

import com.sgg.designPattern.factorymethod.pizzastore.pizza.*;

public class LDOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
