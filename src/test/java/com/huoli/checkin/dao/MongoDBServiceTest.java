/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.huoli.checkin.ContextHolder;
import com.huoli.checkin.entity.CheckinResult;
import com.huoli.checkin.service.MongoDBService;
import com.huoli.checkin.service.MongoDBServiceImpl;

/**
 *
 * @author Administrator
 * @version $Id: MongoDBServiceTest.java, v 0.1 2017年3月17日 下午10:17:04 Administrator Exp $
 */
public class MongoDBServiceTest {

    private static final Logger logger         = LoggerFactory.getLogger(MongoDBServiceTest.class);

    private MongoDBService      mongoDBService = ContextHolder.applicationContext
                                                   .getBean(MongoDBServiceImpl.class);

    /**
     *
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        logger.debug("setUpBeforeClass");
    }

    /**
     *
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        logger.debug("tearDownAfterClass");
    }

    /**
     *
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        logger.debug("setUp");
    }

    /**
     *
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        logger.debug("tearDown");
    }

    @Test
    public void test() {
        logger.debug("test");
        Criteria criteria = new Criteria();
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("phoneNumber", "15020083013");
        for (Entry<String, Object> entry : paramMap.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        Query query = new Query(criteria);

        List<CheckinResult> resultList = mongoDBService.find(CheckinResult.class, query);
        logger.info("result:{}", JSON.toJSONString(resultList));
        logger.info("size:{}", resultList.size());
    }

}
