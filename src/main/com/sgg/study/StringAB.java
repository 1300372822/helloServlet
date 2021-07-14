package com.sgg.study;

/**
 * 变量+常量
 */
public class StringAB {

    public static void main(String[] args) {


        String sa = "a";
        String str = "abc";
        String s= sa+"bc";
        System.out.println(s==str);//false 在堆
    }
}
