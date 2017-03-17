/**
 * 
 */
package com.huoli.checkin.dao.mongo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.huoli.checkin.entity.CheckinResult;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
@Component
public class CheckinResultDao extends AbstractDao<CheckinResult> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public CheckinResult findOne(Query query, String collectionName) {
        return mongoTemplate.findOne(query, CheckinResult.class, collectionName);
    }

    @Override
    public List<CheckinResult> findAll(Query query) {
        return mongoTemplate.find(query, CheckinResult.class);
    }

    @Override
    public List<CheckinResult> findAll(Query query, String collectionName) {
        return mongoTemplate.find(query, CheckinResult.class, collectionName);
    }

    //    public Page<CheckinResult> paginationQuery(Integer pageNum) {
    //
    //        SpringDataPageable pageable = new SpringDataPageable();
    //        Query query = new Query();
    //        List<Order> orders = new ArrayList<Order>();  //排序
    //        orders.add(new Order(Direction.DESC, "age"));
    //        Sort sort = new Sort(orders);
    //
    //        // 开始页
    //        pageable.setPagenumber(pageNum);
    //        // 每页条数
    //        pageable.setPagesize(10);
    //        // 排序
    //        pageable.setSort(sort);
    //        // 查询出一共的条数
    //        Long count = mongoTemplate.count(query, Person.class);
    //        // 查询
    //        List<Person> list = mongoTemplate.find(query.with(pageable), Person.class);
    //        // 将集合与分页结果封装
    //        Page<Person> pagelist = new PageImpl<Person>(list, pageable, count);
    //
    //        return pagelist;
    //    }

    @Override
    public void insert(CheckinResult objectToSave) {
        mongoTemplate.insert(objectToSave);
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

}
