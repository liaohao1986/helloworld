package com.huoli.checkin.entity.mongo;

import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * title:预选座位结果实体类 <br>
 * 版权: Copyright (c) 2011-2016<br>
 * 公司: 北京活力天汇<br>
 * 
 * @author:叶胜<br>
 * @date:Jun 28, 2016<br>
 */
@Document(collection = "reserve_result")
public class ReserveResult {

	/** 航司代码 */
	@Indexed
	private String airlineCode;
	/** 错误消息 */
	private String resultError;
	/** 成功消息 */
	private String successTip;
	/** 平台 */
	private String client;
	/** 系统时间 */
	@Indexed
	private Date createTime;

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getResultError() {
		return resultError;
	}

	public void setResultError(String resultError) {
		this.resultError = resultError;
	}

	public String getSuccessTip() {
		return successTip;
	}

	public void setSuccessTip(String successTip) {
		this.successTip = successTip;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
