package com.test.java.concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {

        //开启一个子线程,加载数据,主线程阻塞,加载完毕后和主线程交换数据

        final Exchanger<String> exchanger = new Exchanger<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    String value = exchanger.exchange("test data");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            System.out.println("等待数据加载");
            String value = exchanger.exchange(null);
            System.out.println("获取数据:" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
