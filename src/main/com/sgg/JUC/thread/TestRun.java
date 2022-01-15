package com.sgg.JUC.thread;

public class TestRun {

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("ppppppppppppppppppp");
        }, String.valueOf(1)).run();
    }
}
