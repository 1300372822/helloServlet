package com.sgg.designPattern.absfactory.pizzastore.order;

import com.sgg.designPattern.absfactory.pizzastore.pizza.BJCheesePizza;
import com.sgg.designPattern.absfactory.pizzastore.pizza.BJPepperPizza;
import com.sgg.designPattern.absfactory.pizzastore.pizza.Pizza;

public class BJFactory  implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza =  new BJPepperPizza();
        }
        return pizza;
    }
}
