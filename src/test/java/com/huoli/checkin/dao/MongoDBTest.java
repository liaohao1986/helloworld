/**
 * 
 */
package com.huoli.checkin.dao;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.huoli.checkin.ContextHolder;
import com.huoli.checkin.dao.mongo.CheckinResultDao;
import com.huoli.checkin.entity.CheckinResult;

public class MongoDBTest {

    private Logger logger = LoggerFactory.getLogger(MongoDBTest.class);

    private MongoTemplate mongoTemplate = (MongoTemplate) ContextHolder.applicationContext.getBean("mongoTemplate");

    //    @Test
    //    public void testSave() {
    //        /*Book book = new Book();
    //        book.setId(2);
    //        book.setBookName("建筑的永恒之道");
    //        book.setPrice(30.6d);
    //        mongoDBService.save(book);*/
    //        
    //        for(int i=3;i<50;i++) {
    //            Book book = new Book();
    //            book.setId(i);
    //            book.setBookName("建筑的永恒之道"+i);
    //            book.setPrice(new Random().nextDouble()*100);
    //            mongoDBService.save(book);
    //        }
    //    }

    @Test
    public void testQuery1() {

        Map<String, Object> paramMap = Maps.newHashMap();
        //        paramMap.put("userId", "9069628");
        //        paramMap.put("userId", "9433928");

        ObjectId objectId = new ObjectId("5721de480cf220674c193ad8");
        paramMap.put("_id", objectId);

        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : paramMap.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        Query query = new Query(criteria);
        List<CheckinResult> resultList = mongoTemplate.find(query, CheckinResult.class);

        Integer listSize = resultList.size();

        logger.debug(JSON.toJSONString(resultList));
        logger.debug("{}", listSize);
    }

    //    @Test
    //    public void testQuery2() {
    //        List<Book> books = mongoDBService.findAll(Book.class);
    //        for(Book book : books) {
    //            System.out.println(book.getBookName());
    //        }
    //    }
    //    
    //    @Test
    //    public void testQuery3() {
    //        Query query = new Query();
    //        query.addCriteria(Criteria.where("price").gt(40.0d));
    //        List<Book> books = mongoDBService.find(Book.class,query);
    //        for(Book book : books) {
    //            System.out.println(book.getBookName()+"----"+book.getPrice());
    //        }
    //    }
    //    
    //    @Test
    //    public void testQuery4() {
    //        Query query = new Query();
    //        Pagination<Book> pagination = mongoDBService.getPagination(Book.class, query, 1, 10);
    //        for(Book book : pagination.getRecordList()) {
    //            System.out.println(book.getBookName()+"----"+book.getPrice());
    //        }
    //    }
    //    
    //    @Test
    //    public void testUpdate() {
    //        Query query = new Query();
    //        query.addCriteria(Criteria.where("id").is(10));
    //        Update update = new Update();
    //        update.set("bookName", "编程珠玑");
    //        update.set("price", 100.0d);
    //        int i = mongoDBService.update(query, update, Book.class);
    //        System.out.println(i);
    //        
    //    }
}
