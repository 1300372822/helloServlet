package com.sgg.ms;

import java.util.HashMap;
import java.util.TreeMap;

public class Demo4 {

    public static void main(String[] args) {

        String s="";
        s.hashCode();
        System.out.println(s.hashCode());
        s.equals("");

        TreeMap treeMap = new TreeMap();
        treeMap.put("","");
        HashMap hashMap = new HashMap();
        hashMap.put("","");
    }
}
