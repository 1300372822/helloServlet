package com.sgg;

public class Test5 {

    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode(1);
        node1.next = new LinkedNode(5);
        node1.next.next = new LinkedNode(5);
        LinkedNode node2 = new LinkedNode(2);
        node2.next = new LinkedNode(3);
        LinkedNode node = mergeNode(node1, node2);
        System.out.println(node);
    }

    public static LinkedNode mergeNode(LinkedNode node1,LinkedNode node2){
        LinkedNode head = new LinkedNode(-1);
        LinkedNode cur = head;
        int tempVal = 0;
        while (node1!=null&&node2!=null){
            if (node1.val<node2.val){
                if (tempVal!=node1.val){
                    tempVal = node1.val;
                    LinkedNode node =new LinkedNode(node1.val);
                    cur.next = node;
                    cur = cur.next;
                }
                node1 = node1.next;

            }else {
                if (tempVal!= node2.val){
                    tempVal=node2.val;
                    LinkedNode node =new LinkedNode(node2.val);
                    cur.next = node;
                    cur = cur.next;
                }
                node2 = node2.next;
            }
        }
        if (node1!=null){
            if (node1.val!=tempVal){
                tempVal = node1.val;
                LinkedNode node =new LinkedNode(node1.val);
                cur.next = node;
                cur = cur.next;
            }
        }
        if (node2!=null){
            if (node2.val!= tempVal){
                tempVal = node2.val;
                LinkedNode node =new LinkedNode(node1.val);
                cur.next = node;
                cur = cur.next;

            }
        }
        return head.next;

    }
}
class LinkedNode{

    public int val;
    public LinkedNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkedNode(int val) {
        this.val = val;
    }

    public LinkedNode() {
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}