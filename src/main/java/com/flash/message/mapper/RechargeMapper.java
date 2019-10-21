package com.flash.message.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.flash.message.entity.app.Recharge;

@Repository
public interface RechargeMapper {

	int insertSelective(Recharge consumption);

	void update(String appId, BigDecimal totalMoney, BigDecimal totalNum);

	Recharge queryById(String appId);

}