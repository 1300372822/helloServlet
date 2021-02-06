package com.sgg.designPattern.absfactory.pizzastore.order;

import com.sgg.designPattern.absfactory.pizzastore.pizza.Pizza;

//一个抽象工厂模式的抽象层（接口）
public interface AbsFactory {

    public Pizza createPizza(String orderType);

}
