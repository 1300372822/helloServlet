package com.sgg.niuke.hw.one;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示
 */
public class HJ5 {
    static Map<Character,Integer> map;
    static {
        map = new HashMap();
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        map.put('A',10);
        map.put('B',11);
        map.put('C',12);
        map.put('D',13);
        map.put('E',14);
        map.put('F',15);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            String next = in.next();
            char[] chars = next.toCharArray();
            int num=0;
            int power=1;
            for (int i = chars.length-1 ;i >= 2; i--) {
                if (chars[i]>='0'&& chars[i]<='9'){
                    num = num+ (chars[i]-'0')*power;
                }else if (chars[i]>='A'&&chars[i]<='F'){
                    num = num +(chars[i]-'A'+10)*power;
                }
                power*=16;
            }

            System.out.println(num);
        }
    }


}
