package com.test.java.pattern;

/**
 * Created by home on 2018/5/18.
 *
 * 适配器模式
 *
 * 将一个接口转换成客户希望的另一个接口
 * ，使接口不兼容的那些类可以一起工作，
 * 其别名为包装器(Wrapper)。
 *
 * 适配器模式既可以作为类结构型模式，也可以作为对象结构型模式
 */

public class Adapter {
    public static void main(String[] args) {
        Target target= new MyAdapter();
        target.request();
    }

    public interface Target {
        void request();
    }

    public static class MyAdapter implements Target {

        public Adaptee adaptee = new Adaptee();

        @Override
        public void request() {
            adaptee.specificRequest();
        }
    }

    public static class Adaptee {
        public void specificRequest() {
            System.out.println("Adaptee->specificRequest()");
        }
    }
}
