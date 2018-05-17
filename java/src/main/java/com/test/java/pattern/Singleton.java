package com.test.java.pattern;

/**
 * Created by home on 2018/5/16.
 * 饿汉式单例类
 * <p>
 * 确保某一个类只有一个实例，
 * 而且自行实例化并向整个系统提供这个实例，
 * 这个类称为单例类，它提供全局访问的方法。
 * <p>
 * 单例模式是一种对象创建型模式
 */

public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

}
