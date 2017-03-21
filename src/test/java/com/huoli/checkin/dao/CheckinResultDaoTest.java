package com.huoli.checkin.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.huoli.checkin.ContextHolder;
import com.huoli.checkin.dao.mongo.MongoTemplateWrapper;
import com.huoli.checkin.entity.mongo.CheckinResult;
import com.huoli.checkin.entity.mongo.ReserveResult;

public class CheckinResultDaoTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckinResultDaoTest.class);

    @SuppressWarnings("unchecked")
    private MongoTemplateWrapper<CheckinResult> checkinMongonDao = ContextHolder.applicationContext.getBean(MongoTemplateWrapper.class);

    @SuppressWarnings("unchecked")
    private MongoTemplateWrapper<ReserveResult> reserveMongonDao = ContextHolder.applicationContext.getBean(MongoTemplateWrapper.class);

    //    @SuppressWarnings("unchecked")
    //    private MongoDBService mongoDBService = ContextHolder.applicationContext.getBean(MongoDBService.class);

    @Test
    public void test1() throws Exception {
        //		Date queryDate = DateTimeUtil.addDay(new Date(), -1);
        //		// 取出前一小时或前一天的数据
        //		Criteria criteria = Criteria.where("sysDate").gt(queryDate);
        //		Query query = new Query(criteria);

        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("airlineCode", "CZ");
        //        paramMap.put("userId", "9433928");

        //        ObjectId objectId = new ObjectId("5721de480cf220674c193ad8");
        //        paramMap.put("_id", objectId);

        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : paramMap.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        criteria.andOperator(Criteria.where("sysDate").lt("2017-03-19").gt("2017-03-20"));
//        query(where("age").lt(50)
//            .and("accounts.balance").gt(1000.00d)
//        criteria.gt(o)
//       
//        criteria.gte(Criteria.where("sysDate").is("2017-03-20"));
//        criteria.lt(Criteria.where("sysDate").is("2017-03-21"));
//        criteria.and("sysDate").gt("2017-03-19");
        Query query = new Query(Criteria.where("sysDate").gt("2017-03-19"));
//        query.addCriteria(criteria);
        
//        Criteria criteria2 =new Criteria();
//
//        criteria.and("sysDate").gt("2017-03-20");
//        query.addCriteria(criteria2);
//        query.addCriteria(new Criteria("sysDate").lt("2017-03-19"));
//        query.addCriteria(new Criteria("sysDate").lt("2017-03-21"));
        query.with(new Sort(new Order(Direction.DESC, "sysDate")));
        //        List<CheckinResult> resultList =  mongoDBService.find(CheckinResult.class, query);
        //List<CheckinResult> resultList = mongonDao.findAll(query, CheckinResult.class);
        long size = checkinMongonDao.count(query, CheckinResult.class);
        List<CheckinResult> resultList = checkinMongonDao.findList(CheckinResult.class, query, 3, 20);
        //		List<FfpCardResult> ffpList = hourlyDao.query(query, CheckinResult.class);
        logger.info("result:{}", JSON.toJSONString(resultList));
        logger.info("size:{}", size);
    }

    @Test
    public void test2() throws Exception {
        Map<String, Object> paramMap = Maps.newHashMap();
        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : paramMap.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        Query query = new Query(criteria);
        query.with(new Sort(new Order(Direction.DESC, "createTime")));
        List<ReserveResult> resultList = reserveMongonDao.findList(ReserveResult.class, query, 10, 50);
        logger.info("result:{}", JSON.toJSONString(resultList));
        logger.info("size:{}", resultList.size());
    }
}
