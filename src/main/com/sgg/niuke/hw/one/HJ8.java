package com.sgg.niuke.hw.one;

import java.util.*;

/**
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，
 * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * <p>
 * 0 3
 * 1 2
 * 3 4
 */
public class HJ8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        TreeSet set = new TreeSet();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
//                String s = in.nextLine();
//                int index = s.indexOf(" ");
//                int key = Integer.parseInt(s.substring(0, index));
//                int value = Integer.parseInt(s.substring(index+1, s.length()));
            int key = in.nextInt();
            int value = in.nextInt();
            set.add(key);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + value);
            } else {
                map.put(key, value);
            }
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            Integer value = map.get(key);
            System.out.println(key + " " + value);
        }
        //遍历map的方法
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : entries) {
        }
    }
}
