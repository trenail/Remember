package com.test.java.pattern;

/**
 * Created by home on 2018/5/18.
 * 建造者模式
 * <p>
 * 将一个复杂对象的构建与它的表示分离，
 * 使得同样的构建过程可以创建不同的表示。
 * <p>
 * 建造者模式是一种对象创建型模式
 */

public class Builder {

   public static void main(String[] args) {
        Director director = new Director();

        director.setBuilder(new ConcreteBuilder());

        Product product = director.construct();

        System.out.println(product.partA);
        System.out.println(product.partB);
        System.out.println(product.partC);
    }

    public static class Product {
        public String partA;
        public String partB;
        public String partC;
    }

    public static abstract class ProductBuilder {
        //创建产品对象
        protected Product product = new Product();

        public abstract void buildPartA();

        public abstract void buildPartB();

        public abstract void buildPartC();

        //返回产品对象
        public Product getResult() {
            return product;
        }
    }

    public static class ConcreteBuilder extends ProductBuilder {

        @Override
        public void buildPartA() {
            product.partA = "partA 1";
        }

        @Override
        public void buildPartB() {
            product.partB = "partB 1";
        }

        @Override
        public void buildPartC() {
            product.partC = "partC 1";
        }
    }

    public static class Director {

        private ProductBuilder builder;

        public ProductBuilder getBuilder() {
            return builder;
        }

        public void setBuilder(ProductBuilder builder) {
            this.builder = builder;
        }

        public Product construct() {
            builder.buildPartA();
            builder.buildPartB();
            builder.buildPartC();
            return builder.getResult();
        }
    }


}
