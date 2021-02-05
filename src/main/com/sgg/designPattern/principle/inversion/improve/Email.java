package com.sgg.designPattern.principle.inversion.improve;

class Email implements IReceiver{
    public  String getInfo(){
        return "电子邮件信息：hello，world";
    }
}