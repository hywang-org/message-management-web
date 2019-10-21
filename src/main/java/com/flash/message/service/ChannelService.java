package com.flash.message.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.channel.Channel;
import com.flash.message.mapper.ChannelMapper;
import com.flash.message.utils.ResponseJson;

@Service
public class ChannelService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChannelService.class);

	@Resource
	private ChannelMapper channelMapper;

	/**
	 * 
	 * @return
	 */
	public JSONObject queryChannelBySpType(String[] spType) {
		JSONObject result = ResponseJson.resultForm();
		List<Channel> channelList = channelMapper.queryChannelBySpType(spType);
		result.getJSONObject("data").put("channels", JSON.toJSON(channelList));
		return result;
	}

	/**
	 * 获取通道的详情
	 * 
	 * @param channelId
	 * @return
	 */
	public JSONObject queryChannelBySpId(String spId) {
		JSONObject result = ResponseJson.resultForm();
		Channel channel = channelMapper.queryChannelBySpId(spId);
		result.getJSONObject("data").put("channel", JSON.toJSON(channel));
		return result;
	}

	/**
	 * 添加通道
	 * 
	 * @param channel
	 * @return
	 */
	public JSONObject addChannel(Channel channel) {
		JSONObject json = ResponseJson.resultForm();
		try {
			channel.setSpStatus(0);
			channel.setSpConnectStatus(0);
			channelMapper.insert(channel);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return json;
	}

	/**
	 * 更新通道信息
	 * 
	 * @param channel
	 * @return
	 */
	public JSONObject updateChannel(Channel channel) {
		JSONObject json = ResponseJson.resultForm();
		channelMapper.updateBySpId(channel);
		return json;
	}
	
	/**
	 * 获取所有的通道信息
	 * 
	 * @return
	 */
	public JSONObject getAllChannel() {
		JSONObject result = ResponseJson.resultForm();
		List<Channel> channelList = channelMapper.getAllChannel();
		result.getJSONObject("data").put("channels", JSON.toJSON(channelList));
		return result;
	}

}
