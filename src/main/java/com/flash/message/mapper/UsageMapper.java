package com.flash.message.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.flash.message.entity.usage.Usage;

@Repository
public interface UsageMapper {

	/**
	 * 插入每日用量信息
	 */
	int insert(Usage usage);

	List<Usage> queryUsage(@Param(value = "beginDate") Date beginDate, @Param(value = "endDate") Date endDate);

	List<Usage> getHistoryByAppId(@Param("appId") String appId, @Param(value = "beginDate") Date beginDate,
			@Param(value = "endDate") Date endDate);
	
	List<Usage> getHistoryByChannel(@Param("channelId") String channelId, @Param(value = "beginDate") Date beginDate,
			@Param(value = "endDate") Date endDate);
}
