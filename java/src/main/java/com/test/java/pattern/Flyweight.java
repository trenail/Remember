package com.test.java.pattern;

import java.util.HashMap;

/**
 * Created by home on 2018/5/27.
 * 享元模式
 * <p>
 * 运用共享技术有效地支持大量细粒度对象的复用。
 * 系统只使用少量的对象，而这些对象都很相似，
 * 状态变化很小，可以实现对象的多次复用。
 * <p>
 * 由于享元模式要求能够共享的对象必须是细粒度对象
 * ，因此它又称为轻量级模式，它是一种对象结构型模式
 */

public class Flyweight {

    public static void main(String[] args) {
        new FlyweightFactory().getFlyweight("1").operation("teset1");
    }

    public static class FlyweightFactory {

        public static FlyweightFactory instance = new FlyweightFactory();

        private HashMap<String, MyFlyweight> flyweightHashMap = new HashMap();

        private FlyweightFactory() {
            MyFlyweight flyweight = new ConcreteFlyweight();
            MyFlyweight flyweight2 = new ConcreteFlyweight2();
            flyweightHashMap.put("1", flyweight);
            flyweightHashMap.put("2", flyweight2);
        }

        public FlyweightFactory getInstance() {
            return instance;
        }

        public MyFlyweight getFlyweight(String key) {
            return flyweightHashMap.get(key);
        }
    }

    public abstract static class MyFlyweight {
        protected String mIntrinsicState;

        public abstract void operation(String extrinsicState);
    }

    public static class ConcreteFlyweight extends MyFlyweight {

        public ConcreteFlyweight() {
            mIntrinsicState = "内部状态1";
        }

        @Override
        public void operation(String extrinsicState) {
            System.out.println("ConcreteFlyweight->operation()");
            System.out.println("内部状态->" + mIntrinsicState);
            System.out.println("外部状态->" + extrinsicState);
        }
    }

    public static class ConcreteFlyweight2 extends MyFlyweight {

        public ConcreteFlyweight2() {
            mIntrinsicState = "内部状态2";
        }

        @Override
        public void operation(String extrinsicState) {
            System.out.println("ConcreteFlyweight->operation()");
            System.out.println("内部状态->" + mIntrinsicState);
            System.out.println("外部状态->" + extrinsicState);
        }
    }

}
