package com.huoli.checkin.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.huoli.checkin.ContextHolder;
import com.huoli.checkin.dao.mongo.MongoTemplateDao;
import com.huoli.checkin.entity.CheckinResult;

public class CheckinResultDaoTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckinResultDaoTest.class);

    @SuppressWarnings("unchecked")
    private MongoTemplateDao<CheckinResult> mongonDao = ContextHolder.applicationContext.getBean(MongoTemplateDao.class);

    //    @SuppressWarnings("unchecked")
    //    private MongoDBService mongoDBService = ContextHolder.applicationContext.getBean(MongoDBService.class);

    @Test
    public void test1() throws Exception {
        //		Date queryDate = DateTimeUtil.addDay(new Date(), -1);
        //		// 取出前一小时或前一天的数据
        //		Criteria criteria = Criteria.where("sysDate").gt(queryDate);
        //		Query query = new Query(criteria);

        Map<String, Object> paramMap = Maps.newHashMap();
        //        paramMap.put("userId", "9069628");
        //        paramMap.put("userId", "9433928");

        //        ObjectId objectId = new ObjectId("5721de480cf220674c193ad8");
        //        paramMap.put("_id", objectId);

        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : paramMap.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        Query query = new Query(criteria);

        //        List<CheckinResult> resultList =  mongoDBService.find(CheckinResult.class, query);
        //List<CheckinResult> resultList = mongonDao.findAll(query, CheckinResult.class);
        List<CheckinResult> resultList = mongonDao.findList(CheckinResult.class, query, 10, 50);
        //		List<FfpCardResult> ffpList = hourlyDao.query(query, CheckinResult.class);
        logger.info("result:{}", JSON.toJSONString(resultList));
        logger.info("size:{}", resultList.size());
    }
}
