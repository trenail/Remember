package com.test.remember;

/**
 * Created by home on 2018/5/23.
 */

public class UnitTest {
    public String getContent() {
        return "hello unit test!";
    }

    public int add() {
        return 1 + 1;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public void testNullException(String msg) {
        System.out.println(msg.length());
    }

    public void testTimeout() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("testTimeout");
    }
}
