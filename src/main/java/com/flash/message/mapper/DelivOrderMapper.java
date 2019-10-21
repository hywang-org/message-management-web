package com.flash.message.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flash.message.entity.order.DelivOrder;
import com.flash.message.entity.usage.Usage;

public interface DelivOrderMapper {
	/**
	 *
	 * @mbg.generated 2019-10-10
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 *
	 * @mbg.generated 2019-10-10
	 */
	int insert(DelivOrder record);

	/**
	 *
	 * @mbg.generated 2019-10-10
	 */
	int insertSelective(DelivOrder record);

	/**
	 *
	 * @mbg.generated 2019-10-10
	 */
	DelivOrder selectByPrimaryKey(Long id);

	/**
	 *
	 * @mbg.generated 2019-10-10
	 */
	int updateByPrimaryKeySelective(DelivOrder record);

	/**
	 *
	 * @mbg.generated 2019-10-10
	 */
	int updateByPrimaryKey(DelivOrder record);

	/**
	 * 查询发送量 按照appID分组
	 * 
	 * @param shareDate
	 * @return
	 */
	List<Usage> selectAllGBAppId(@Param("shareDate") Date shareDate);

	Usage selectByAppId(@Param("appId") String appId, @Param("shareDate") Date shareDate);
}