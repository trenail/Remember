package com.test.java.pattern;

/**
 * Created by home on 2018/5/16.
 * <p>
 * 简单工厂
 * <p>
 * 简单工厂模式并不属于GoF 23个经典设计模式，但通常将它作为学习其他工厂模式的基础
 * <p>
 * 定义:
 * 定义一个工厂类，它可以根据参数的不同返回不同类的实例，
 * 被创建的实例通常都具有共同的父类。
 * 因为在简单工厂模式中用于创建实例的方法是静态(static)方法，
 * 因此简单工厂模式又被称为静态工厂方法(Static Factory Method)模式，
 * 它属于类创建型模式。
 */

public class SimpleFactory {


    public static void main(String[] args) {
        Factory.getProduct("A").methodDiff();
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

    static class Factory {
        public static Product getProduct(String arg) {
            if (arg.equalsIgnoreCase("A")) {
                return new ConcreteProductA();
            } else if (arg.equalsIgnoreCase("B")) {
                return new ConcreteProductB();
            }
            return null;
        }
    }
}
