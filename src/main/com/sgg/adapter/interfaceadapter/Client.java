package com.sgg.adapter.interfaceadapter;

public class Client {
    public static void main(String[] args) {
        AbsAdapter adapter = new AbsAdapter() {
            //只需要去覆盖我们需要使用接口方法

            @Override
            public void save1() {
                System.out.println("使用了吗m1的方法");
            }
        };
        adapter.save1();


    }
}
