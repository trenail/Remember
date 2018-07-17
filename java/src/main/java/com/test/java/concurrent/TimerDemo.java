package com.test.java.concurrent;

import java.util.Timer;
import java.util.TimerTask;

/**
 * timer在执行所有定时任务时只会创建一个线程.
 * 如果某个任务的执行时间过长,那么将破坏其他TimerTask的定时精确性.
 * 例如某个周期TimerTask需要没10ms执行一次,而另一个TimerTask需要执行40毫秒
 * 那么这个周期任务或者40ms任务执行完成后快速连续的调用4次,或者彻底丢失4次调用
 * <p>
 * timer的另一个问题是,如果timertask抛出了一个未检查的异常,那么timer将表现出糟糕的行为
 */
public class TimerDemo {

    public static void main(String[] args) {
        printCurrentTime();
        final Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                printCurrentTime("timer1");
            }
        }, 0, 10);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                printCurrentTime("timer2");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 10);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        printCurrentTime("timer4");
                    }
                },10);
               throw new RuntimeException();
            }
        }, 1000);

    }

    private static void printCurrentTime() {
        printCurrentTime(null);
    }

    private static void printCurrentTime(String value) {

        System.out.println("thread: " + Thread.currentThread().getName() + " time:" + System.currentTimeMillis() + " value:" + value);
    }
}
