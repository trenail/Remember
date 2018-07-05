package com.test.java.concurrent;

/**
 * 并发产生的问题场景演示
 */
public class Question1 {

    public static void main(String[] args) {
        // new Question1().startOupput();  //无锁的情况
        new Question1().startOupputLock();//有锁的情况
    }

    public void startOupput() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    outputNoLock("好好学习,天天向上");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    outputNoLock("锄禾日当午,汗滴禾下土");
                }
            }
        }).start();
    }

    public void startOupputLock() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    outputLock("好好学习,天天向上");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    outputLock("锄禾日当午,汗滴禾下土");
                }
            }
        }).start();
    }

    public void outputNoLock(String message) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
        }
        System.out.println();
    }

    public synchronized void outputLock(String message) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
        }
        System.out.println();
    }
}
