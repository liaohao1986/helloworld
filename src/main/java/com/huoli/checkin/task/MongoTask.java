package com.huoli.checkin.task;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.huoli.checkin.dao.mongo.AccountResultDao;
import com.huoli.checkin.dao.mongo.MongoTemplateDao;
import com.huoli.checkin.entity.CheckinResult;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
public class MongoTask {
    private Logger logger = LoggerFactory.getLogger(AutoRegisterTask.class);
    @Autowired
    private AccountResultDao accountResultDao;
    @Autowired
    private MongoTemplateDao<CheckinResult> checkinResultDao;

    public void test() {
        logger.debug("MongoTask测试");
        Map<String, Object> paramMap = Maps.newHashMap();
        //        paramMap.put("userId", "9069628");
        //        paramMap.put("userId", "9433928");

        ObjectId objectId = new ObjectId("5721de480cf220674c193ad8");
        paramMap.put("_id", objectId);
        //        AccountResult accountResult = accountResultDao.findOne(paramMap, MongoConstant.ACCOUNT_RESULT);
        //        logger.debug(JSON.toJSONString(accountResult));

        //                List<AccountResult> resultList = accountResultDao.findAll(paramMap, MongoConstant.ACCOUNT_RESULT);
        //        List<CheckinResult> resultList = checkinResultDao.findAll(paramMap);
        List<CheckinResult> resultList = checkinResultDao.findAll(paramMap, CheckinResult.class);
        logger.debug(JSON.toJSONString(resultList));
        logger.debug("{}", resultList.size());
    }

}
