package com.sgg.niuke.hw.two;

import java.util.Scanner;

/**
 * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ），
 * q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 */
public class HJ16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //总钱数
        int money = sc.nextInt();
        //购买物品个数
        int n = sc.nextInt();
        if(n<=0||money<=0) System.out.println(0);

        Good[] Gs = new Good[n+1];
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            Gs[i] = new Good(v,p,q);

            if(q>0){
                if(Gs[q].a1==0){
                    Gs[q].setA1(i);
                }else {
                    Gs[q].setA2(i);
                }
            }
        }

        int[][] dp = new int[n+1][money+1];
        for (int i = 1; i <= n; i++) {
            int v=0,v1=0,v2=0,v3=0,tempdp=0,tempdp1=0,tempdp2=0,tempdp3=0;

            v = Gs[i].v;

            tempdp = Gs[i].p*v; //只有主件

            if(Gs[i].a1!=0){//主件加附件1
                v1 = Gs[Gs[i].a1].v+v;
                tempdp1 = tempdp + Gs[Gs[i].a1].v*Gs[Gs[i].a1].p;
            }

            if(Gs[i].a2!=0){//主件加附件2
                v2 = Gs[Gs[i].a2].v+v;
                tempdp2 = tempdp + Gs[Gs[i].a2].v*Gs[Gs[i].a2].p;
            }

            if(Gs[i].a1!=0&&Gs[i].a2!=0){//主件加附件1和附件2
                v3 = Gs[Gs[i].a1].v+Gs[Gs[i].a2].v+v;
                tempdp3 = tempdp + Gs[Gs[i].a1].v*Gs[Gs[i].a1].p + Gs[Gs[i].a2].v*Gs[Gs[i].a2].p;
            }

            for(int j=1; j<=money; j++){
                if(Gs[i].q > 0) {   //当物品i是附件时,相当于跳过
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                    if(j>=v&&v!=0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v]+tempdp);
                    if(j>=v1&&v1!=0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v1]+tempdp1);
                    if(j>=v2&&v2!=0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v2]+tempdp2);
                    if(j>=v3&&v3!=0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v3]+tempdp3);
                }
            }
        }
        System.out.println(dp[n][money]);

    }
}

/**
 * 定义物品类
 */
class Good{
    public int v;  //物品的价格
    public int p;  //物品的重要度
    public int q;  //物品的主附件ID

    public int a1=0;   //附件1ID
    public int a2=0;   //附件2ID

    public Good(int v, int p, int q) {
        this.v = v;
        this.p = p;
        this.q = q;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }
}
