package com.sgg;

import java.util.ArrayList;

/**
 *
 */
public class Test1 {

    public static void main(String[] args) {
        String str = "Java java hello world";
        String newStr = str.replaceAll("Java", "尚硅谷~");
        System.out.println("newStr= "+ newStr);

        //ArrayList扩容
//       维护数组 transient Object[] elementData;
        ArrayList arrayList = new ArrayList();

    }
}
