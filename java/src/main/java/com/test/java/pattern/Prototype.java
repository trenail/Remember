package com.test.java.pattern;

/**
 * Created by home on 2018/5/17.
 * 原型模式
 * <p>
 * 使用原型实例指定创建对象的种类，
 * 并且通过拷贝这些原型创建新的对象
 * <p>
 * 。原型模式是一种对象创建型模式。
 * <p>
 * 可以使用序列化的方式完成对象的深拷贝
 */

public class Prototype {

    public static void main(String[] args) {
        try {
            ConcretePrototype prototype = new ConcretePrototype();
            prototype.name = "test name1";

            ConcretePrototype prototype2 = prototype.clone();


            System.out.println(prototype2.name);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static class ConcretePrototype implements Cloneable {

        public String name;

        @Override
        protected ConcretePrototype clone() throws CloneNotSupportedException {
            return (ConcretePrototype) super.clone();
        }
    }
}
