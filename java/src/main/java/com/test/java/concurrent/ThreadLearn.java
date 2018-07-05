package com.test.java.concurrent;

/**
 * 线程
 * 每个正在系统上运行的程序都是一个进程。
 * 每个进程包含一到多个线程。
 * 进程也可能是整个程序或者是部分程序的动态执行。
 * 线程是一组指令的集合，或者是程序的特殊段，它可以在程序里独立执行。也可以把它理解为代码运行的上下文。
 * 所以线程基本上是轻量级的进程，它负责在单个程序里执行多任务。通常由操作系统负责多个线程的调度和执行。
 * <p>
 * 线程的状态:
 * 1、 new 新建
 * 2、 Runnable 可以运行(就绪)
 * 3、 Running 运行(正在运行)
 * 4、 Block 阻塞  挂起
 * 5、 Dead 死亡
 */
public class ThreadLearn {

    //创建线程的方式
    public static void main(String[] args) {
        ThreadLearn threadLearn = new ThreadLearn();
        threadLearn.createMode1A();
        threadLearn.createMode1B();
        threadLearn.createMode1C();
    }

    public void createMode1A() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("createMode1A");
            }
        };
        thread.start();
    }

    public void createMode1B() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("createMode1B");
            }
        });
        thread.start();
    }

    public void createMode1C() {
        Thread thread = new MyThread();
        thread.start();
    }


    public class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("createMode1C");
        }
    }

}
