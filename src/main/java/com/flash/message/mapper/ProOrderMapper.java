package com.flash.message.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flash.message.entity.order.ProOrder;
import com.flash.message.entity.usage.Usage;

public interface ProOrderMapper {
    /**
     *
     * @mbg.generated 2019-10-10
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int insert(ProOrder record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int insertSelective(ProOrder record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    ProOrder selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int updateByPrimaryKeySelective(ProOrder record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int updateByPrimaryKey(ProOrder record);
    
    
    /**
     * 查询提交量 按照appID分组
     * @param shareDate
     * @return
     */
    List<Usage> selectAllGBAppId(@Param("shareDate") Date shareDate);
    
    
    Usage selectByAppId(@Param("appId") String appId,@Param("shareDate") Date shareDate);
}