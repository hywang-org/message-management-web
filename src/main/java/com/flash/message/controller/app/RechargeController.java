package com.flash.message.controller.app;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.app.DepositMoney;
import com.flash.message.service.RechargeService;

@Controller
@RequestMapping("/app")
public class RechargeController {

	@Resource
	private RechargeService rechargeService;

	@RequestMapping(value = "/recharge", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deposit(@RequestBody DepositMoney depos) {
		return rechargeService.updateConsumption(depos);
	}
	
	@RequestMapping(value = "/getAllRecord")
	@ResponseBody
	public JSONObject queryAll() {
		JSONObject reslut = rechargeService.getAllRecord();
		return reslut;
	}
	
	@RequestMapping(value = "/getRecordByAppId")
	@ResponseBody
	public JSONObject queryRecordByAppId(@RequestParam("appId") String appId) {
		return rechargeService.getRecordByAppId(appId);
	}

}
