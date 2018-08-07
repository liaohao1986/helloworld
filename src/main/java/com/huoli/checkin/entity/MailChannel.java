package com.huoli.checkin.entity;

import com.alibaba.fastjson.JSON;

/**
 * 邮箱渠道实体类<br>
 * 版权：Copyright (c) 2011-2016<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2016年11月29日<br>
 */
public class MailChannel {

    private Integer id;
    /** 邮箱地址 */
    private String  mail;
    /** 邮箱地址id */
    private Integer mailId;
    /** 渠道名称 */
    private String  channel;
    /** 渠道名称id */
    private Integer channelId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getMailId() {
        return mailId;
    }

    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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
