package com.huoli.checkin.design.api;

import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AirLine implements RowMapper<AirLine> {
	/** 序号，排序时使用 */
	private int serialNumber;

	/** 航空公司代码 主键 必须唯一 */
	private String code;

	/** 航空公司三字码 */
	private String threeCode;

	/** 航空公司客服电话 */
	private String carePhone;

	/** 航空公司定票电话 */
	private String reservePhone;

	/** 航空公司介绍 */
	private String introduce;

	/** 航空公司全称 */
	private String fullName;

	/** 航空公司简称 */
	private String shortName;

	/** 航空公司四字简称 */
	private String fourName;

	/** 航空公司英文名称 */
	private String enName;

	/** 是否国内航司 0|1 否|是 */
	private int flag;

	/** 航空公司网站 */
	private String website;

	/** 图片版本，用于更新图片功能 */
	private String imgcver;

	@Override
	public AirLine mapRow(ResultSet rs, int rowNum) throws SQLException {
		this.serialNumber = rs.getInt("serial_number");
		this.code = rs.getString("code");
		this.threeCode = rs.getString("three_words_code");
		this.carePhone = rs.getString("care_phone");
		this.reservePhone = rs.getString("reserve_phone");

		Clob c = rs.getClob("introduce");
		if (c != null) {
			this.introduce = c.getSubString(1, (int) c.length());
		}

		this.fullName = rs.getString("full_name");
		this.shortName = rs.getString("short_name");
		this.fourName = rs.getString("four_name");
		this.enName = rs.getString("en_name");

		this.flag = rs.getInt("internal_flag");
		this.website = rs.getString("website");
		this.imgcver = rs.getString("IMGCVER");
		return this;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getThreeCode() {
		return threeCode;
	}

	public void setThreeCode(String threeCode) {
		this.threeCode = threeCode;
	}

	public String getCarePhone() {
		return carePhone;
	}

	public void setCarePhone(String carePhone) {
		this.carePhone = carePhone;
	}

	public String getReservePhone() {
		return reservePhone;
	}

	public void setReservePhone(String reservePhone) {
		this.reservePhone = reservePhone;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFourName() {
		return fourName;
	}

	public void setFourName(String fourName) {
		this.fourName = fourName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getImgcver() {
		return imgcver;
	}

	public void setImgcver(String imgcver) {
		this.imgcver = imgcver;
	}
}
