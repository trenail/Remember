package com.test.java.pattern;

/**
 * Created by home on 2018/6/5.
 * <p>
 * 命令模式
 * <p>
 * 将一个请求封装为一个对象，从而让我们可用不同的请求对客户进行参数化；
 * 对请求排队或者记录请求日志，以及支持可撤销的操作。
 * <p>
 * 命令模式是一种对象行为型模式，其别名为动作(Action)模式或事务(Transaction)模式
 */

public class Command {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setCommand(new ConcreteCommand());
        invoker.call();
    }

    public static class Invoker {
        private MyCommand command;

        public MyCommand getCommand() {
            return command;
        }

        public void setCommand(MyCommand command) {
            this.command = command;
        }

        public void call() {
            command.execute();
        }

    }

    public interface MyCommand {
        void execute();
    }

    public static class ConcreteCommand implements MyCommand {

        private Receiver receiver = new Receiver();

        @Override
        public void execute() {
            System.out.println("ConcreteCommand->execute()");
            receiver.action();
        }
    }

    public static class Receiver {
        public void action() {
            System.out.println("Receiver->action()");
        }
    }


}
