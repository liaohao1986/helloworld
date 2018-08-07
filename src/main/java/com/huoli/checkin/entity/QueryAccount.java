package com.huoli.checkin.entity;

import com.alibaba.fastjson.JSON;

/**
 * 查询账号实体类<br>
 * 版权：Copyright (c) 2011-2016<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2016年11月29日<br>
 */
public class QueryAccount {

    private Integer id;
    /** 邮箱地址 */
    private String  type;
    /** 邮箱地址 */
    private String  username;
    /** 邮箱地址 */
    private String  password;
    /** 邮箱地址 */
    private String  name;
    /** 邮箱地址 */
    private String  extData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtData() {
        return extData;
    }

    public void setExtData(String extData) {
        this.extData = extData;
    }

    /** 
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
