package com.sgg.study;

public class StringDemo {

    public static void main(String[] args) {
//        String s1 = new StringBuilder("5852521").append("tongcheng").toString();
        String s1 = new String("ppp");
        String str = new String("java");

        String s= "java";
        System.out.println(s==str);
        System.out.println(s==str.intern());
        System.out.println(str.intern()=="dad11sa");
//        System.gc();
//        String s3 = new StringBuilder("58").append("tongcheng").toString();
//        System.out.println(s1==s3);
//        String q = "aa";
//        String b = "aa";
//        System.out.println(q==b);

//        System.out.println(s1==s1.intern());

//        System.out.println(s1.intern());
//        System.out.println(s1==s1.intern());
//        System.out.println();
//
//        String s2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(s2);
//        System.out.println(s2.intern());
//        System.out.println(s2==s2.intern());

    }
}
