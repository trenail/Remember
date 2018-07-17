package com.test.java.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask 使用示例
 */
public class FutureTaskDemo {
    public static void main(String[] args) {
        final FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "test data";
            }
        });

        new Thread(futureTask).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("等待数据 " + System.currentTimeMillis());
                    String value = futureTask.get();
                    System.out.println("等待完毕 " + System.currentTimeMillis());
                    System.out.println("获取数据:" + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
