package com.sgg.bridge;

public abstract class Phone {

    //组合品牌
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }
    protected void open(){
        this.brand.open();
    }
    protected void close(){
        brand.close();
    }
    protected void call(){
        brand.call();
    }
}
