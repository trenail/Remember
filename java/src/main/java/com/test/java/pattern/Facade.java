package com.test.java.pattern;

/**
 * Created by home on 2018/5/26.
 * <p>
 * 为子系统中的一组接口提供一个统一的入口。
 * 外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
 * <p>
 * 外观模式又称为门面模式，它是一种对象结构型模式
 */

public class Facade {

    public static void main(String[] args) {
        new MyFacade().method();
    }

    public static class MyFacade {

        SubSystem1 subSystem1 = new SubSystem1();
        SubSystem2 subSystem2 = new SubSystem2();
        SubSystem3 subSystem3 = new SubSystem3();

        public void method() {
            subSystem1.method();
            subSystem2.method();
            subSystem3.method();
        }
    }

    public static class SubSystem1 {
        public void method() {
            System.out.println("SubSystem1->method()");
        }
    }

    public static class SubSystem2 {
        public void method() {
            System.out.println("SubSystem1->method()");
        }
    }

    public static class SubSystem3 {
        public void method() {
            System.out.println("SubSystem3->method()");
        }
    }

}
