package com.test.java.concurrent;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 单例并发测试
 * 1.不添加volatile关键字
 * 2.开启一百个线程,不断的获取实例
 * 3.主线程不断的清空,创建实例
 * <p>
 * 如果出现了对象不为空,但是未实例化的情况(testValue==0),立即退出程序,打印日志
 * <p>
 * 为啥不能重现?还是理解不正确?
 */
public class SingletonDemo {

    public static void main(String[] args) {

        final AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService executorService = Executors.newCachedThreadPool();


        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (SingletonDemo.getInstance().getTestValue() == 0) {
                            System.out.println("getTestValue error!");
                            System.exit(0);
                        }

                    }
                }
            });
        }

        CompletionService completionService = new ExecutorCompletionService(executorService);

        for (int i = 0; i < 1000000; i++) {

//            for (int j = 0; j < 10; j++) {
//                completionService.submit(new Callable<Object>() {
//                    @Override
//                    public Object call() throws Exception {
//                        if (SingletonDemo.getInstance().getTestValue() == 0) {
//                            System.out.println("getTestValue error!");
//                            System.exit(0);
//                        }
//                        atomicInteger.addAndGet(1);
//                        return null;
//                    }
//                });
//            }
//
//            //等所有初始化线程执行完毕
//            for (int j = 0; j < 10; j++) {
//                try {
//                    completionService.take();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            SingletonDemo.getInstance();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //重置对象
            SingletonDemo.clear();

        }
        System.out.println("---------------------------------------");
        System.out.println(atomicInteger.get());
    }

    private static SingletonDemo instance = null;

    private AtomicInteger atomicInteger = new AtomicInteger(0);


    private int testValue = 0;

    private SingletonDemo() {
        atomicInteger.addAndGet(1);
        System.out.println("SingletonDemo class instance created by thread name: " + Thread.currentThread().getName());

        if (atomicInteger.get() > 1) {
            System.out.println("SingletonDemo class instance count > 1");
            System.exit(0);
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        testValue = 1;
    }

    public int getTestValue() {
        return testValue;
    }

    public static void clear() {
        instance = null;
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
