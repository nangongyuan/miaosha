/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RedisService
 * Author:   Administrator
 * Date:     2019/1/13 0013 16:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
@Service
public class RedisService {

	@Autowired
	private JedisPool jedisPool;

	public <T> T get(String keyPrefix, String key, Class<T> clazz){
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			String realKey = keyPrefix + key;
			String str = jedis.get(realKey);
			return stringToBean(str, clazz);
		}finally {
			returnToPool(jedis);
		}
	}

	public <T> T set(String keyPrefix, String key, T value){
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			String str = beanToString(value);
			if (str != null){
				String realKey = keyPrefix + key;
				jedis.set(realKey, str);
			}
			return value;
		}finally {
			returnToPool(jedis);
		}
	}

	public <T> T set(String keyPrefix, String key, T value, Integer expireSeconds){
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			String str = beanToString(value);
			if (str != null){
				String realKey = keyPrefix + key;
				if (expireSeconds<=0){
					jedis.set(realKey, str);
				}else{
					jedis.setex(realKey,expireSeconds,str);
				}
			}
			return value;
		}finally {
			returnToPool(jedis);
		}
	}

	public Long incr(String keyPrefix, String key){
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			String realKey = keyPrefix + key;
			return jedis.incr(realKey);
		}finally {
			returnToPool(jedis);
		}
	}

	public Long decr(String keyPrefix, String key){
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			String realKey = keyPrefix + key;
			return jedis.decr(realKey);
		}finally {
			returnToPool(jedis);
		}
	}

	public Boolean ex(String keyPrefix, String key){
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			String realKey = keyPrefix + key;
			return jedis.exists(realKey);
		}finally {
			returnToPool(jedis);
		}
	}

	private void returnToPool(Jedis jedis){
		if (jedis != null){
			jedis.close();
		}
	}

	private <T> T stringToBean(String str, Class<T> clazz) {
		if (str == null || str.length() <= 0 || clazz == null) {
			return null;
		}
		if (clazz == int.class || clazz == Integer.class) {
			return (T) Integer.valueOf(str);
		}
		if (clazz == long.class || clazz == Long.class) {
			return (T) Long.valueOf(str);
		}
		return JSON.parseObject(str, clazz);
	}

	private <T> String beanToString(T value) {
		if (value == null){
			return null;
		}
		Class<?> clazz = value.getClass();
		if (clazz == int.class || clazz == Integer.class || clazz == long.class || clazz == Long.class){
			return value + "";
		}
		if (clazz == String.class){
			return (String) value;
		}
		return JSON.toJSONString(value);
	}

}