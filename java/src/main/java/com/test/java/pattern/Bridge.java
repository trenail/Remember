package com.test.java.pattern;

/**
 * Created by home on 2018/5/18.
 * 桥接模式
 * <p>
 * 将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * <p>
 * 它是一种对象结构型模式，又称为柄体(Handle and Body)模式或接口(Interface)模式
 */

public class Bridge {

    public static void main(String[] args) {

        RefinedAbstraction refinedAbstraction = new RefinedAbstraction(new ConcreteImplementorA());

        refinedAbstraction.operation();
    }

    public static abstract class Abstraction {
        Implementor mImplementor;

        public Abstraction(Implementor implementor) {
            mImplementor = implementor;
        }

        public void operation() {
            mImplementor.operationImpl();
        }
    }

    public static class RefinedAbstraction extends Abstraction{

        public RefinedAbstraction(Implementor implementor) {
            super(implementor);
        }
    }


    public interface Implementor {
        void operationImpl();
    }

    public static class ConcreteImplementorA implements  Implementor{

        @Override
        public void operationImpl() {
            System.out.println("ConcreteImplementorA -> operationImpl");
        }
    }
    public static class ConcreteImplementorB implements  Implementor{

        @Override
        public void operationImpl() {
            System.out.println("ConcreteImplementorB -> operationImpl");
        }
    }
}
