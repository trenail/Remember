package com.test.java.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by home on 2018/5/22.
 * 组合模式
 * <p>
 * 组合多个对象形成树形结构以表示具有“整体—部分”关系的层次结构。
 * 组合模式对单个对象（即叶子对象）和组合对象（即容器对象）的使用具有一致性
 * <p>
 * 组合模式又可以称为“整体—部分”(Part-Whole)模式，它是一种对象结构型模式。
 * <p>
 * 组合模式具体又分为安全组合模式和透明组合模式,这里介绍的是安全组合模式
 */

public class Composite {
    public static void main(String[] args) {
        MyComposite component = new MyComposite();
        component.add(new Leaf());
        component.operation();
    }

    public interface Component {
        void operation();
    }

    public static class Leaf implements Component {

        @Override
        public void operation() {
            System.out.println("Leaf->operation");
        }
    }

    public interface AbstractComposite extends Component {
        void add(Component component);

        void remove(Component component);

        Component getChild(int index);
    }

    public static class MyComposite implements AbstractComposite {

        List<Component> list = new ArrayList<>();

        @Override
        public void operation() {
            for (Component component : list) {
                component.operation();
            }
        }

        @Override
        public void add(Component component) {
            list.add(component);
        }

        @Override
        public void remove(Component component) {
            list.remove(component);
        }

        @Override
        public Component getChild(int index) {
            return list.get(index);
        }
    }
}
