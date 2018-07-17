package com.test.java.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并发工具类ContDownlatch的使用
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {

        //开启十个线程等待某个信号完成,然后印信息,然后等待这十个线程执行完毕,然后打印信息
        final CountDownLatch countDownLatchStart = new CountDownLatch(1);
        final CountDownLatch countDownLatchEnd = new CountDownLatch(10);

        final ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {

                    System.out.println("Thread name " + Thread.currentThread().getName() + " 等待中!");

                    try {
                        countDownLatchStart.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Thread name " + Thread.currentThread().getName() + " runing!");

                    try {
                        Thread.sleep(new Random().nextInt(3000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatchEnd.countDown();
                    System.out.println("Thread name " + Thread.currentThread().getName() + " 执行完毕!");
                }
            });
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("通知子线程开始执行");
        countDownLatchStart.countDown();


        try {
            countDownLatchEnd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("子线程执行完毕");
    }


}
