package com.sgg.niuke.hw.three;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。
 * 哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
 * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，
 * 他通过一种算法把这个密码变换成YUANzhi1987，
 * 这个密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
 * 他是这么变换的，大家都知道手机上的字母：
 * 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
 *
 * YUANzhi1987
 * zvbo9441987
 * */
public class HJ21 {
    static Map map = new HashMap();
    static {
        for (int i = 0; i < 10; i++) {
            map.put(i,i);
        }
        map.put('Z','a');
        map.put('a',2);
        map.put('b',2);
        map.put('c',2);
        map.put('d',3);
        map.put('g',4);
        map.put('h',4);
        map.put('i',4);

        map.put('j',5);
        map.put('k',5);
        map.put('l',5);
        map.put('m',6);
        map.put('n',6);
        map.put('p',7);
        map.put('q',7);
        map.put('r',7);
        map.put('s',7);
        map.put('r',7);
        map.put('r',7);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i)>='A' && str.charAt(i)<='Y'){
                    char c = (char) (str.charAt(i) + 33);
                    sb.append(c);
                }else if (str.charAt(i)=='Z'){
                    sb.append('a');
                }else if (str.charAt(i)>='a'&& str.charAt(i)<='c'){
                    sb.append(2);
                }else if (str.charAt(i)>='d'&& str.charAt(i)<='f'){
                    sb.append(3);
                }else if (str.charAt(i)>='g'&& str.charAt(i)<='i'){
                    sb.append(4);
                }else if (str.charAt(i)>='j'&& str.charAt(i)<='l'){
                    sb.append(5);
                }else if (str.charAt(i)>='m'&& str.charAt(i)<='o'){
                    sb.append(6);
                }else if (str.charAt(i)>='p'&& str.charAt(i)<='s'){
                    sb.append(7);
                }else if (str.charAt(i)>='t'&& str.charAt(i)<='v'){
                    sb.append(8);
                }else if (str.charAt(i)>='w'&& str.charAt(i)<='z'){
                    sb.append(9);
                }else {
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }

    }
}
