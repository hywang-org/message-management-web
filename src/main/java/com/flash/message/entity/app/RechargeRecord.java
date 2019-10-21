package com.flash.message.entity.app;

import java.math.BigDecimal;

public class RechargeRecord {

	private Long id;
	
	private String appId;
	
	private BigDecimal rechargeAmount;
	
	private BigDecimal beforeRecharge;
	
	private BigDecimal afterRecharge;
	
	private String updatedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public BigDecimal getBeforeRecharge() {
		return beforeRecharge;
	}

	public void setBeforeRecharge(BigDecimal beforeRecharge) {
		this.beforeRecharge = beforeRecharge;
	}

	public BigDecimal getAfterRecharge() {
		return afterRecharge;
	}

	public void setAfterRecharge(BigDecimal afterRecharge) {
		this.afterRecharge = afterRecharge;
	}

	public BigDecimal getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(BigDecimal rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
