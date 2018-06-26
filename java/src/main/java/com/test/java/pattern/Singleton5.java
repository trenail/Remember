package com.test.java.pattern;

/**
 * Created by home on 2018/6/12.
 * 使用枚举创建单例
 *
 * @ see <a href="https://blog.csdn.net/zahngjialiang/article/details/79814485">单例模式</a>
 */
public class Singleton5 {

    public static Singleton5 getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    private enum SingletonEnum {

        INSTANCE;

        private Singleton5 singleton5;

        SingletonEnum() {
            singleton5 = new Singleton5();
        }

        public Singleton5 getInstance() {
            return singleton5;
        }
    }

}
