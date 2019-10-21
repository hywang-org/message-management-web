package com.flash.message.controller.channel;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.channel.Channel;
import com.flash.message.service.ChannelService;

@Controller
@RequestMapping("/channel")
public class ChannelConntroller {

	@Resource
	private ChannelService channelService;

	@RequestMapping(value = "/queryChannelBySpType", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryChannelBySpType(@RequestParam("spType") String spType) {
		return channelService.queryChannelBySpType(spType.split(","));
	}

	@RequestMapping(value = "/queryChannelBySpId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryChannelById(@RequestParam("spId") String spId) {
		return channelService.queryChannelBySpId(spId);
	}

	@RequestMapping(value = "/addChannel", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addChannel(@RequestBody Channel channel) {
		JSONObject json = channelService.addChannel(channel);
		return json;
	}

	@RequestMapping(value = "/updateChannel", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updateChannel(@RequestBody Channel channel) {
		JSONObject json = channelService.updateChannel(channel);
		return json;
	}
	
	@RequestMapping(value = "/getAllChannel", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllChannel() {
		return channelService.getAllChannel();
	}
}
