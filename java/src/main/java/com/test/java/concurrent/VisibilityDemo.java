package com.test.java.concurrent;

import java.util.Collections;

/**
 * 对象可见性demo
 */
public class VisibilityDemo {

    private static boolean FLAG = false;

    public static void main(String[] args) {
        FLAG = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!FLAG) {
                    System.out.println("可见性");
                   System.exit(0);
                }
                System.out.println("sub thread is done!");
            }
        }).start();


    }
}
