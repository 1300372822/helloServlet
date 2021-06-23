package com.sgg.niuke.test1;

import java.util.Vector;

public class FeiBo {

    public int Fibonacci(int n) {

            if(n>2){
                return Fibonacci(n-1)+Fibonacci(n-2);
            }else if(n==0){
                return 0;
            }else{
                return 1;
            }

        }
    public static  int Fibonacci2(int n) {
        if (n==0||n==1){
            return n;
        }else {
            return Fibonacci2(n-1)+Fibonacci2(n-2);
        }
    }
    //解法2 用数组存储中间过程
    public static  int Fibonacci3(int n) {
          int[] arrays = new int[39];
        return fib(arrays,n);
//        Vector<int> vector(45,-1);
    }
    public static int fib(int[] arrays,int n){
        if (n==0||n==1){
            arrays[0]=0;
            arrays[1]=1;
            return n;
        }else {
            arrays[n] = arrays[n-1]+arrays[n-2];
            return fib(arrays,n-1)+fib(arrays,n-2);
        }
    }
    public static void main(String[] args) {
        int i = Fibonacci3(5);
        System.out.println(i);
    }
}
