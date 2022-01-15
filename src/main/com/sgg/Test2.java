package com.sgg;

import java.util.concurrent.ConcurrentHashMap;

public class Test2 {

    public static void main(String[] args) {
        //n个石头
        //俩人轮流取，每次1到3
        //最后赢家

        ConcurrentHashMap hashMap = new ConcurrentHashMap<>();
        hashMap.put("","");
    }

    public static boolean test(int n){

       if (n<=3){
           return true;
       } else {

           return test(n-1)||test(n-2)||test(n-3);
       }


    }

}
