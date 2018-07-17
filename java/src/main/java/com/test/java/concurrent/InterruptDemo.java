package com.test.java.concurrent;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * 使用中断的方式退出线程
 *
 * @see <a href="http://www.infoq.com/cn/articles/java-interrupt-mechanism"></a>
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread1 = new Thread(new Runnable() {
            int value = 0;

            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.println("thread1 runing:" + value++);
                        Thread.sleep(1000);
                    }
                    System.out.println("thread1 jump loop!");
                } catch (InterruptedException e) {
                    System.out.println("thread1 InterruptedException!");
                    // Restore the interrupted status
                    //Thread.currentThread().interrupt();
                }


            }
        });
        thread1.start();


        Thread.sleep(3000);

        thread1.interrupt();
        //thread1.stop();

        final Thread thread2 = new Thread(new Runnable() {
            int value;

            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("thread2 runing:" + value++);
                    for (int i = 0; i < 100000000; i++) {

                    }
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 isInterrupted:");

            }
        });
        thread2.start();


        Thread.sleep(3000);
        System.out.println("mian call thread2 isInterrupted() start "+System.currentTimeMillis());
        thread2.interrupt();
        System.out.println("mian call thread2 isInterrupted() end "+System.currentTimeMillis());
    }
}
