package com.flash.message.controller.order;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flash.message.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	private OrderService orderService;

	@RequestMapping(value = "/getOrders", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getOrders() {
		return orderService.getOrders();
	}

	@RequestMapping(value = "/getOrdersByAppId", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getOrdersByAppId(@RequestParam("appId") String appId) {
		return orderService.getOrdersByAppId(appId);
	}

	@RequestMapping(value = "/getHistoryByAppId", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getHistoryByAppId(@RequestParam("appId") String appId, @RequestParam("beginDate") Date beginDate,
			@RequestParam("endDate") Date endDate, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		return orderService.getHistoryByAppId(appId, beginDate, endDate, pageNum, pageSize);
	}

	@RequestMapping(value = "/getHistoryOrders", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getHistoryOrders(@RequestParam("beginDate") Date beginDate, @RequestParam("endDate") Date endDate,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		return orderService.getHistoryOrders(beginDate, endDate, pageNum, pageSize);
	}

	@RequestMapping(value = "/getHistoryByChannel", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getHistoryByChannel(@RequestParam("channelId") String channelId,
			@RequestParam("beginDate") Date beginDate, @RequestParam("endDate") Date endDate,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		return orderService.getHistoryByChannel(channelId, beginDate, endDate, pageNum, pageSize);
	}

}
