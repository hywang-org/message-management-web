package com.flash.message.redis;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.flash.message.redis.RedisOperationSets;

@Repository
public class AppInfoRedis extends RedisOperationSets {
	@Resource(name = "redis_app")
	private RedisTemplate<String, Object> redisTemplate;

	@PostConstruct
	public void Redis1() {
		super.setRedisTemplate(redisTemplate);
	}
}
