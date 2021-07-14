package com.sgg.study;

import java.util.Hashtable;

public class NewStringDemo {

    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
//        hashtable.put("")
        String str = new StringBuilder("asadads").append("ds").toString();
//        String str = new String("shangags");
        System.out.println(str);
        String strw = "shangags";
        System.out.println(str.intern());
        System.out.println(str.intern()==str);
        System.out.println(str.intern()==strw);
        System.out.println(str.intern()=="shangags");
        System.out.println(str=="shangags");



        System.out.println("===================");
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);
    }
}
