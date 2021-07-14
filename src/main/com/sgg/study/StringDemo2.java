package com.sgg.study;

public class StringDemo2 {
    public static void main(String[] args) {
        String s1 = new StringBuilder("58").append("tongch").toString();
        System.out.println(s1.intern()==s1);
        System.out.println(s1.intern()=="58tongch");
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern()==s2);
        System.out.println(s2.intern().equals(s2));

        String s3 = new String("58tongcheng");
        System.out.println(s3.intern());
        String s4 = "58tongcheng";
        System.out.println(s3==s3.intern());

        System.out.println(s4==s3);
        System.out.println(s4==s3.intern());
    }
}
