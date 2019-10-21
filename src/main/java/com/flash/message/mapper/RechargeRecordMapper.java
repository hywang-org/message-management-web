package com.flash.message.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flash.message.entity.app.RechargeRecord;

public interface RechargeRecordMapper {
    /**
     *
     * @mbg.generated 2019-10-10
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int insert(RechargeRecord record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int insertSelective(RechargeRecord record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    RechargeRecord selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int updateByPrimaryKeySelective(RechargeRecord record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int updateByPrimaryKey(RechargeRecord record);
    
    List<RechargeRecord> queryAllRecord();

	List<RechargeRecord> queryRecordByAppId(@Param("appId")String appId);
}