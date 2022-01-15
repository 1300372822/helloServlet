package com.sgg.niuke.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 示例:
 * 输入:{1,2,3,4,5,3,5,#,2,#}
 * 输出:{1,2,3,4,5,3,5,#,2,#}
 * 解析:我们将链表分为两段，前半部分{1,2,3,4,5}为ListNode，后半部分{3,5,#,2,#}是随机指针域表示。
 * 以上示例前半部分可以表示链表为的ListNode:1->2->3->4->5
 */
public class JZ25 {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,3,5,null,2,null};
        RandomListNode listNode = new RandomListNode(-1);
        RandomListNode cur  =listNode;
        List<RandomListNode> list = new ArrayList<>();//用于存放node
        for (int i = 0; i < array.length/2;i++) {
            cur.next = new RandomListNode(array[i]);
            list.add(cur.next);
            cur = cur.next;

        }
        cur = listNode;
        for (int i = array.length/2; i < array.length;i++) {
            if (array[i]==null){
                cur.random=null;
            }else {
                cur.random = list.get(array[i-array.length/2]);
            }
            cur = cur.next;
        }

        //1.构建链表
        Solution25 solution25 = new Solution25();
        RandomListNode clone = solution25.Clone(listNode.next);
        RandomListNode cur2 = clone;
        while (cur2!=null){
            System.out.print(cur2.label+"\t");
            cur2 = cur2.next;
        }
        cur2 = clone;
        while(cur2!=null){
            if (cur2.random==null){
                System.out.print("null\t");
            }else {
                System.out.print(cur2.random.label+"\t");
            }

            cur2 = cur2.next;
        }
        System.out.println();
        //2.

    }
}
class Solution25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead==null)return null;
        RandomListNode node = pHead;
        RandomListNode newHead =new RandomListNode(-1) ;
        RandomListNode newCur = newHead;
        Map<Integer,Integer> map = new HashMap<>();

        while (node!=null){
            if (map.containsKey(node.label)){
                break;
            }
            int a = 0;
            if(node.random==null)a=-1;
            else a = node.random.label;
            map.put(node.label,a);

            RandomListNode newNode = new RandomListNode(node.label);
            newCur.next = newNode;
            newCur = newCur.next;
            node=node.next;
        }
        newCur = newHead.next;
        node = pHead;
        while (node!=null){
            //继续遍历

            Integer integer = map.get(node.label);
            if (integer==-1){
                newCur.random = null;
                node=node.next;
                newCur = newCur.next;
            }else {
                RandomListNode cur2 = newHead.next;
                for (int i = 1; i < integer; i++) {
                    cur2=cur2.next;
                }

                newCur.random = cur2;
                node=node.next;
                newCur = newCur.next;
            }

        }
        return newHead.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

