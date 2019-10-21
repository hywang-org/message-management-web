package com.flash.message.controller.app;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.app.App;
import com.flash.message.entity.app.AppStatus;
import com.flash.message.service.AppService;
import com.flash.message.utils.ExcelUtil;

@Controller
@RequestMapping("/app")
public class AppController {

	@Resource
	private AppService appService;
	
	@RequestMapping(value = "/addApp", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addApp(@RequestBody App app) {
		JSONObject json = appService.addApp(app);
		return json;
	}

	@RequestMapping(value = "/queryAppById", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryApp(@RequestParam("appId") String appId) {
		return appService.queryAppById(appId);
	}

	@RequestMapping(value = "/queryAppByChannelId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryAppByChannelId(String channel) {
		return appService.queryAppByChannelId(channel);
	}

	@RequestMapping(value = "/queryAllApp", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryApp() {
		return appService.queryAllApp();
	}

	@RequestMapping(value = "/updateApp", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updateApp(@RequestBody App app) {
		JSONObject json = appService.updateApp(app);
		return json;
	}

	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updateStatus(@RequestBody AppStatus app) {
		return appService.updateStatus(app.getAppIds(), app.getStatus());
	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView exportExcel() throws Exception {
		List<Object[]> allUser = appService.queryAllAppArr();
		String[] titles = new String[] { "产品名称", "产品ID", "所属用户", "产品状态", "流速", "扩展码", "单价", "付费方式" };
		return new ModelAndView(new ExcelUtil("产品信息.xlsx", allUser, titles));
	};
}
