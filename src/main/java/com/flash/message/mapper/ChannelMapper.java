package com.flash.message.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.flash.message.entity.channel.Channel;

@Repository
public interface ChannelMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel queryChannelBySpId(@Param("spId") String spId);
    
    List<Channel> queryChannelBySpType(@Param("spType")String[] spType);

    int updateByPrimaryKeySelective(Channel record);

    int updateBySpId(Channel channel);
    
    List<Channel> getAllChannel();
}