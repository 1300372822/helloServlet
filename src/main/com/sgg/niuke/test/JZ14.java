package com.sgg.niuke.test;

import java.util.Arrays;

/**
 * 输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 */
public class JZ14 {

    public static ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead==null||k==0)return null;
        ListNode cur1  = pHead;
        ListNode cur2 = pHead;
        int count = 1;
        while (cur2.next!=null&&count<k){
            cur2=cur2.next;
            count++;
        }
        while (cur2.next!=null){
            cur1 = cur1.next;
            cur2 = cur2.next;
            count++;
        }
        if (count<k) return null;
        return cur1;
        // write code here
    }

    public static ListNode FindKthToTail2 (ListNode pHead, int k) {
        if (pHead==null )return pHead;
        ListNode cur1  = pHead;
        ListNode cur2 = pHead;
        for (int i = k;i>0;i--){
            if (cur2==null) return cur2;
            cur2=cur2.next;
        }
        while (cur2.next!=null){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
        // write code here
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        node4.next=node5;
        ListNode node3 = new ListNode(3);
        node3.next=node4;
        ListNode node2 = new ListNode(2);
        node2.next=node3;
        ListNode node1 = new ListNode(1);
        node1.next=node2;

        ListNode node = FindKthToTail(node1, 0);
        System.out.println(node);
        if (node!=null)
        System.out.println(node.val);
    }
}
class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }
