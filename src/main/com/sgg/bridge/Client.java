package com.sgg.bridge;

public class Client {
    public static void main(String[] args) {

        //获取折叠式手机（样式+品牌）
        Phone phone = new FoldedPhone(new XiaoMi());
        phone.open();
        phone.close();
        phone.call();

        System.out.println("================");
        Phone phone2 =  new UprightPhone(new Vivo());
        phone2.open();
        phone2.close();
        phone2.call();
    }
}
