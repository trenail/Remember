package com.test.java.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //开启十个子线程,所有线程开启完毕后,执行任务,
        // 打印信息,所有线程任务执行完毕后,同时结束

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Thread name " + Thread.currentThread().getName() + " waiting!");
                        cyclicBarrier.await();
                        System.out.println("Thread name " + Thread.currentThread().getName() + " runing!");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread name " + Thread.currentThread().getName() + " wait over!");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Thread name " + Thread.currentThread().getName() + " over!");
                }
            });
        }
    }
}
