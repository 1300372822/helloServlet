package com.luban;

public class Test {
    private static  int i = 1;
    private static  String str = "s";
    public static void main(String[] args) {
        System.out.println(i);
        System.out.println(str);
        update(i,str);
        System.out.println(i);
        System.out.println(str);
    }

    public static  void update(int i,String str){
        i=3;
        str = "2222";
    }
}
