package com.test.java.pattern;

/**
 * Created by home on 2018/5/26.
 * 装饰模式
 * <p>
 * 动态地给一个对象增加一些额外的职责，
 * 就增加对象功能来说，装饰模式比生成子类实现更为灵活。
 * <p>
 * 装饰模式是一种对象结构型模式
 */

public class Decorator {

    public interface Component {
        void operation();
    }

    public static class ConcreteComponent implements Component {

        @Override
        public void operation() {
            System.out.println("ConcreteComponent->operation()");
        }
    }

    public static class MyDecorator implements Component {

        private Component mComponent;

        public MyDecorator(Component component) {
            this.mComponent = component;
        }


        @Override
        public void operation() {
            mComponent.operation();
        }
    }

    public static class ConcreteDecorator extends MyDecorator {

        public ConcreteDecorator(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            super.operation();
            System.out.println("ConcreteDecorator->operation()");
        }

    }

    public static void main(String[] args) {
        Component concreteComponent = new ConcreteComponent();
        Component myDecorator = new ConcreteDecorator(concreteComponent);
        myDecorator.operation();
    }

}
