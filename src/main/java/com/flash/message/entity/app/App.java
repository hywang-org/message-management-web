package com.flash.message.entity.app;

import java.math.BigDecimal;
import java.util.Date;

public class App {
	/**
	 * 主键自增Id
	 */
	private Long id;

	/**
	 * 接入号
	 */
	private String appId;

	/**
	 * 产品名称
	 */
	private String appName;

	/**
	 * 用户Id
	 */
	private String userId;

	private String userName;

	/**
	 * 所属领域
	 */
	private String field;

	/**
	 * 协议类型
	 */
	private int protocolType;

	/**
	 * 回调地址
	 */
	private String callbackUrl;

	/**
	 * 状态，0：启用 1：禁用
	 */
	private Integer appStatus;

	/**
	 * 扩展码
	 */
	private String extendCode;

	/**
	 * 流速
	 */
	private Integer speedLimit;

	/**
	 * 开始发送时间
	 */
	private String sendBeginTime;

	/**
	 * 结束发送时间
	 */
	private String sendEndTime;

	/**
	 * 单条短信价格
	 */
	private BigDecimal price;

	// 可用金额
	private BigDecimal totalMoney;

	/**
	 * 支付类型 0 为预付款 1为后付款
	 */
	private Integer payType;

	/**
	 * 通道
	 */
	private String channel;

	private Integer MaxConnection;
	
	/**
	 * 创建时间
	 */
	private Date createdDate;

	/**
	 * 更新时间
	 */
	private Date updatedDate;

	/**
	 * 主键自增Id
	 * 
	 * @return id 主键自增Id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 主键自增Id
	 * 
	 * @param id
	 *            主键自增Id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 接入号
	 * 
	 * @return app_id 接入号
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * 接入号
	 * 
	 * @param appId
	 *            接入号
	 */
	public void setAppId(String appId) {
		this.appId = appId == null ? null : appId.trim();
	}

	/**
	 * 产品名称
	 * 
	 * @return app_name 产品名称
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * 产品名称
	 * 
	 * @param appName
	 *            产品名称
	 */
	public void setAppName(String appName) {
		this.appName = appName == null ? null : appName.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 用户Id
	 * 
	 * @return user_id 用户Id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 用户Id
	 * 
	 * @param userId
	 *            用户Id
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	/**
	 * 所属领域
	 * 
	 * @return field 所属领域
	 */
	public String getField() {
		return field;
	}

	/**
	 * 所属领域
	 * 
	 * @param field
	 *            所属领域
	 */
	public void setField(String field) {
		this.field = field == null ? null : field.trim();
	}

	public int getProtocolType() {
		return protocolType;
	}

	public void setProtocolType(int protocolType) {
		this.protocolType = protocolType;
	}

	/**
	 * 回调地址
	 * 
	 * @return callback_url 回调地址
	 */
	public String getCallbackUrl() {
		return callbackUrl;
	}

	/**
	 * 回调地址
	 * 
	 * @param callbackUrl
	 *            回调地址
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl == null ? null : callbackUrl.trim();
	}

	public String getExtendCode() {
		return extendCode;
	}

	public void setExtendCode(String extendCode) {
		this.extendCode = extendCode;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	/**
	 * 状态，0：启用 1：禁用
	 * 
	 * @return app_status 状态，0：启用 1：禁用
	 */
	public Integer getAppStatus() {
		return appStatus;
	}

	/**
	 * 状态，0：启用 1：禁用
	 * 
	 * @param appStatus
	 *            状态，0：启用 1：禁用
	 */
	public void setAppStatus(Integer appStatus) {
		this.appStatus = appStatus;
	}

	/**
	 * 流速
	 * 
	 * @return speed_limit 流速
	 */
	public Integer getSpeedLimit() {
		return speedLimit;
	}

	/**
	 * 流速
	 * 
	 * @param speedLimit
	 *            流速
	 */
	public void setSpeedLimit(Integer speedLimit) {
		this.speedLimit = speedLimit;
	}

	public String getSendBeginTime() {
		return sendBeginTime;
	}

	public void setSendBeginTime(String sendBeginTime) {
		this.sendBeginTime = sendBeginTime;
	}

	public String getSendEndTime() {
		return sendEndTime;
	}

	public void setSendEndTime(String sendEndTime) {
		this.sendEndTime = sendEndTime;
	}

	/**
	 * 单条短信价格
	 * 
	 * @return price 单条短信价格
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 单条短信价格
	 * 
	 * @param price
	 *            单条短信价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 支付类型 0 为预付款 1为后付款
	 * 
	 * @return pay_type 支付类型 0 为预付款 1为后付款
	 */
	public Integer getPayType() {
		return payType;
	}

	/**
	 * 支付类型 0 为预付款 1为后付款
	 * 
	 * @param payType
	 *            支付类型 0 为预付款 1为后付款
	 */
	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	/**
	 * 通道
	 * 
	 * @return channel 通道
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * 通道
	 * 
	 * @param channel
	 *            通道
	 */
	public void setChannel(String channel) {
		this.channel = channel == null ? null : channel.trim();
	}

	public Integer getMaxConnection() {
		return MaxConnection;
	}

	public void setMaxConnection(Integer MaxConnection) {
		this.MaxConnection = MaxConnection;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}