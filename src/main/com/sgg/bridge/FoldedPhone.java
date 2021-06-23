package com.sgg.bridge;

//折叠式手机类，集成抽象类
public class FoldedPhone extends Phone{
    public FoldedPhone(Brand brand) {
        super(brand);
    }
    public void open(){
        super.open();
        System.out.println("折叠样式手机");
    }

    @Override
    protected void close() {
        super.close();
        System.out.println("折叠样式手机");
    }

    @Override
    protected void call() {
        super.call();
        System.out.println("折叠样式手机");
    }
}
