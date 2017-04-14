/**
 * 
 */
package com.huoli.checkin.base64;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月14日<br>
 */
public class JunitTest {

    /**
     *
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("setUpBeforeClass()");
    }

    /**
    *
    * @throws java.lang.Exception
    */
    @BeforeClass
    public static void setUpBeforeClass2() throws Exception {
        System.out.println("setUpBeforeClass2()");
    }

    /**
    *
    * @throws java.lang.Exception
    */
    @BeforeClass
    public static void setUpBeforeClass3() throws Exception {
        System.out.println("setUpBeforeClass3()");
    }

    /**
     *
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("tearDownAfterClass()");
    }

    /**
    *
    * @throws java.lang.Exception
    */
    @AfterClass
    public static void tearDownAfterClass2() throws Exception {
        System.out.println("tearDownAfterClass2()");
    }

    /**
    *
    * @throws java.lang.Exception
    */
    @AfterClass
    public static void tearDownAfterClass3() throws Exception {
        System.out.println("tearDownAfterClass3()");
    }

    /**
     *
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp()");
    }

    /**
     *
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown()");
    }

    @Test
    public void test() {
        System.out.println("test()");
    }

}
