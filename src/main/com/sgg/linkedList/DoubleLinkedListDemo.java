package com.sgg.linkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "吴用", "智多星");
        HeroNode2 heroNode3 = new HeroNode2(3, "林冲", "豹子头");
        HeroNode2 heroNode4 = new HeroNode2(4, "鲁智深", "花和尚");
        HeroNode2 heroNode5 = new HeroNode2(3, "使劲", "接吻龙");
        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addNode(heroNode1);
        doubleLinkedList.addNode(heroNode2);
        doubleLinkedList.addNode(heroNode3);
        doubleLinkedList.addNode(heroNode4);
        doubleLinkedList.showLinkedList();
        doubleLinkedList.updateNode(heroNode5);
        System.out.println("修改之后的链表");
        doubleLinkedList.showLinkedList();
        }
    }


class DoubleLinkedList{
    //先初始化一个头节点  不存放具体数据
    public HeroNode2 head = new HeroNode2(0,"","");
    //返回头节点
    public HeroNode2 getHead(){
        return head;
    }
    //遍历双向链表的方法
    //显示链表
    public void showLinkedList(){
        HeroNode2 temp = head;
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
    //添加一个节点到双向链表最后
    public void addNode(HeroNode2 node){
        //辅助变量temp 遍历链表
        HeroNode2 temp = head;
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
        node.pre = temp;
    }
    //修改节点的信息，根据no来修改
    public void updateNode(HeroNode2 newHeroNode){
        if(head.next==null){
            System.out.println("链表为空!");
            return;
        }
        HeroNode2 temp = head;
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
    //从双向链表中删除一个节点
    //1.对于双向链表直接找到要删除的节点
    public void deleteNode(int no){
        if(head.next==null){
            System.out.println("链表为空!不能删除");
            return;
        }
        HeroNode2 temp = head.next;
        while (true){
            if (temp==null){
                System.out.println("没找到对应节点");
                break;
            }
            if(temp.no == no){
                temp.pre.next = temp.next;
                //如果temp是最后一个节点
                if(temp.next!=null){
                    temp.next.pre = temp.pre;
                }


                break;
            }

            temp = temp.next;
        }
    }


}
class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;  //指向下一个节点
    public HeroNode2 pre;   //指向前一个节点

    public HeroNode2(int no,String name, String nickName){
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
