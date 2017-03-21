/**
 * 
 */
package com.huoli.checkin.dao.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.huoli.checkin.entity.mongo.FfpCardResult;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
@Component
public class FfpCardResultDao extends AbstractDao<FfpCardResult> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public FfpCardResult findOne(Query query, String collectionName) {
        return mongoTemplate.findOne(query, FfpCardResult.class, collectionName);
    }

    @Override
    public List<FfpCardResult> findAll(Query query) {
        return mongoTemplate.find(query, FfpCardResult.class);
    }

    @Override
    public List<FfpCardResult> findAll(Query query, String collectionName) {
        return mongoTemplate.find(query, FfpCardResult.class, collectionName);
    }

    @Override
    public void insert(FfpCardResult objectToSave) {
        mongoTemplate.insert(objectToSave);
    }
}
