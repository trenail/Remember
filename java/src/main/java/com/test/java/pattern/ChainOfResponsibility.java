package com.test.java.pattern;

/**
 * Created by home on 2018/5/31.
 * <p>
 * 责任链模式
 * <p>
 * 避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，
 * 将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。
 * <p>
 * 职责链模式是一种对象行为型模式
 */

public class ChainOfResponsibility {

    public static void main(String[] args) {
        ConcreteHandlerA concreteHandlerA = new ConcreteHandlerA();
        ConcreteHandlerB concreteHandlerB = new ConcreteHandlerB();

        concreteHandlerA.setSuccessor(concreteHandlerB);

        concreteHandlerA.handlerRequest("2");
    }

    public abstract static class Handler {

        protected Handler mSuccessor;

        public Handler getSuccessor() {
            return mSuccessor;
        }

        public void setSuccessor(Handler mSuccessor) {
            this.mSuccessor = mSuccessor;
        }

        public abstract void handlerRequest(String params);

    }

    public static class ConcreteHandlerA extends Handler {
        @Override
        public void handlerRequest(String params) {
            if (params.equalsIgnoreCase("1")) {
                System.out.println("ConcreteHandlerA handle request!");
            } else {
                if (mSuccessor != null)
                    mSuccessor.handlerRequest(params);
            }
        }
    }

    public static class ConcreteHandlerB extends Handler {
        @Override
        public void handlerRequest(String params) {
            if (params.equalsIgnoreCase("2")) {
                System.out.println("ConcreteHandlerB handle request!");
            } else {
                if (mSuccessor != null)
                    mSuccessor.handlerRequest(params);
            }
        }
    }

}
