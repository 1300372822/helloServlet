package com.sgg.JUC.JMM;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.验证volatile可见性
 * 假如int number=0；number变量之前根本没有添加到volatile关键字修饰
 * 1.1添加了volatile可以解决可见性问题
 *
 * 2.验证Volatile不保证原子性
 * 2.1原子性是什么意思？
 *   不可分割，线程做某个操作的时候，中间不可以被分割，需要整体完整，要么同时成功，要么同时失败
 * 2.2volatile不保证原子性的案例演示
 *
 * 2.3why
 * 2.4如何解决原子性
 *    加synchorized
 *    使用juc下AtomicInteger
 * 3.有序性
 * 
 *
 *
 *
 */
public class VolatileDemo {

    public static void main(String[] args) {
//        seeOkByVolatile();
        Mydata mydata = new Mydata();
        for (int i = 1;i<=20;i++){
            new Thread(()->{
                for (int j = 0;j<1000;j++){
                    mydata.addPlusPlus();
                    mydata.addAtomic();
                }

            },String.valueOf(i)).start();
        }
        //需要等待上面20个线程全部计算完成后，再用main线程取得最终结果
        //暂停一会
        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"\t finally number value:"+mydata.number);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger finally number value:"+mydata.atomicInteger);
    }
    //volatile可以保证可见性，及时通知其他线程，主内存的值已经被修改
    public static void seeOkByVolatile() {
        Mydata mydata = new Mydata();//资源类
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t"+"修改前number="+mydata.number);
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mydata.add();
            System.out.println(Thread.currentThread().getName()+"\t"+"修改后number="+mydata.number);


        },"AAA").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t"+"number="+mydata.number);

        },"BBB").start();

        while(mydata.number==0){

        }
        System.out.println(Thread.currentThread().getName()+"\t"+"main number="+mydata.number);
    }
}

class Mydata{
//    volatile int number = 0;
    int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger();
    public void add(){
        this.number = 60;
    }

    //请注意此时 number前面是加了volatile关键字修饰的
    public  void addPlusPlus(){
        number++;

    }

    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }


}
