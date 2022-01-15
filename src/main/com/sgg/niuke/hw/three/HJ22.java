package com.sgg.niuke.hw.three;

import java.util.Scanner;

public class HJ22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()){
            int count = scanner.nextInt();
            if (count==0)break;
            int result =0;
            while (count>2){
                result+=count/3;
                count = count/3+count%3;
            }
            System.out.println(result);
        }
    }
}
