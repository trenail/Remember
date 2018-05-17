package com.test.java.pattern;

/**
 * Created by home on 2018/5/17.
 *
 * 使用 Initialization Demand Holder (IoDH) 方式实现单例模式
 *
 * 利用java类加载机制,当HolderClass被调用时,才初始化单例类
 *
 */

public class Singleton4 {

    private static class HolderClass {
        private final static Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return HolderClass.instance;
    }
}
