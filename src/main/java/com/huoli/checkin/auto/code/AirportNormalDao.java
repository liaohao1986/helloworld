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
 * @date: 2017年06月05日<br>
 * generated by CodeGenerator<br>
 */
public class AirportNormalDao extends JdbcDaoSupport {
	/**行映射器*/
	private RowMapper <AirportNormal> rowMapper = new RowMapper<AirportNormal>() {
		public AirportNormal mapRow(ResultSet rs, int rowNum) throws SQLException {
            AirportNormal airportNormal = new AirportNormal();
            airportNormal.setId(rs.getString("id"));
            airportNormal.setSerialNumber(rs.getString("serial_number"));
            airportNormal.setCity(rs.getString("city"));
            airportNormal.setHeadCharacter(rs.getString("head_character"));
            airportNormal.setCityJianpin(rs.getString("city_jianpin"));
            airportNormal.setCityPinyin(rs.getString("city_pinyin"));
            airportNormal.setCityAlias(rs.getString("city_alias"));
            airportNormal.setAirportFullName(rs.getString("airport_full_name"));
            airportNormal.setAirportShortName(rs.getString("airport_short_name"));
            airportNormal.setThreeWordsCode(rs.getString("three_words_code"));
            airportNormal.setAddress(rs.getString("address"));
            airportNormal.setPhone(rs.getString("phone"));
            airportNormal.setDistanceFromUrban(rs.getString("distance_from_urban"));
            airportNormal.setBusPrice(rs.getString("bus_price"));
            airportNormal.setSubwayPrice(rs.getString("subway_price"));
            airportNormal.setTaxiPrice(rs.getString("taxi_price"));
            airportNormal.setAirbuildingIntro(rs.getString("airbuilding_intro"));
            airportNormal.setAirbuildingPicture(rs.getString("airbuilding_picture"));
            airportNormal.setGeolat(rs.getString("geolat"));
            airportNormal.setGeolong(rs.getString("geolong"));
            airportNormal.setGeohash(rs.getString("geohash"));
            airportNormal.setCityGeolat(rs.getString("city_geolat"));
            airportNormal.setCityGeolong(rs.getString("city_geolong"));
            airportNormal.setFourWordsCode(rs.getString("four_words_code"));
            airportNormal.setCityname(rs.getString("cityname"));
            airportNormal.setStatus(rs.getString("status"));
			return airportNormal;
		}
	};
}