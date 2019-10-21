package com.flash.message.entity.app;

import java.math.BigDecimal;

public class DepositMoney {

	private String appId;

	private BigDecimal depositMoney;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public BigDecimal getDepositMoney() {
		return depositMoney;
	}

	public void setDepositMoney(BigDecimal depositMoney) {
		this.depositMoney = depositMoney;
	}

}
