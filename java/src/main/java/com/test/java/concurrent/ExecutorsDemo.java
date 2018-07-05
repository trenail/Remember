package com.test.java.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
public class ExecutorsDemo {

    public static void main(String[] args) {
        //new ExecutorsDemo().newSingleThreadExecutor();

        new ExecutorsDemo().executorCompletionService();

        // new ExecutorsDemo().newScheduledThreadPool();
    }

    /**
     * 创建一个只含有一个线程的线程池，该线程池只含有一个线程，当线程池里的线程被销毁后，线程池又会创建一个线程，替代原来的线程
     */
    public void newSingleThreadExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executorService.execute(new Runnable() {
                public void run() {
                    for (int j = 1; j <= 10; j++) {
                        System.out.println(Thread.currentThread().getName() + "----" + j + "次" + "execute task" + taskId);
                    }
                }
            });
        }
    }

    /**
     * 创建一个调度线程池，内含有3个线程，实现10秒定时执行功能
     */
    public void newScheduledThreadPool() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        scheduledExecutorService.schedule(new Runnable() {
            public void run() {
                System.out.println("bomb!!!");
            }
        }, 10, TimeUnit.SECONDS);
    }

    /**
     * Future取得的结果类型和Callable返回的结果类型必须一致，这是通过泛型来实现的。
     * Callable要采用ExecutorSevice的submit方法提交，返回的future对象可以取消任务
     */
    public void futureAndCallable() {
        System.out.println("主线程：：：：" + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new Callable() {
            public Object call() throws Exception {
                Thread.sleep(2000);

                System.out.println("子线程执行完毕!");
                return Thread.currentThread().getName();
            }
        });
        String string = null;
        try {
            System.out.println("等待开始");
            // string = (String) future.get();//没有结果会一直等待，知道有结果为止
            string = (String) future.get(1000, TimeUnit.MILLISECONDS);//等待10s，没有有结果报异常
            System.out.println("等待结束");
        } catch (Exception e) {
            e.printStackTrace();

            future.cancel(true);//如果出现异常,则取消任务
        }
        System.out.println("Callable线程：：：：" + string);
    }

    /**
     * CompletionService用于提交一组Callable任务，其take方法返回已完成的一个Callable任务对应的Future对象。
     * 好比我同时种了几块地的麦子，然后就等待收割。收割时，则是那块先成熟了，则先去收割哪块麦子。
     */
    public void executorCompletionService() {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletionService completionService = new ExecutorCompletionService(executorService);

        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            completionService.submit(new Callable() {
                public Object call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return "执行完的任务的ID::::" + taskId;
                }
            });
        }

        for (int i = 1; i <= 10; i++) {
            try {
                String string = (String) completionService.take().get();
                System.out.println(string);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
