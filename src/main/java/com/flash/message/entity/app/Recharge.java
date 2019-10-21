package com.flash.message.entity.app;

import java.math.BigDecimal;

public class Recharge {
	/**
	 * app_id
	 */
	private String appId;

	/**
	 * 充值总金额
	 */
	private BigDecimal totalMoney;

	/**
	 * 已用总金额
	 */
	private BigDecimal usedMoney;

	private BigDecimal totalNum;

	private BigDecimal usedNum;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * 充值总金额
	 * 
	 * @return total_money 充值总金额
	 */
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	/**
	 * 充值总金额
	 * 
	 * @param totalMoney
	 *            充值总金额
	 */
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	/**
	 * 已用总金额
	 * 
	 * @return used_money 已用总金额
	 */
	public BigDecimal getUsedMoney() {
		return usedMoney;
	}

	/**
	 * 已用总金额
	 * 
	 * @param usedMoney
	 *            已用总金额
	 */
	public void setUsedMoney(BigDecimal usedMoney) {
		this.usedMoney = usedMoney;
	}

	public BigDecimal getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(BigDecimal totalNum) {
		this.totalNum = totalNum;
	}

	public BigDecimal getUsedNum() {
		return usedNum;
	}

	public void setUsedNum(BigDecimal usedNum) {
		this.usedNum = usedNum;
	}

}