package com.sgg.niuke.test;

import java.util.HashMap;
import java.util.Map;

public class JZ36 {

    public static void main(String[] args) {
        Solution36 solution36 = new Solution36();
        solution36.FindFirstCommonNode(null,null);
    }
}
class Solution36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Map<Integer,ListNode> map= new HashMap<>();
        ListNode cur = pHead1;
        while(cur!=null){
            map.put(cur.val,cur);
            cur = cur.next;
        }
        ListNode cur2 = pHead2;
        while(cur2!=null){
            if(map.containsKey(cur2.val)){
                return cur2;
            }
            cur2 = cur2.next;

        }
        return null;
    }
}