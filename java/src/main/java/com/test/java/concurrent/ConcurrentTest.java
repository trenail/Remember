package com.test.java.concurrent;

import java.util.ArrayList;

/**
 * 并发测试
 * 一个队列,一个线程对其修改,另一个线程加锁并迭代该对象
 *
 * 当一个对象的锁被一个线程持有,另一个线程也可以在不锁定对象的情况下对其进行操作
 */
public class ConcurrentTest {

    public static void main(String[] args) {

        final ArrayList<String> list = new ArrayList<>();


        new Thread(new Runnable() {
            int value = 0;

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add(value++ + "");
                }
            }
        }).start();

        synchronized (list) {
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(list.size());
            }
        }
    }
}
