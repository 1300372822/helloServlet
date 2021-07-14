package com.sgg.JUC.JMM.sort;

public class SortDemo {

    int a = 0;
    public  void update(){
        a=2;
    }
    public static void main(String[] args) {
        SortDemo sortDemo = new SortDemo();
        System.out.println(sortDemo.a);
        sortDemo.update();
        System.out.println(sortDemo.a);
    }

}
