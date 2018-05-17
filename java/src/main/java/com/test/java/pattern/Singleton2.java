package com.test.java.pattern;

/**
 * Created by home on 2018/5/17.
 * 懒汉式单例
 */

public class Singleton2 {
    private static Singleton2 instance = null;

    private Singleton2() {
    }

    synchronized public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
