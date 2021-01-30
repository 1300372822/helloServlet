package com.sgg.linkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode heroNode4 = new HeroNode(4, "鲁智深", "花和尚");
        HeroNode heroNode5 = new HeroNode(5, "武松", "行者");
        //创建一个链表
        SingleLinkedList list = new SingleLinkedList();
        //加入
//        list.addNode(heroNode1);
//        list.addNode(heroNode4);
//        list.addNode(heroNode2);
//        list.addNode(heroNode3);
        //加入按照编号
        list.addOrderNode(heroNode1);
        list.addOrderNode(heroNode4);
        list.addOrderNode(heroNode3);
        list.addOrderNode(heroNode2);
//        list.updateNode(heroNode5);
        list.showLinkedList();
        System.out.println("删除之后的为：");
//        list.deleteNode(3);

        //显示
        list.showLinkedList();
        int count = list.getCount(list);
        System.out.println("个数："+count);
        HeroNode kNode = list.getKNode(2, list);
        System.out.println("倒数第2个元素为"+kNode);

        System.out.println("将链表反转之后：");
        SingleLinkedList reverse = list.reverse(list);
        reverse.showLinkedList();

        System.out.println("使用栈结构逆序打印单链表");
        reverse.reversePrint(reverse.head);

    }
}

//定义SingleLinkedList 管理英雄
class SingleLinkedList{
    //先初始化一个头节点  不存放具体数据
    public HeroNode head = new HeroNode(0,"","");
    //添加节点到单向链表
    //当不考虑编号顺序时，（尾插法）
    //1.找到当前链表最后节点
    //2.将这个最后节点指向新的节点
    public void addNode(HeroNode node){
        //辅助变量temp 遍历链表
        HeroNode temp = head;
        //遍历链表找打最后
        while (true){
            if(temp.next == null){
                break;
            }
            //如果没有找到最后temp后移
            temp = temp.next;
        }
        //当while退出循环时，最后一个元素
        temp.next = node;
    }
    //按编号顺序插入（头插法） 根据排名将新英雄插入指定位置
    //如果有这个排名，添加失败给出提示
    public void addOrderNode(HeroNode node){
        //因为头节点不能动，因此仍然需要一个辅助指针来找到添加的位置
        //因为单链表 ，找的是添加位置的前一个结点
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
//            temp = head.next;
            //遍历链表
            if(temp.next==null){ //说明temp已经在链表的最后
                break;
            }
            if(node.no<temp.next.no){//找到位置，就在temp的后面插入
                break;
            }else if(temp.next.no == node.no){//说明希望添加的heroNode已经存在
                System.out.println("新添加的英雄已经存在，"+node.no);
                flag = true; //说明编号存在
                break;
            }
            temp = temp.next;
        }
        //判断flag值
        if(flag){// 不能添加说明编号存在
            System.out.println("不能加入");
        }else {
            //头插法
            node.next = temp.next;
            temp.next = node;
        }
    }
    //显示链表
    public void showLinkedList(){
        HeroNode temp = head;
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        while (true){
            if (temp.next==null){
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }

    //修改节点的信息，根据no来修改
    public void updateNode(HeroNode newHeroNode){
        if(head.next==null){
            System.out.println("链表为空!");
            return;
        }
        HeroNode temp = head;
        while (true){
            if (temp.next==null){
                System.out.println("没找到对应节点");
                break;
            }
           if(temp.next.no == newHeroNode.no){
                temp.next.name = newHeroNode.name;
                temp.next.nickName = newHeroNode.nickName;
                break;
           }

           temp = temp.next;
        }
    }

    //删除节点
    public void deleteNode(int no){
        if(head.next==null){
            System.out.println("链表为空!不能删除");
            return;
        }
        HeroNode temp = head;
        while (true){
            if (temp.next==null){
                System.out.println("没找到对应节点");
                break;
            }
            if(temp.next.no == no){
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }
    }

    //求单链表中节点的个数  (需要不统计头节点)
    public int getCount(SingleLinkedList list){
        if (list.head.next==null){
            return 0;
        }
        HeroNode temp = list.head;
        int count = 0;
        while (true){
            if(temp.next==null){
                break;
            }
            temp = temp.next;
            count++;
        }
        return count;
    }

    //查找单链表中倒数第k个节点（新浪面试题）
    //倒数第k小 设正数  m+k = length+1;
    public HeroNode getKNode(int k,SingleLinkedList list){
        if(list.head==null){
            System.out.println("该链表为空");
        }
        int length = getCount(list);
        if(k > length){
            System.out.println("链表个数小于k------------所以倒数第k个元素不存在");
            return null;
        }
        HeroNode temp = list.head.next;
        int m=0;
        while (true){
            //倒数第k小  即正数 length - k
            if(m==length-k){
                break;
            }
            m++;
            temp = temp.next;
        }
        return temp;
    }

    //单链表的反转（腾讯面试题）
    public SingleLinkedList reverse(SingleLinkedList list){
        SingleLinkedList reverseList = new SingleLinkedList();
        HeroNode temp = list.head.next;
        HeroNode node = reverseList.head;
        int k = 1;

        while (true){
            HeroNode kNode = getKNode(1, list);
            //取出元素头插法
            kNode.next = node.next;
            node.next = kNode;
            node=node.next;
            //断原先的链表
            HeroNode node1 = list.head;
            while (true) {

                if(node1.next.next==null){
                    node1.next = null;
                    break;
                }
                node1 = node1.next;
            }
            int count = getCount(list);
            if(count<1){
                break;
            }

        }
        return reverseList;
    }

    //利用栈实现逆序打印
    public void reversePrint(HeroNode head){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur!=null){
            stack.add(cur);
            cur=cur.next;
        }
        while(stack.size()>0) {
            System.out.println(stack.pop());
        }

    }
}
//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;  //指向下一个节点

    public HeroNode(int no,String name, String nickName){
        this.no = no;
        this.name=name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +

                '}';
    }
}
