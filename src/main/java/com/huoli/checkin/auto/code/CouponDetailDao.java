package com.huoli.checkin.auto.code;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 * <br>
 * 版权: Copyright (c) 2011-2017<br>
 * 公司: 北京活力天汇<br>
 * 
 * @author: 廖浩<br>
 * @date: 2017年08月08日<br>
 * generated by CodeGenerator<br>
 */
public class CouponDetailDao extends JdbcDaoSupport {
	/**行映射器*/
	private RowMapper <CouponDetail> rowMapper = new RowMapper<CouponDetail>() {
		public CouponDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
            CouponDetail couponDetail = new CouponDetail();
            couponDetail.setId(rs.getLong("id"));
            couponDetail.setType(rs.getInt("type"));
            couponDetail.setCouponId(rs.getString("coupon_id"));
            couponDetail.setAmount(rs.getString("amount"));
            couponDetail.setFrom(rs.getString("from"));
            couponDetail.setTo(rs.getString("to"));
            couponDetail.setExpiryBeginDate(rs.getString("expiry_begin_date"));
            couponDetail.setExpiryEndDate(rs.getString("expiry_end_date"));
            couponDetail.setTitle(rs.getString("title"));
            couponDetail.setDesc(rs.getString("desc"));
            couponDetail.setRule(rs.getString("rule"));
            couponDetail.setExtData(rs.getString("ext_data"));
            couponDetail.setCreatetime(rs.getTimestamp("createtime"));
            couponDetail.setUpdatetime(rs.getTimestamp("updatetime"));
			return couponDetail;
		}
	};
}