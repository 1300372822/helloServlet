package com.sgg.designPattern.principle.inversion.improve;

public class DependecyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeiXin());
    }
}
interface IReceiver{
    public String getInfo();

}
//增加微信
class WeiXin implements IReceiver{

    @Override
    public String getInfo() {
        return "微信信息：hello，world";
    }
}
