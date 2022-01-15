package com.sgg.ms;


import java.util.HashMap;
import java.util.Map;

public class Demo3 {

    public static void main(String[] args) {

    }
}

class LRUCache{

    Map map = new HashMap();
    public void put(int k,int v){
        map.put(k,v);
    }
    public int get(int k){
        if (!map.containsKey(k)){
            return -1;
        }else {
            return (int)map.get(k);
        }
    }

}
