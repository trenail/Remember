package com.test.java.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可响应中断的显式锁
 */
public class LockInterrupt {

    public static void main(String[] args) throws InterruptedException {

        final ReentrantLock reentrantLock = new ReentrantLock();
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        //一个线程永久持有显式锁
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                countDownLatch.countDown();
                while (true) {
                    System.out.println("显式锁在我这儿:" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.setName("TestThread1");
        thread1.start();

        //一个线程以可中断方式获取显式锁
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    reentrantLock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println("中断成功,获取锁失败!");
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }

            }
        });
        thread2.setName("TestThread2");
        thread2.start();

        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                reentrantLock.lock();
                reentrantLock.unlock();

                System.out.println("thread3 is done!");
            }
        });
        thread3.setName("TestThread3");
        thread3.start();


        //一个线程五秒后中断thread2
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {

                }
                thread2.interrupt();
                thread3.interrupt();
            }
        }).start();


    }
}
