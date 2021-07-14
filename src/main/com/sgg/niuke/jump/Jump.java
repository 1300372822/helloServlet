package com.sgg.niuke.jump;

public class Jump {

    public static void main(String[] args) {

        int i = jumpFloor(5);
        System.out.println(i);

        System.out.println(jumpFloor2(5));
    }
    public static int jumpFloor(int target){
        if (target==1||target==2)return target;
       return jumpFloor(target-1)+jumpFloor(target-2);
    }

    //解法2 动态规划

    public static int jumpFloor2(int target) {
        if (target == 1 || target == 2) return target;
        int[] arr = new int[target+1];
        arr[0]=1; arr[1]=1;
        for (int i = 2; i <= target; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[target];
    }



}
