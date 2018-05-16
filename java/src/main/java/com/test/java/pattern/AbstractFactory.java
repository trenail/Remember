package com.test.java.pattern;

/**
 * Created by home on 2018/5/16.
 */

public class AbstractFactory {
    public static void main(String[] args) {
        new FactoryB().getProductA().methodDiff();
    }

    static abstract class ProductA {
        public void methodSame() {
        }

        public abstract void methodDiff();
    }

    static abstract class ProductB {
        public void methodSame() {
        }

        public abstract void methodDiff();
    }

    static class ConcreteProductA1 extends ProductA {

        @Override
        public void methodDiff() {
            System.out.println("ConcreteProductA1->methodDiff");
        }

    }

    static class ConcreteProductA2 extends ProductA {

        @Override
        public void methodDiff() {
            System.out.println("ConcreteProductA2->methodDiff");
        }

    }

    static class ConcreteProductB1 extends ProductB {

        @Override
        public void methodDiff() {
            System.out.println("ConcreteProductB1->methodDiff");
        }

    }

    static class ConcreteProductB2 extends ProductB {

        @Override
        public void methodDiff() {
            System.out.println("ConcreteProductB2->methodDiff");
        }

    }

    interface IFactory {
        ProductA getProductA();

        ProductB getProductB();
    }

    static class FactoryA implements IFactory {


        @Override
        public ProductA getProductA() {
            return new ConcreteProductA1();
        }

        @Override
        public ProductB getProductB() {
            return new ConcreteProductB1();
        }
    }

    static class FactoryB implements IFactory {


        @Override
        public ProductA getProductA() {
            return new ConcreteProductA2();
        }

        @Override
        public ProductB getProductB() {
            return new ConcreteProductB2();
        }
    }
}
