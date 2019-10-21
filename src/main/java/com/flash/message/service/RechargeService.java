package com.flash.message.service;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.app.App;
import com.flash.message.entity.app.Recharge;
import com.flash.message.entity.app.DepositMoney;
import com.flash.message.entity.app.RechargeRecord;
import com.flash.message.mapper.AppMapper;
import com.flash.message.mapper.RechargeMapper;
import com.flash.message.mapper.RechargeRecordMapper;
import com.flash.message.redis.AppInfoRedis;
import com.flash.message.utils.RedisConsts;
import com.flash.message.utils.ResponseJson;

@Service
public class RechargeService {

	@Resource
	private RechargeMapper rechargeMapper;

	@Resource
	private AppInfoRedis redis;

	@Resource
	private AppMapper appMapper;
	
	@Resource
	private RechargeRecordMapper rechargeRecord;

	/**
	 * 插入用量信息
	 * 
	 * @param consumption
	 * @return
	 */
	public int addConsumption(Recharge consumption) {
		return rechargeMapper.insertSelective(consumption);
	}

	@Transactional
	public JSONObject updateConsumption(DepositMoney depos) {
		JSONObject json = ResponseJson.resultForm();
		Recharge con = queryConsumption(depos.getAppId());
		App app = appMapper.queryAppByAppId(depos.getAppId());

		BigDecimal totalMoney = depos.getDepositMoney().add(con.getTotalMoney());
		BigDecimal totalNum = totalMoney.divide(app.getPrice(), 0, BigDecimal.ROUND_HALF_UP);
		rechargeMapper.update(depos.getAppId(), totalMoney, totalNum);
		redis.setHash(depos.getAppId(), RedisConsts.TOTAL_MONEY, String.valueOf(totalMoney));
		redis.setHash(depos.getAppId(), RedisConsts.TOTAL_NUM, String.valueOf(totalNum));
		// 插入充值记录表
		RechargeRecord record = new RechargeRecord();
		record.setRechargeAmount(depos.getDepositMoney());
		record.setAppId(depos.getAppId());
		record.setBeforeRecharge(con.getTotalMoney());
		record.setAfterRecharge(totalMoney);
		record.setUpdatedBy("admin");
		rechargeRecord.insert(record);
		return json;
	}

	/**
	 * 查询消费情况
	 * 
	 * @param appId
	 * @return Consumption
	 */
	public Recharge queryConsumption(String appId) {
		return rechargeMapper.queryById(appId);
	}

	/**
	 * 获取全部充值记录
	 * 
	 * @return
	 */
	public JSONObject getAllRecord() {
		JSONObject json = ResponseJson.resultForm();
		List<RechargeRecord> records = rechargeRecord.queryAllRecord();
		json.getJSONObject("data").put("records", JSON.toJSON(records));
		return json;
	}

	public JSONObject getRecordByAppId(String appId) {
		JSONObject json = ResponseJson.resultForm();
		List<RechargeRecord> records = rechargeRecord.queryRecordByAppId(appId);
		json.getJSONObject("data").put("records", JSON.toJSON(records));
		return json;
	}
}
