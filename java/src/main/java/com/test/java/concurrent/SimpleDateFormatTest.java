package com.test.java.concurrent;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * SimpleDateFormat 的线程安全问题
 *
 * @see <a href="https://www.jianshu.com/p/6546cdeab48e" />
 * @see <a href="http://tech.lede.com/2017/04/28/rd/server/SimpleDateFormatConcurrentDanger/" />
 *
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String dateTime = "2016-12-30 15:35:34";
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        try {
                            System.out.println(
                                    Thread.currentThread().getName() + "\t" + dateFormat.parse(dateTime));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

}
