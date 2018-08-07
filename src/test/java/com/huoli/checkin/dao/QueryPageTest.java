package com.huoli.checkin.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huoli.checkin.auto.code.CodeGenerator;
import com.huoli.checkin.auto.code.JDBCConnectionUtil;

public class QueryPageTest {

    private static Logger logger = LoggerFactory.getLogger(CodeGenerator.class);
    private Connection connection;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        connection = JDBCConnectionUtil.getConnection("mysql");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        fail("Not yet implemented");
    }

}
