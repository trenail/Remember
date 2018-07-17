package com.test.java.concurrent;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyOnWriteDemo {
    public static void main(String[] args) {
        final CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

//        copyOnWriteArrayList.add(1);
//        copyOnWriteArrayList.add(2);
//        copyOnWriteArrayList.add(3);
//
//
//        for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
//            if (copyOnWriteArrayList.get(i) == 1)
//                copyOnWriteArrayList.remove(i);
//        }
//
//        Iterator<Integer> integerIterator = copyOnWriteArrayList.iterator();
//        while (integerIterator.hasNext()) {
//            System.out.println(integerIterator.next());
//        }


        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    copyOnWriteArrayList.add(0, i);

                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < copyOnWriteArrayList.size(); i++) {

                    if (copyOnWriteArrayList.get(i) == 1) {
                        System.out.println("find : " + copyOnWriteArrayList.get(i));
                    }
                }

            }
        });

    }
}
