package com.flash.message.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.app.App;
import com.flash.message.entity.app.Recharge;
import com.flash.message.entity.app.ProSecret;
import com.flash.message.entity.user.UserInfo;
import com.flash.message.mapper.AppMapper;
import com.flash.message.mapper.ProSecretMapper;
import com.flash.message.mapper.UserInfoMapper;
import com.flash.message.redis.AppInfoRedis;
import com.flash.message.utils.PassWordUtil;
import com.flash.message.utils.RedisConsts;
import com.flash.message.utils.ResponseJson;
import com.flash.message.utils.StateCode;

@Service
public class AppService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppService.class);

	@Resource
	private AppMapper appMapper;

	@Resource
	private ProSecretMapper secretMapper;

	@Resource
	private AppInfoRedis redis;

	@Resource
	private RechargeService sumptionService;

	@Resource
	private UserInfoMapper userMapper;

	/**
	 * 添加app
	 * 
	 * @param app
	 * @return
	 */
	@Transactional
	public JSONObject addApp(App app) {
		boolean flag = false;
		JSONObject json = ResponseJson.resultForm();
		int i = appMapper.isEx(app.getAppName());
		if (Objects.equals(1, i)) {
			return ResponseJson.formErr2Json(StateCode.APP_NAME_EXIST.getDesc(), StateCode.APP_NAME_EXIST.getCode());
		} else {
			// 生成appId
			String appId = PassWordUtil.getRomdomString(6);
			String appPwd = PassWordUtil.getRomdomString(8);
			json.getJSONObject("data").put("appId", appId);
			json.getJSONObject("data").put("appPwd", appPwd);
			app.setAppId(appId);
			int result = appMapper.insertSelective(app);
			if (Objects.equals(1, result)) {
				ProSecret secret = new ProSecret();
				secret.setAppId(appId);
				secret.setAppSecret(appPwd);
				result = secretMapper.insertSelective(secret);
				Recharge consumption = new Recharge();
				consumption.setAppId(appId);
				consumption.setTotalMoney(app.getTotalMoney());
				consumption.setUsedMoney(new BigDecimal(0));
				consumption.setTotalNum(app.getTotalMoney().divide(app.getPrice(), 0, BigDecimal.ROUND_HALF_UP));
				consumption.setUsedNum(new BigDecimal(0));
				int resultMoney = sumptionService.addConsumption(consumption);
				if (Objects.equals(1, result) && Objects.equals(1, resultMoney)) {
					// 插入hash结构app信息
					save2Redis(app, secret);
					flag = true;
				}
			}
			if (!flag) {
				return ResponseJson.formErr2Json(StateCode.ADD_APP_FAIL.getDesc(), StateCode.ADD_APP_FAIL.getCode());
			}
		}
		return json;
	}

	public JSONObject queryAppById(String appId) {
		JSONObject result = ResponseJson.resultForm();
		App app = appMapper.queryAppByAppId(appId);
		result.getJSONObject("data").put("app", JSON.toJSON(app));
		return result;
	}

	public JSONObject queryAppByChannelId(String channel) {
		JSONObject result = ResponseJson.resultForm();
		List<App> apps = appMapper.queryAppByChannelId(channel);
		if(apps != null && apps.size() > 0) {
			result.getJSONObject("data").put("apps", JSON.toJSON(apps));
		}
		return result;
	}

	/**
	 * 查询所有的app
	 * 
	 * @return
	 */
	public JSONObject queryAllApp() {
		List<App> appList = appMapper.queryApp();
		for (App app : appList) {
			UserInfo user = userMapper.getUserById(app.getUserId());
			app.setUserName(user.getUserName());
		}
		JSONObject result = ResponseJson.resultForm();
		result.getJSONObject("data").put("apps", JSON.toJSON(appList));
		return result;
	}

	// 导出信息
	public List<Object[]> queryAllAppArr() {
		List<App> appList = appMapper.queryApp();
		List<Object[]> result = new ArrayList<Object[]>();
		for (App app : appList) {
			UserInfo user = userMapper.getUserById(app.getUserId());
			app.setUserName(user.getUserName());
			Object[] obj = new Object[8];
			obj[0] = app.getAppName();
			obj[1] = app.getAppId();
			obj[2] = app.getUserName();
			obj[3] = app.getAppStatus();
			obj[4] = app.getSpeedLimit();
			obj[5] = app.getExtendCode();
			obj[6] = app.getPrice();
			obj[7] = app.getPayType();
			result.add(obj);
		}
		return result;
	}

	/**
	 * 根据appid更新app
	 * 
	 * @param app
	 * @return
	 */
	public JSONObject updateApp(App app) {
		JSONObject json = ResponseJson.resultForm();
		int result = appMapper.updateByAppIdSelective(app);
		String appSecret = secretMapper.queryPassword(app.getAppId());
		if (Objects.equals(1, result)) {
			String appId = app.getAppId();
			redis.setHash(appId, RedisConsts.MAX_CONNECTION,
					String.valueOf(app.getMaxConnection()) == null ? "" : String.valueOf(app.getMaxConnection()));
			redis.setHash(appId, RedisConsts.APP_SECRET, appSecret == null ? "" : appSecret);
			redis.setHash(appId, RedisConsts.USER_ID, app.getUserId() == null ? "" : app.getUserId());
			redis.setHash(appId, RedisConsts.PROTOCOL_TYPE,
					String.valueOf(app.getProtocolType()) == null ? "" : String.valueOf(app.getProtocolType()));
			redis.setHash(appId, RedisConsts.CALLBACK_URL, app.getCallbackUrl() == null ? "" : app.getCallbackUrl());
			redis.setHash(appId, RedisConsts.APP_STATUS,
					String.valueOf(app.getAppStatus()) == null ? "" : String.valueOf(app.getAppStatus()));
			redis.setHash(appId, RedisConsts.EXTEND_CODE, app.getExtendCode() == null ? "" : app.getExtendCode());
			redis.setHash(appId, RedisConsts.SPEED_LIMIT,
					String.valueOf(app.getSpeedLimit()) == null ? "" : String.valueOf(app.getSpeedLimit()));
			redis.setHash(appId, RedisConsts.SEND_BEGIN_TIME,
					app.getSendBeginTime() == null ? "" : app.getSendBeginTime());
			redis.setHash(appId, RedisConsts.SEND_END_TIME, app.getSendEndTime() == null ? "" : app.getSendEndTime());
			redis.setHash(appId, RedisConsts.CHANNEL, app.getChannel() == null ? "" : app.getChannel());
		}

		return json;
	}

	/**
	 * 重置app密码
	 * 
	 * @return
	 */
	public JSONObject resetPassword(String appId, String appSecret, int roleId) {
		JSONObject json = ResponseJson.resultForm();
		String appPwd = PassWordUtil.getRomdomString(8);
		json.getJSONObject("data").put("appId", appId);
		json.getJSONObject("data").put("appPwd", appPwd);
		try {
			if (Objects.equals(1, roleId)) {
				// 如果是管理员角色 则可以直接重置
				secretMapper.resetPassword(appPwd, appId);
			} else {
				// 如果为客户自己重置密码。则校验老密码
				String password = secretMapper.queryPassword(appId);
				if (Objects.equals(appSecret, password)) {
					secretMapper.resetPassword(appPwd, appId);
				} else {
					return ResponseJson.formErr2Json(StateCode.PWD_ERROR.getDesc(), StateCode.PWD_ERROR.getCode());
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return json;
	}

	/**
	 * 更新状态/单个/批量
	 * 
	 * @param userIds
	 * @return
	 */
	@Transactional
	public JSONObject updateStatus(String appIds, String status) {
		JSONObject json = ResponseJson.resultForm();
		if (!StringUtils.isEmpty(appIds)) {
			String[] idArr = appIds.split(",");
			for (String appId : idArr) {
				// 增加redis
				redis.setHash(appId, RedisConsts.APP_STATUS, status);
				appMapper.updateStatus(appId, status);
			}
		}
		return json;
	}

	private void save2Redis(App app, ProSecret secret) {
		String appId = app.getAppId();
		BigDecimal totalNum = app.getTotalMoney().divide(app.getPrice(), 0, BigDecimal.ROUND_HALF_UP);
		redis.setHash(appId, RedisConsts.TOTAL_NUM, String.valueOf(totalNum) == null ? "" : String.valueOf(totalNum));
		redis.setHash(appId, RedisConsts.USED_NUM, "0");
		redis.setHash(appId, RedisConsts.MAX_CONNECTION,
				String.valueOf(app.getMaxConnection()) == null ? "" : String.valueOf(app.getMaxConnection()));
		redis.setHash(appId, RedisConsts.APP_SECRET, secret.getAppSecret() == null ? "" : secret.getAppSecret());
		redis.setHash(appId, RedisConsts.USER_ID, app.getUserId() == null ? "" : app.getUserId());
		redis.setHash(appId, RedisConsts.PROTOCOL_TYPE,
				String.valueOf(app.getProtocolType()) == null ? "" : String.valueOf(app.getProtocolType()));
		redis.setHash(appId, RedisConsts.CALLBACK_URL, app.getCallbackUrl() == null ? "" : app.getCallbackUrl());
		redis.setHash(appId, RedisConsts.APP_STATUS,
				String.valueOf(app.getAppStatus()) == null ? "" : String.valueOf(app.getAppStatus()));
		redis.setHash(appId, RedisConsts.EXTEND_CODE, app.getExtendCode() == null ? "" : app.getExtendCode());
		redis.setHash(appId, RedisConsts.SPEED_LIMIT,
				String.valueOf(app.getSpeedLimit()) == null ? "" : String.valueOf(app.getSpeedLimit()));
		redis.setHash(appId, RedisConsts.SEND_BEGIN_TIME, app.getSendBeginTime() == null ? "" : app.getSendBeginTime());
		redis.setHash(appId, RedisConsts.SEND_END_TIME, app.getSendEndTime() == null ? "" : app.getSendEndTime());
		redis.setHash(appId, RedisConsts.CHANNEL, app.getChannel() == null ? "" : app.getChannel());
	}

}
