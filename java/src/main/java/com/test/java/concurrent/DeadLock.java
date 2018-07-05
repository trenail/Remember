package com.test.java.concurrent;

/**
 * 演示死锁
 */
public class DeadLock {

    private Object objectA = new Object();
    private Object objectB = new Object();

    public void workA() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectA) {
                    System.out.println("workA get objectA lock");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (objectB) {
                        System.out.println("workA get objectB lock");
                    }
                }

                System.out.println("workA is done!");
            }
        });
        thread.start();
    }

    public void workB() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectB) {
                    System.out.println("workB get objectB lock");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (objectA) {
                        System.out.println("workB get objectA lock");
                    }
                }

                System.out.println("workB is done!");
            }
        });
        thread.start();
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.workA();
        deadLock.workB();
    }
}
