package com.sgg.JUC.ms;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        Collections.synchronizedMap(new HashMap<>());

        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        map.put("","");
    }
}
