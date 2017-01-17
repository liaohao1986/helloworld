package com.huoli.checkin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.huoli.checkin.entity.MailChannel;

/**
 * 邮箱渠道数据库访问 <br>
 * 版权：Copyright (c) 2011-2016<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2016年11月28日<br>
 */
public class MailChannelDao extends JdbcDaoSupport {

    /** 行映射器 */
    private RowMapper<MailChannel> rowMapper = new RowMapper<MailChannel>() {
         public MailChannel mapRow(ResultSet rs, int rowNum) throws SQLException {
             MailChannel mailChannel = new MailChannel();
             mailChannel.setMail(rs.getString("mail"));
             mailChannel.setMailId(rs.getInt("mail_id"));
             mailChannel.setChannelId(rs.getInt("channel_id"));
             mailChannel.setChannel(rs.getString("channel"));
             return mailChannel;
         }
     };

    public List<MailChannel> queryUnusedEmailList() {
        String sql = "SELECT register_channel.id channel_id, register_mail.id mail_id, mail, name channel FROM register_mail JOIN register_channel LEFT JOIN register_mail_channel ON register_mail.id=register_mail_channel.mail_id AND register_channel.id=register_mail_channel.channel_id WHERE mail_id is NULL and register_channel.status=1 limit 3";
        return getJdbcTemplate().query(sql, rowMapper);
    }

    /**
     * 根据渠道获取未使用的邮箱地址
     *
     * @param channel
     * @return
     */
    public List<MailChannel> queryUnusedEmailListByChannel(String channel) {
        String sql = "SELECT register_channel.id channel_id, register_mail.id mail_id, mail, name channel FROM register_mail JOIN register_channel LEFT JOIN register_mail_channel ON register_mail.id=register_mail_channel.mail_id AND register_channel.id=register_mail_channel.channel_id WHERE mail_id is NULL AND name= ? and register_channel.status=1 limit 1";
        List<Object> args = new ArrayList<Object>();
        args.add(channel);
        return getJdbcTemplate().query(sql, rowMapper, args.toArray());
    }
    
    
    public MailChannel querySingleUnusedEmailByChannel(String channel) {
        String sql = "SELECT register_channel.id channel_id, register_mail.id mail_id, mail, name channel FROM register_mail JOIN register_channel LEFT JOIN register_mail_channel ON register_mail.id=register_mail_channel.mail_id AND register_channel.id=register_mail_channel.channel_id WHERE mail_id is NULL AND name= ? and register_channel.status=1 limit 1";
        List<Object> args = new ArrayList<Object>();
        args.add(channel);
        List<MailChannel> unusedEmailList = getJdbcTemplate().query(sql, rowMapper);
        return CollectionUtils.isNotEmpty(unusedEmailList) ? unusedEmailList.get(0) : null;
    }

    public int closeChannel(String channel) {
        String sql = "update register_channel set status=0 where name=?";
        return getJdbcTemplate().update(sql, channel);
    }

    /**
     * 保存邮箱渠道数据
     *
     * @param channel
     * @return
     */
    public int save(MailChannel mailChannel) {
        String sql = "INSERT INTO register_mail_channel (mail_id, channel_id) VALUES (?, ?)";
        return getJdbcTemplate().update(sql, mailChannel.getMailId(), mailChannel.getChannelId());
    }
}
