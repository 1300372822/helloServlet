package com.sgg.adapter.classadapter;

public class Client {

    public static void main(String[] args) {
        System.out.println("=== 类适配模式 ===");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
