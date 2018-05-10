package com.test.java;

/**
 * Created by home on 2018/5/9.
 * <p>
 * 代码块
 * <p>
 * 代码块就是用大括号{}将多行代码封装在一起
 * <p>
 * 在Java中代码块主要分为四种:
 * 1.普通代码块
 * 2.静态代码块
 * 3.同步代码块
 * 4.构造代码块
 *
 * @see <a href="http://cmsblogs.com/?p=72">java提高篇（十二）—–代码块</a>
 */

public class CodeBlock {

    static {
        System.out.println("2.静态代码块");
    }

    public void test() {
        System.out.println("1.普通代码块");
    }

    public void synchronizedTest() {
        System.out.println("3.同步代码块");
    }

    {
        System.out.println("4.构造代码块");
    }

    public CodeBlock(){
        System.out.println("构造函数");
    }

    public static void main(String[] args) {
        new CodeBlock().test();

        //output
        //2.静态代码块
        //4.构造代码块
        //构造函数
        //1.普通代码块
    }

}
