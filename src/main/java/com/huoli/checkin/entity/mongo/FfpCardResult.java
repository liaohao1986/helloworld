package com.huoli.checkin.entity.mongo;

import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.huoli.checkin.util.MongoConstant;

/**
 * 
 * title: 常客卡数据处理<br>
 * 版权: Copyright (c) 2011-2016<br>
 * 公司: 北京活力天汇<br>
 * 
 * @author:叶胜<br>
 * @date:Jun 28, 2016<br>
 */
@Document(collection = MongoConstant.FFPCARD_RESULT)
public class FfpCardResult {

	/** 航司代码 */
	@Indexed
	private String airlinecode;
	/** 错误消息 */
	private String resultError;
	/** 平台信息 */
	private String p;
	/** 系统时间 */
	@Indexed
	private Date sysDate;
	/** 会话错误信息 */
	private String sessionError;

	/** 里程信息 */
	private Double mileage;

	public FfpCardResult() {
		// TODO Auto-generated constructor stub
	}

	public String getAirlinecode() {
		return airlinecode;
	}

	public void setAirlinecode(String airlinecode) {
		this.airlinecode = airlinecode;
	}

	public String getResultError() {
		return resultError;
	}

	public void setResultError(String resultError) {
		this.resultError = resultError;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

	public String getSessionError() {
		return sessionError;
	}

	public void setSessionError(String sessionError) {
		this.sessionError = sessionError;
	}

	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

}
