/**
 * 
 */
package com.huoli.checkin.jdbc;

import java.util.Set;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
@Deprecated
public class MongoDBJDBC {
    public static void main(String[] args) {
        MongoClient mongoClient = null;
        try {
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址    
            //ServerAddress()两个参数分别为 服务器地址 和 端口    
            //            ServerAddress serverAddress = new ServerAddress("120.133.0.162", 27017);
            //            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            //            addrs.add(serverAddress);

            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码    
            //            MongoCredential credential = MongoCredential.createScramSha1Credential("admin", "checkin", "ChePas92".toCharArray());
            //            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            //            credentials.add(credential);
            //
            //            //通过连接认证获取MongoDB连接    
            //            MongoClient mongoClient = new MongoClient(addrs, credentials);
            mongoClient = new MongoClient(new MongoClientURI("mongodb://checkin:ChePas92@120.133.0.162:27017/admin"));
            DB db = mongoClient.getDB("checkin");
            Set<String> collectionNameSet = db.getCollectionNames();
            for (String collectionName : collectionNameSet) {
                System.out.println(collectionName);
            }
            System.out.println(db.getCollectionNames().size());

            //连接到数据库    
            //            MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");
            System.out.println("Connect to database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
        }
    }
}
