package com.test.java.concurrent;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁：分为读锁和写锁，多个读锁不互斥，读锁与写锁互斥，这是由jvm自己控制的，
 * 你只要上好相应的锁即可。
 * 如果你的代码只读数据，可以很多人同时读，但不能同时写，那就上读锁；如果你的代码修改数据，
 * 只能有一个人在写，且不能同时读取，那就上写锁。总之，读的时候上读锁，写的时候上写锁！
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        new ReadWriteLockDemo().work();
    }

    TestData testData = new TestData();

    public void work() {

        //开启十个线程,循环读取数据
        for (int i = 0; i < 10; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("线程" + index + "读取数据:" + testData.getValue());

                        try {
                            Thread.sleep(new Random().nextInt(10000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        //接收用户输入,写入数据

        for (int i = 0; i < 10; i++) {

            testData.writeValue(i);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public class TestData {
        private int value = 0;
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        public int getValue() {

            try {
                readWriteLock.readLock().lock();
                return value;
            } finally {
                readWriteLock.readLock().unlock();
            }


        }


        public void writeValue(int value) {
            readWriteLock.writeLock().lock();
            try {
                System.out.println("正在写入数据!");
                Thread.sleep(new Random().nextInt(3000));
                this.value = value;
                System.out.println("写入数据完毕:" + value);
            } catch (Exception ex) {

            } finally {
                readWriteLock.writeLock().unlock();
            }
        }
    }


}

