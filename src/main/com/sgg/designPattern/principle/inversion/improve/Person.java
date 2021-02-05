package com.sgg.designPattern.principle.inversion.improve;

//方式2
class Person {
    public void  receive(IReceiver iReceiver){
        System.out.println(iReceiver.getInfo());
    }
}
