package com.huoli.checkin.design.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.huoli.utils.StringUtil;

public class AirPort implements RowMapper<AirPort> {
	/** 机场三字码 */
	private String code;

	/** 机场四字码 */
	private String fourCode;

	/** 国家 默认“中国” */
	private String country = "中国";

	/** 国家代码 默认“CN” */
	private String countryCode = "CN";

	/** 城市名，只有城市的名称 */
	private String city;

	/** 城市三字码 */
	private String cityCode;

	/** 城市中文名称 */
	private String cityname;

	/** 城市英文名称 */
	private String cityen;

	/** 城市拼音 */
	private String cityPinyin;

	/** 城市简拼 */
	private String cityjianpin;

	/** 机场名称 */
	private String airportName;

	/** 机场英文名称 */
	private String airportEn;

	/** 机场简称 */
	private String airportReferred;

	/** 机场精简名称 */
	private String airportAbridge;

	/** 机场拼音 */
	private String airportPinyin;

	/** 机场简拼 */
	private String airportJianpin;

	/** 机场六字简称 */
	private String sixName;

	/** 机场十字简称 */
	private String tenName;

	/** 对应时区 默认“GMT+8” */
	private String timezone;

	// /** 对应夏令时 暂时无用*/
	// private String daylightSaving;

	/** 对应java时区与夏令时 默认“Asia/Shanghai(亚洲/上海)” */
	private String javaTimeZone;

	/** 是否为国内 0为否 1为是 默认是 */
	private int nation;

	/** 是否为热门 0为否 1为是 默认否 */
	private int hotFlag;

	/** 是否为动态热门城市 0为否 1为是 默认否 这里为了区分北京，上海，重庆 国内3个城市多机场情况 */
	private int dthotFlag;

	/** 热门城市排序 */
	private int hotSeq;

	/** 是否为旅游 0为否 1为是 默认否 国际机场无 */
	private int travelFlag;

	/** 旅游城市排序 国际机场无 */
	private int travelSeq;

	/** 是否有机场详细信息 0为否 1为是 默认否 */
	private int flag;

	/** 机场电话 国际机场无 */
	private String phone;

	/** 经度 */
	private double geolat;

	/** 纬度 */
	private double geolong;

	/** 省份 */
	private String province;

	/** 机场别名 */
	private String aliases;

	/** 城市别名 */
	private String cityAliases;

	/** 数据版本 国际机场提供 */
	private double cver;

	/** 状态 0:新增，1：修改，2：删除 默认"0" */
	private int status;

	/** 搜索匹配 */
	private String searchMatch;

	/** 排序 不要大于热门排序 */
	private int seq;

	/** 有效开始时间 */
	private Date validFrom;

	/** 有效截止时间 */
	private Date validTo;

	/** 国家三字码 */
	private String countryThreeWordsCode;

	/** 国家三字码 */
	private String regionCode;

	/** 标签 */
	private String tags;

	@Override
	public AirPort mapRow(ResultSet rs, int rowNum) throws SQLException {
		this.code = rs.getString("THREE_WORDS_CODE");
		this.fourCode = rs.getString("FOUR_WORDS_CODE");

		this.country = "中国";
		this.countryCode = "CN";
		this.cityname = rs.getString("CITY_NAME");
		this.city = rs.getString("CITY");
		this.cityCode = rs.getString("CITY_CODE");
		this.cityen = rs.getString("EN_CITY_NAME");
		this.cityPinyin = rs.getString("CITY_PINYIN");
		this.cityjianpin = rs.getString("CITY_JIANPIN");

		this.airportName = rs.getString("AIRPORT_FULL_NAME");
		// 国内机场没有 机场拼音与机场简拼
		// this.airportPinyin = rs.getString("AIRPORT_PINYIN");
		// this.airportJianpin = rs.getString("AIRPORT_JIANPIN");
		this.airportEn = rs.getString("CITY_PINYIN");
		this.airportReferred = rs.getString("AIRPORT_SHORT_NAME");
		this.airportAbridge = rs.getString("AIPPORT_ABRIDGE_NAME");
		this.sixName = rs.getString("AIRPORT_SIX_NAME");
		this.tenName = rs.getString("AIRPORT_TEN_NAME");

		this.timezone = rs.getString("TIMEZONE");
		this.javaTimeZone = rs.getString("JAVA_TIMEZONE");
		this.nation = 1;

		this.hotFlag = rs.getInt("HOTFLAG");
		this.hotSeq = rs.getInt("HOTSEQ");
		this.dthotFlag = this.hotFlag;
		this.travelFlag = rs.getInt("TRAVELFLAG");
		this.travelSeq = rs.getInt("TRAVELSEQ");
		this.flag = rs.getInt("flag");

		String phone = null;// rs.getString("phone");
		if (!StringUtil.equals(phone, "null", "-", "暂无数据")) {
			this.phone = phone;
		}
		this.geolat = rs.getDouble("GEO_LAT");
		this.geolong = rs.getDouble("GEO_LON");
		this.province = rs.getString("PROVINCE");
		this.aliases = rs.getString("ALIASES");
		this.cityAliases = rs.getString("CITY_ALIASES");
		this.searchMatch = rs.getString("SEARCH_MATCH");
		this.validFrom = rs.getTimestamp("valid_from");
		this.validTo = rs.getTimestamp("valid_to");
		this.countryThreeWordsCode = "CHN";
		this.regionCode = "AS";
		this.tags = rs.getString("TAGS");
		return this;
	}

	public AirPort mapRowInter(ResultSet rs, int rowNum) throws SQLException {
		this.code = rs.getString("THREE_WORDS_CODE");
		this.fourCode = rs.getString("FOUR_WORDS_CODE");

		this.country = rs.getString("COUNTRY");
		this.countryCode = rs.getString("COUNTRY_CODE");
		this.cityname = rs.getString("CITYNAME");
		this.city = this.cityname;
		this.cityCode = rs.getString("CITY_CODE");
		this.cityen = rs.getString("CITYEN");
		this.cityPinyin = rs.getString("CITY_PINYIN");
		this.cityjianpin = rs.getString("CITY_JIANPIN");

		this.airportName = rs.getString("AIRPORT_NAME");
		this.airportPinyin = rs.getString("AIRPORT_PINYIN");
		this.airportJianpin = rs.getString("AIRPORT_JIANPIN");
		this.airportEn = rs.getString("AIRPORT_NAME_EN");
		// 国际机场没有简称 使用城市名代替
		this.airportReferred = rs.getString("REFERRED");
		this.airportAbridge = this.cityname;
		this.sixName = this.cityname;
		this.tenName = this.cityname;

		this.timezone = rs.getString("TIMEZONE");
		// this.daylightSaving = rs.getString("DAYLIGHT_SAVING");
		this.javaTimeZone = rs.getString("JAVA_TIMEZONE");

		this.nation = 0;
		this.hotFlag = rs.getInt("HOT");
		this.dthotFlag = 0;
		this.hotSeq = rs.getInt("HOTSEQ");
		this.flag = 0;

		this.geolat = rs.getDouble("LATITUDE");
		this.geolong = rs.getDouble("LONGITUDE");
		this.aliases = rs.getString("ALIASES");
		this.cityAliases = rs.getString("CITY_ALIASES");
		this.cver = rs.getDouble("CVER");
		this.status = rs.getInt("STATUS");
		this.searchMatch = rs.getString("SEARCH_MATCH");
		this.seq = rs.getInt("seq");
		this.validFrom = rs.getTimestamp("VALID_FROM");
		this.validTo = rs.getTimestamp("VALID_TO");
		this.countryThreeWordsCode = rs.getString("COUNTRY_THREE_WORDS_CODE");
		this.regionCode = rs.getString("REGION_CODE");
		this.tags = rs.getString("TAGS");
		return this;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFourCode() {
		return fourCode;
	}

	public void setFourCode(String fourCode) {
		this.fourCode = fourCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getCityen() {
		return cityen;
	}

	public void setCityen(String cityen) {
		this.cityen = cityen;
	}

	public String getCityPinyin() {
		return cityPinyin;
	}

	public void setCityPinyin(String cityPinyin) {
		this.cityPinyin = cityPinyin;
	}

	public String getCityjianpin() {
		return cityjianpin;
	}

	public void setCityjianpin(String cityjianpin) {
		this.cityjianpin = cityjianpin;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportEn() {
		return airportEn;
	}

	public void setAirportEn(String airportEn) {
		this.airportEn = airportEn;
	}

	public String getAirportReferred() {
		return airportReferred;
	}

	public void setAirportReferred(String airportReferred) {
		this.airportReferred = airportReferred;
	}

	public String getAirportAbridge() {
		return airportAbridge;
	}

	public void setAirportAbridge(String airportAbridge) {
		this.airportAbridge = airportAbridge;
	}

	public String getAirportPinyin() {
		return airportPinyin;
	}

	public void setAirportPinyin(String airportPinyin) {
		this.airportPinyin = airportPinyin;
	}

	public String getAirportJianpin() {
		return airportJianpin;
	}

	public void setAirportJianpin(String airportJianpin) {
		this.airportJianpin = airportJianpin;
	}

	public String getSixName() {
		return sixName;
	}

	public void setSixName(String sixName) {
		this.sixName = sixName;
	}

	public String getTenName() {
		return tenName;
	}

	public void setTenName(String tenName) {
		this.tenName = tenName;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getJavaTimeZone() {
		return javaTimeZone;
	}

	public void setJavaTimeZone(String javaTimeZone) {
		this.javaTimeZone = javaTimeZone;
	}

	public int getNation() {
		return nation;
	}

	public void setNation(int nation) {
		this.nation = nation;
	}

	public int getHotFlag() {
		return hotFlag;
	}

	public void setHotFlag(int hotFlag) {
		this.hotFlag = hotFlag;
	}

	public int getDthotFlag() {
		return dthotFlag;
	}

	public void setDthotFlag(int dthotFlag) {
		this.dthotFlag = dthotFlag;
	}

	public int getHotSeq() {
		return hotSeq;
	}

	public void setHotSeq(int hotSeq) {
		this.hotSeq = hotSeq;
	}

	public int getTravelFlag() {
		return travelFlag;
	}

	public void setTravelFlag(int travelFlag) {
		this.travelFlag = travelFlag;
	}

	public int getTravelSeq() {
		return travelSeq;
	}

	public void setTravelSeq(int travelSeq) {
		this.travelSeq = travelSeq;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getGeolat() {
		return geolat;
	}

	public void setGeolat(double geolat) {
		this.geolat = geolat;
	}

	public double getGeolong() {
		return geolong;
	}

	public void setGeolong(double geolong) {
		this.geolong = geolong;
	}

	public double getCver() {
		return cver;
	}

	public void setCver(double cver) {
		this.cver = cver;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getAliases() {
		return aliases;
	}

	public void setAliases(String aliases) {
		this.aliases = aliases;
	}

	public String getSearchMatch() {
		return searchMatch;
	}

	public void setSearchMatch(String searchMatch) {
		this.searchMatch = searchMatch;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getCityAliases() {
		return cityAliases;
	}

	public void setCityAliases(String cityAliases) {
		this.cityAliases = cityAliases;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public String getCountryThreeWordsCode() {
		return countryThreeWordsCode;
	}

	public void setCountryThreeWordsCode(String countryThreeWordsCode) {
		this.countryThreeWordsCode = countryThreeWordsCode;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}