package com.test.java.concurrent;

/**
 * 使用 wait 和 nofify ,实现两个线程交替执行
 */
public class WaitAndNotify {

    public static void main(String[] args) {
        new WaitAndNotify().work();
    }


    int currentThreadId = 0;

    public void work() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {


                    while (currentThreadId != 0) {
                        try {
                            synchronized (WaitAndNotify.class) {
                                WaitAndNotify.class.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("thread1 dosomething");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    currentThreadId = 1;
                    synchronized (WaitAndNotify.class) {
                        WaitAndNotify.class.notify();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {


                    while (currentThreadId != 1) {
                        try {
                            synchronized (WaitAndNotify.class) {
                                WaitAndNotify.class.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("thread2 dosomething");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    currentThreadId = 0;
                    synchronized (WaitAndNotify.class) {
                        WaitAndNotify.class.notify();
                    }
                }
            }
        }).start();
    }

}
