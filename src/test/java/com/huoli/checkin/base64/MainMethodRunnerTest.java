package com.huoli.checkin.base64;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;

public class MainMethodRunnerTest {
    public static void main(String[] args) {
        //        new Thread() {
        //            public void run() {
        //                JUnitCore.runClasses(new Class[] { APerfomanceTest.class });
        //            }
        //        }.start();

//        new Thread() {
//            public void run() {
                new JUnitCore().run(Request.method(MainMethodRunnerTest.class, "test"));
//            }
//        }.start();
    }

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

    @Test
    public void test2() {
        System.out.println("test2()");
    }

    @Test
    @Ignore
    public void test3() {
        System.out.println("test3()");
    }
}
