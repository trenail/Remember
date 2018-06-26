package com.test.remember;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by home on 2018/5/23.
 * 单元测试
 * <p>
 * junit 单元测试框架
 * runner 单元测试启动器,启动测试,生成报表
 * espresso 白盒测试,可以操作ui界面
 * <p>
 * 新建单元测试,光标移动到需要测试的类或者方法上,按control+shift+T,或者右键goto到Test

 * @see <a href="https://www.jianshu.com/p/b632bc870698">Android 单元测试第一篇（Junit4基础使用）</a>
 * @see <a href="https://www.jianshu.com/p/cc79bc3896cb">Android 单元测试第二篇（参数化测试）</a>
 * @see <a href="https://www.jianshu.com/p/77e824afa9ec">Android 单元测试第三篇（异常、超时测试）</a>
 * @see <a href="hhttps://www.jianshu.com/p/e1123180e6a9">Android 单元测试第四篇（一次执行多个单元测试）</a>
 * @see <a href="https://www.jianshu.com/p/f6dbd433a363">Android 单元测试第五篇(查看代码覆盖率及详情)</a>
 * @see <a href="https://www.jianshu.com/p/6f44a5e2bf5b">Android 单元测试第六篇(Hamcrest 匹配器)</a>
 */

@RunWith(Parameterized.class)
public class UnitTestTest {


    private UnitTest unitTest = null;

    int expected = 0;
    int input1 = 0;
    int input2 = 0;

    //使用 @Rule 设置全局超时时间
    @Rule
    public Timeout _timeOut = new Timeout(100, TimeUnit.MILLISECONDS); //全局超时限制

    @org.junit.runners.Parameterized.Parameters
    public static java.util.Collection<Object[]> data() {
        ArrayList<Object[]> list = new ArrayList<>();
        list.add(new Object[]{3, 1, 2});
        list.add(new Object[]{11, 4, 7});
        list.add(new Object[]{364, 341, 23});
        list.add(new Object[]{0, 0, 0});
        list.add(new Object[]{-5, -2, -3});
        return list;
    }

    public UnitTestTest(int expected, int input1, int input2) {
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Before
    public void setUp() throws Exception {
        unitTest = new UnitTest();
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        unitTest = null;
        System.out.println("tearDown");
    }

    @Test
    public void add1() throws Exception {
        assertEquals(2, unitTest.add());
        System.out.println("add1");
    }

    @Test
    public void add2() throws Exception {
        assertEquals(expected, unitTest.add(input1, input2));
    }

    @Test
    public void getContent() throws Exception {
        System.out.println(unitTest.getContent());
    }

    //预期异常,如果用例抛出预期异常,则表示用例通过
    @Test(expected = NullPointerException.class)
    public void testNullException() throws Exception {
        unitTest.testNullException(null);
    }


    public void testTimeout() throws Exception {
        unitTest.testTimeout();
    }

    @Test
    public void test1() {
        String str = null;
        System.out.println("----");
        str += "test";
        System.out.println(str);
        System.out.println("----");
    }
}