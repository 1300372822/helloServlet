package com.sgg.niuke.jump;

public class JumpN {

    public static void main(String[] args) {
        int i = jumpFloor(5);
        System.out.println(i);
    }

    public static int jumpFloor(int target){

        Math.pow(2,target);
        if (target==1||target==2)return target;
        int[] arr = new int[target+1];
        arr[0]=1;arr[1]=1;
        int sum = 1;
        for (int i = 0; i < target; i++) {
            arr[i] = arr[0]+arr[i-1];
            sum = sum+i;
        }

        return jumpFloor(target-1)+jumpFloor(target-2);
    }
}
