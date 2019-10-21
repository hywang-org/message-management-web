package com.flash.message.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.app.App;
import com.flash.message.entity.usage.Usage;
import com.flash.message.mapper.AppMapper;
import com.flash.message.mapper.DelivOrderMapper;
import com.flash.message.mapper.ProOrderMapper;
import com.flash.message.mapper.ResOrderMapper;
import com.flash.message.mapper.TabooOrderMapper;
import com.flash.message.mapper.UsageMapper;
import com.flash.message.utils.DateUtil;
import com.flash.message.utils.ResponseJson;
import com.github.pagehelper.PageHelper;

@Service
public class OrderService {

	@Resource
	private ProOrderMapper proOrderMapper;

	@Resource
	private ResOrderMapper resOrderMapper;

	@Resource
	private DelivOrderMapper delivOrderMapper;

	@Resource
	private TabooOrderMapper tabooOrderMapper;

	@Resource
	private AppMapper appMapper;

	@Resource
	private UsageMapper usageMapper;

	/**
	 * 获取当日订单信息
	 * 
	 * @param queryDate
	 * @return
	 */
	public JSONObject getOrders() {
		JSONObject result = ResponseJson.resultForm();
		Date shareDate = DateUtil.LocalDateToUdate();
		// 查询请求订单量
		List<Usage> usageSubmit = proOrderMapper.selectAllGBAppId(shareDate);
		// 查询已发送量
		List<Usage> usageSend = resOrderMapper.selectAllGBAppId(shareDate);
		// 查询发送成功量
		List<Usage> successSend = delivOrderMapper.selectAllGBAppId(shareDate);
		// 查询因为禁忌词发送失败量
		List<Usage> failSend = tabooOrderMapper.selectAllGBAppId(shareDate);

		List<Usage> list = new ArrayList<Usage>();
		if (usageSubmit != null && usageSubmit.size() > 0) {
			for (int i = 0; i < usageSubmit.size(); i++) {
				Usage usage = new Usage();
				String appId = usageSubmit.get(i).getAppId();
				App app = appMapper.queryAppByAppId(appId);
				usage.setAppId(appId);
				usage.setAppName(app.getAppName());
				usage.setChannel(app.getChannel());
				usage.setUserId(app.getUserId());
				usage.setDateTime(shareDate.toString());
				// 已提交量
				usage.setSubmitCount(usageSubmit.get(i).getSubmitCount());
				// 发送成功量
				if (successSend != null && successSend.size() > 0) {
					for (int j = 0; j < successSend.size(); j++) {
						if (usageSubmit.get(i).getAppId().equals(successSend.get(j).getAppId())) {
							usage.setSuccessCount(successSend.get(j).getSuccessCount());
							break;
						} else {
							usage.setSuccessCount(0);
						}
					}
				}
				// 提交成功量
				if (usageSend != null && usageSend.size() > 0) {
					for (int k = 0; k < usageSend.size(); k++) {
						if (usageSubmit.get(i).getAppId().equals(usageSend.get(k).getAppId())) {
							usage.setOnSendCount(usageSend.get(k).getOnSendCount());
							break;
						} else {
							usage.setOnSendCount(0);
						}
					}
				}
				// 发送失败量
				if (failSend != null && failSend.size() > 0) {
					for (int l = 0; l < successSend.size(); l++) {
						if (usageSubmit.get(i).getAppId().equals(successSend.get(l).getAppId())) {
							long fail = usageSubmit.get(i).getSubmitCount() - successSend.get(i).getSuccessCount();
							usage.setOnSendCount(fail + failSend.get(i).getFailCount());
							break;
						} else {
							usage.setSuccessCount(0);
						}
					}
				}
				list.add(usage);
			}
		}
		result.getJSONObject("data").put("records", JSON.toJSON(list));

		return result;
	}

	/**
	 * 根绝appId获取当日订单信息
	 * 
	 * @param appId
	 * @param queryDate
	 * @return
	 */
	public JSONObject getOrdersByAppId(String appId) {
		JSONObject result = ResponseJson.resultForm();
		Date shareDate = DateUtil.LocalDateToUdate();
		// 查询请求订单量
		Usage usageSubmit = proOrderMapper.selectByAppId(appId, shareDate);
		// 查询已发送量
		Usage usageSend = resOrderMapper.selectByAppId(appId, shareDate);
		// 查询发送成功量
		Usage successSend = delivOrderMapper.selectByAppId(appId, shareDate);
		// 查询因为禁忌词发送失败量
		Usage failSend = tabooOrderMapper.selectByAppId(appId, shareDate);
		Usage usage = new Usage();
		App app = appMapper.queryAppByAppId(appId);
		usage.setAppId(appId);
		usage.setAppName(app.getAppName());
		usage.setChannel(app.getChannel());
		usage.setUserId(app.getUserId());
		usage.setDateTime(shareDate.toString());
		usage.setSubmitCount(usageSubmit.getSubmitCount());
		usage.setOnSendCount(usageSend.getOnSendCount());
		usage.setSuccessCount(successSend.getSuccessCount());
		long fail = usageSubmit.getSubmitCount() - successSend.getSuccessCount();
		usage.setOnSendCount(fail + failSend.getFailCount());
		result.getJSONObject("data").put("records", JSON.toJSON(usage));
		return result;
	}

	/**
	 * 根据appId获取历史订单信息
	 * 
	 * @param appId
	 * @param queryDate
	 * @return
	 */
	public JSONObject getHistoryByAppId(String appId, Date beginDate, Date endDate, int pageNum, int pageSize) {
		JSONObject result = ResponseJson.resultForm();
		PageHelper.offsetPage(pageNum, pageSize);
		List<Usage> records = usageMapper.getHistoryByAppId(appId, beginDate, endDate);
		result.getJSONObject("data").put("records", JSON.toJSON(records));
		return result;
	}

	/**
	 * 获取历史订单信息
	 * 
	 * @param queryDate
	 * @return
	 */
	public JSONObject getHistoryOrders(Date beginDate, Date endDate, int pageNum, int pageSize) {
		JSONObject result = ResponseJson.resultForm();
		PageHelper.offsetPage(pageNum, pageSize);
		List<Usage> records = usageMapper.queryUsage(beginDate, endDate);
		result.getJSONObject("data").put("records", JSON.toJSON(records));
		return null;
	}

	/**
	 * 根据channel获取历史订单信息
	 * 
	 * @param channel
	 * @param queryDate
	 * @return
	 */
	public JSONObject getHistoryByChannel(String channelId, Date beginDate, Date endDate, int pageNum, int pageSize) {
		JSONObject result = ResponseJson.resultForm();
		PageHelper.offsetPage(pageNum, pageSize);
		List<Usage> records = usageMapper.getHistoryByChannel(channelId, beginDate, endDate);
		result.getJSONObject("data").put("records", JSON.toJSON(records));
		return result;
	}
}
