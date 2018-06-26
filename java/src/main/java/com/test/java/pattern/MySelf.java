package com.test.java.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by home on 2018/6/6.
 * 对话
 */

public class MySelf {

    public static void main(String[] args) {
        boolean flag = true;

        final MySelf mySelf = new MySelf();

        System.out.println("start listen");

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    mySelf.listen();
                }
            }
        }).start();

        System.out.println("start thinking");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    mySelf.thinking();
                }
            }
        }).start();


    }

    private List<String> listenMemory = new ArrayList<>();

    private List<String> talkMemory = new ArrayList<>();


    public void addMemory(String message) {
        System.out.println("我听到了:" + message);
        listenMemory.add(message);
    }

    public void talk(String message) {
        talkMemory.add(message);
        System.out.println("我说:" + message);
    }

    public void listen() {
        Scanner in = new Scanner(System.in);
        String message = in.next();
        addMemory(message);
    }

    public void thinking() {

    }


}
