package com.flash.message.controller.usage;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.flash.message.service.UsageService;

@Controller
@RequestMapping("/usage")
public class UsageController {

	@Resource
	private UsageService usageService;

	@RequestMapping(value = "/queryUsage", method = RequestMethod.POST)
	public JSONObject queryUsage(@RequestParam("beginTime") Date beginTime,@RequestParam("endTime") Date endTime) {
		return usageService.queryUsage(beginTime, endTime);
	}

}
