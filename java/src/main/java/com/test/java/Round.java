package com.test.java;

/**
 * Created by home on 2018/5/9.
 * 四舍五入
 * <p>
 * Math.round() 默认使用  RoundingMode.ROUND_CEILING (向正无穷方向舍入)
 * 可以理解成 将舍去位加0.5,进位后直接舍去
 *
 * @see <a href="http://cmsblogs.com/?p=54">java提高篇（四）—java的四舍五入</a>
 */

public class Round {

    public static void main(String[] args) {

        System.out.println("12.5的四舍五入值：" + Math.round(12.5));
        System.out.println("-12.5的四舍五入值：" + Math.round(-12.5));

        //output
        //12.5的四舍五入值：13
        //-12.5的四舍五入值：-12

        //analysis
        //12.5 + 0.5 = 13.0 = 13
        //-12.5 + 0.5 = 12.0 = 12
    }

}
