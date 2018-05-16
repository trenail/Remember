package com.test.java.pattern;

/**
 * Created by home on 2018/5/16.
 * 工厂方法模式
 * <p>
 * 定义:
 * 定义一个用于创建对象的接口，让子类决定将哪一个类实例化。
 * 工厂方法模式让一个类的实例化延迟到其子类。
 * 工厂方法模式又简称为工厂模式(Factory Pattern)，
 * 又可称作虚拟构造器模式(Virtual Constructor Pattern)或多态工厂模式
 * (Polymorphic Factory Pattern)。
 * 工厂方法模式是一种类创建型模式
 */

public class FactoryMethod {

    public static void main(String[] args) {
        new FactoryB().getProduct().methodDiff();
    }

    static abstract class Product {
        public void methodSame() {
        }

        public abstract void methodDiff();
    }

    static class ConcreteProductA extends Product {

        @Override
        public void methodDiff() {
            System.out.println("ConcreteProductA->methodDiff");
        }

    }

    static class ConcreteProductB extends Product {

        @Override
        public void methodDiff() {
            System.out.println("ConcreteProductB->methodDiff");
        }

    }

    interface IFactory {
        Product getProduct();
    }

    static class FactoryA implements IFactory {

        @Override
        public Product getProduct() {
            return new ConcreteProductA();
        }
    }

    static class FactoryB implements IFactory {

        @Override
        public Product getProduct() {
            return new ConcreteProductB();
        }
    }
}
