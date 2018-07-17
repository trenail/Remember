package com.test.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {

        //开启十个线程,但同时只有三个线程并发执行

        //默认有3个许可
        final Semaphore semaphore = new Semaphore(3);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("thread name " + Thread.currentThread().getName() + " is runing");
                        Thread.sleep(3000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    semaphore.release();
                }
            });
        }
    }
}
