package com.test.java.pattern;

/**
 * Created by home on 2018/5/17.
 * 使用 双重检查锁定(Double-Check Locking) 优化 懒汉式单例
 * <p/>
 * 为什么需要还需要volatile关键字?
 * 使用volatile关键字,保证有序性
 * <p>
 * instance = new Singleton3();可以分为三个部分:
 * 　　1.分配内存空间。
 * 　　2.初始化对象。
 * 　　3.将内存空间的地址赋值给对应的引用。
 * <p>
 * 如果不使用volatile关键字,那么顺序可能变成 1->3->2,此时假设有两个线程,
 * 一个线程正在执行 步骤3,步骤2还未执行,此时另一个线程 通过 if (instance == null)
 * 判断对象不为空,获取的实例是未初始化完毕的
 * <p>
 * <p>
 * 为啥写的测试程序验证不出这个问题?
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
