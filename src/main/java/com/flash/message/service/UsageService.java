package com.flash.message.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.usage.Usage;
import com.flash.message.mapper.UsageMapper;
import com.flash.message.utils.ResponseJson;

@Service
public class UsageService {

	@Resource
	private UsageMapper usageMapper;

	public JSONObject queryUsage(Date beginTime, Date endTime) {
		JSONObject result = ResponseJson.resultForm();
		List<Usage> usages = usageMapper.queryUsage(beginTime, endTime);
		result.getJSONObject("data").put("usages", JSON.toJSON(usages));
		return result;
	}

}
