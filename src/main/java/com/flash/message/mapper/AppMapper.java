package com.flash.message.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.flash.message.entity.app.App;

@Repository
public interface AppMapper {

	List<App> queryApp();
	
	List<App> queryAppByChannelId(@Param("channel")String channel);

	int insertSelective(App record);
	
	int isEx(String appName);

	App queryAppByAppId(@Param("appId")String appId);

	int updateByPrimaryKeySelective(App record);

	int updateByAppId(App app);
	
	int updateByAppIdSelective(App app);
	
	int updateStatus(String appId,String appStatus);
}