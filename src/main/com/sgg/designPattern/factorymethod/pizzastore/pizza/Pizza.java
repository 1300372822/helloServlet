package com.sgg.designPattern.factorymethod.pizzastore.pizza;

import java.util.Calendar;

/**
 * 将pizza类做成抽象类
 */
public abstract class Pizza {
    protected String name;
    //准备原材料，不同的披萨不一样，因此做成抽象方法
    public abstract void prepare();

    public void bake(){
        System.out.println(name+" baking;");
    }
    public void cut(){
        System.out.println(name+" cutting;");
    }
    public void box(){
        System.out.println(name+" boxing;");
    }
    public void setName(String name){
        this.name = name;
    }
    Calendar calendar = new Calendar() {
        @Override
        protected void computeTime() {

        }

        @Override
        protected void computeFields() {

        }

        @Override
        public void add(int field, int amount) {

        }

        @Override
        public void roll(int field, boolean up) {

        }

        @Override
        public int getMinimum(int field) {
            return 0;
        }

        @Override
        public int getMaximum(int field) {
            return 0;
        }

        @Override
        public int getGreatestMinimum(int field) {
            return 0;
        }

        @Override
        public int getLeastMaximum(int field) {
            return 0;
        }
    };

}
