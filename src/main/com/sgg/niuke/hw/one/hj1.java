package com.sgg.niuke.hw.one;

import java.util.Scanner;

/**
 * 字符串最后一个单词长度
 */
public class hj1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
//        in.hasNext();
        String[] strArr = str.split(" ");
        String strings = strArr[strArr.length-1];


        System.out.println(strings.length()); ;

    }

    public static int getLength(String str){
        String[] strArr = str.split(" ");
        String strings = strArr[strArr.length-1];
        return strings.length();
    }
    public static int getLength2(String str){
        int count = 0;
        for (int i = str.length()-1; i >0; i--) {
            if (str.substring(i,i+1).equals(" ")){
                break;
            }
            count++;
        }

        return count;
    }

}
