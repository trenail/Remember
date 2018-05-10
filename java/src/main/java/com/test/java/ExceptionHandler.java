package com.test.java;

/**
 * Created by home on 2018/5/9.
 * 异常处理执行顺序
 * <p>
 * Java 虚拟机会把 finally 语句块作为 子程序 直接插入到 try 语句块或者 catch 语句块的控制转移语句之前。
 * 但是，还有另外一个不可忽视的因素，那就是在执行 子程序（finally 语句块）之前，
 * try 或者 catch 语句块会保留其返回值到本地变量表（Local Variable Table）中。
 * 待 子程序 执行完毕之后，再恢复保留的返回值到操作数栈中，然后通过 return 或者 throw 语句将其返回给该方法的调用者
 *
 * @see <a href="hhttps://www.ibm.com/developerworks/cn/java/j-lo-finally/index.html">关于 Java 中 finally 语句块的深度辨析</a>
 */

public class ExceptionHandler {
    public static void main(String[] args) {

        int value = new ExceptionHandler().test1();
        System.out.println("main receive value :" + value);
        System.out.println("----------------------------");

        value = new ExceptionHandler().test2();
        System.out.println("main receive value :" + value);
        System.out.println("----------------------------");

        value = new ExceptionHandler().test3();
        System.out.println("main receive value :" + value);
        System.out.println("----------------------------");

        try {
            value = new ExceptionHandler().test4();
            System.out.println("main receive value :" + value);

        } catch (Exception e) {
            System.out.println("test4 Exception Message:" + e.getMessage());
        } finally {
            System.out.println("----------------------------");
        }

        value = new ExceptionHandler().test5();
        System.out.println("main receive value :" + value);
        System.out.println("----------------------------");

        value = new ExceptionHandler().test6();
        System.out.println("main receive value :" + value);
        System.out.println("----------------------------");

        value = new ExceptionHandler().test7();
        System.out.println("main receive value :" + value);
        System.out.println("----------------------------");

    }

    public int test1() {
        try {
            System.out.println("test1 on try");
            System.out.println("test1 on return");
            return 1;
        } finally {
            System.out.println("test1 on finally");
        }
    }

    public int test2() {
        try {
            System.out.println("test2 on try");
            System.out.println("test2 on return");
            return 1;
        } finally {
            System.out.println("test2 on finally");
        }
    }

    public int test3() {
        try {
            System.out.println("test3 on try");

            System.out.println("test3 Throw Exception");
            int a = 3 / 0;
            System.out.println("test3 on return");
            return 1;
        } catch (java.lang.Exception e) {
            System.out.println("test3 on catch");
            return 0;
        } finally {
            System.out.println("test3 on finally");
        }
    }

    public int test4() {
        try {
            System.out.println("test4 on try");

            System.out.println("test4 Throw Exception");
            System.out.println(3 / 0);
            System.out.println("test4 on return");
            return 1;
        } catch (java.lang.Exception e) {
            System.out.println("test4 on catch");
            System.out.println("test4 Throw Exception");
            System.out.println(3 / 0);
            return 0;
        } finally {
            System.out.println("test4 on finally");
        }
    }

    public int test5() {
        try {
            System.out.println("test5 on try");
            System.out.println(3 / 0);

        } catch (java.lang.Exception e) {
            System.out.println("test5 on catch");
            return 1;

        } finally {
            System.out.println("test5 on finally");

        }

        return 3;
    }

    public int test6() {
        try {
            System.out.println("test6 on try");
            return 1;
        } finally {
            System.out.println("test6 on finally");
            return 2;
        }
    }

    public int test7() {
        int value = 0;
        try {
            System.out.println("test7 on try");
            return value;
        } finally {
            System.out.println("test7 on finally");
            ++value;
        }
    }
}
