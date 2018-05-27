package com.test.java.pattern;

/**
 * Created by home on 2018/5/27.
 * <p>
 * 代理模式
 * <p>
 * 给某一个对象提供一个代理或占位符，并由代理对象来控制对原对象的访问
 * <p>
 * 代理模式是一种对象结构型模式
 */

public class Proxy {

    public static void main(String[] args) {
        new MyProxy().request();
    }

    public interface Subject {
        void request();
    }

    public static class MyProxy implements Subject {

        private Subject realSubject = new RealSubject();

        @Override
        public void request() {

            System.out.println("MyProxy->request()");
            realSubject.request();
        }
    }

    public static class RealSubject implements Subject {

        public void request() {
            System.out.println("RealSubject->request()");
        }
    }
}
