package com.sgg.set;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetDemo {

    public static void main(String[] args) {

        HashSet set = new HashSet();
        set.add(1);//底层是hashmap

        TreeSet treeSet = new TreeSet();
        treeSet.add(1);
    }
}
