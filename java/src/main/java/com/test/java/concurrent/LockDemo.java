package com.test.java.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock比传统线程模型中的synchronized方式更加面向对象，与生活中的锁类似，锁本身也应该是一个对象。
 * 两个线程执行的代码片段要实现同步互斥的效果，它们必须用同一个Lock对象。
 * */
public class LockDemo {
    public static void main(String[] args) {
        new LockDemo().action();
    }

    private void action() {
        final Outputer outputer = new Outputer();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    outputer.output("zhangxiaoxiang\n");
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    outputer.output("lihuoming\n");
                }
            }
        }).start();
    }

    private class Outputer {
        private Lock lock = null;

        public Outputer() {
            lock = new ReentrantLock();
        }

        public void output(String name) {
            lock.lock();
            try {
                for (int i = 0; i < name.length(); i++) {
                    System.out.print(name.charAt(i));
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
