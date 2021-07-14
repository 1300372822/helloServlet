package com.sgg.study;

/**
 * return 和finallu执行顺序
 * 1、finally中的代码总会被执行。
 *
 * 2、当try、catch中有return时，也会执行finally。return的时候，要注意返回值的类型，是否受到finally中代码的影响。
 *
 * 3、finally中有return时，会直接在finally中退出，导致try、catch中的return失效。
 *
 * 1，try-catch-finally执行顺序：
 *
 * ①，执行try{}块
 *
 * ②，如果try{}块有异常产生，执行catch{}块
 *
 * ③，无论有没有异常都要执行finally{}块，这里可以看出只要finally中有return，必然返回finally{}中的return
 ①，如果finally{}块中有return语句，只执行finally{}块中的return语句

 ②，如果finally{}块中没有return语句，如果try{}有异常，则返回catch{}中的return语句，不然执行try{}中return语句

 在这种情况下，return语句块是在finally{}之后执行

 如果finally{}中没有return，

 如果try{}正常，执行try{}return语句,如果异常执行catch{}中return语句，但是此事return语句返回在finally{}语句之后
 */
public class TestTryReturn {

    public static void main(String[] args) {
        String test = test();
        System.out.println(test);

    }

    public static String test(){

        try {
            System.out.println("==================try 输出=========================");
//            int i = 1/0;
            return "try return";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("==================catch 输出=========================");
            return "catch return";
        }finally {
            System.out.println("===============finally输出===============");
            return "finally return";
        }

    }
}
