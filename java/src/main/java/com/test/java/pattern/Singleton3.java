package com.test.java.pattern;

/**
 * Created by home on 2018/5/17.
 * 使用 双重检查锁定(Double-Check Locking) 优化 懒汉式单例
 * <p>
 * 使用volatile关键字,保证指令的有序性和可见性
 */

public class Singleton3 {

    private volatile static Singleton3 instance = null;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {

        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null)
                    instance = new Singleton3();
            }
        }

        return instance;
    }
}
