package com.flash.message.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**
* @author 作者 hywang 619201932@qq.com
*
* @version 创建时间：2019年9月4日 下午4:16:01
*
*/
@Configuration
public class RedisConfig {
	
	@Value("${redis.host}")
	private String hostName;
	
	@Value("${redis.password}")
	private String password;
	
	@Value("${redis.port}")
	private int port;
	
	@Value("${redis-user.database}")
	private int database1;
	
	@Value("${redis-app.database}")
	private int database2;
	
	@Value("${redis.pool.max-active}")
	private int maxActive;
	
	@Value("${redis.pool.max-idle}")
	private int maxIdle;
	
	@Value("${redis.pool.max-wait}")
	private int maxWait;
	
	@Value("${redis.pool.min-idle}")
	private int minIdle;
	
	public RedisConnectionFactory getRedisConnectionFactory(int database) { // 是负责建立Factory的连接工厂类
        JedisConnectionFactory jedisFactory = new JedisConnectionFactory();
        jedisFactory.setHostName(hostName);
        jedisFactory.setPort(port);
        jedisFactory.setPassword(password);
        jedisFactory.setDatabase(database);
        JedisPoolConfig poolConfig = new JedisPoolConfig(); // 进行连接池配置
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(maxWait);
        jedisFactory.setPoolConfig(poolConfig);
        jedisFactory.afterPropertiesSet(); // 初始化连接池配置
        return jedisFactory;
    }
	

    @Bean("redis_user")
    public RedisTemplate<String, Object> getRedisUser() {
        RedisConnectionFactory factory = this.getRedisConnectionFactory(database1); // 建立Redis的连接
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer()); // key的序列化类型
        redisTemplate.setValueSerializer(new StringRedisSerializer()); // value的序列化类型
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
    
    
    @Bean("redis_app")
    public RedisTemplate<String, Object> getRedisApp() {
        RedisConnectionFactory factory = this.getRedisConnectionFactory(database2); // 建立Redis的连接
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer()); // key的序列化类型
        redisTemplate.setValueSerializer(new StringRedisSerializer()); // value的序列化类型
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
