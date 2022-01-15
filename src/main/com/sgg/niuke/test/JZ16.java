package com.sgg.niuke.test;

import java.util.List;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * {1,3,5},{2,4,6}
 * {1,2,3,4,5,6}
 */
public class JZ16 {


}
class Solution16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode node =new ListNode(0);
        ListNode curl = list1;
        ListNode curr = list2;
        ListNode cur = node;
        while (curl!=null&&curr!=null){
            if (curl.val>curr.val){
                cur.next = curr;
                curr = curr.next;

            }else {
                cur.next = curl;
                curl = curl.next;
            }
            cur = cur.next;
        }
        cur.next= curl ==null?curr:curl;
        return node.next;
    }
}


