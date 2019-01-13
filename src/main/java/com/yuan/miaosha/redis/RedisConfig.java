/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RedisConfig
 * Author:   Administrator
 * Date:     2019/1/13 0013 16:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.redis;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfig {

	private String host;

	private Integer port;

	private Integer timeout;

	private String password;

	private Integer poolMaxTotal;

	private Integer poolMaxIdle;

	private Integer poolMaxWait;

	@Bean
	public JedisPool jedisPoolFactory(){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(poolMaxIdle);
		jedisPoolConfig.setMaxTotal(poolMaxTotal);
		jedisPoolConfig.setMaxWaitMillis(poolMaxWait);
		JedisPool jedisPool = new JedisPool(jedisPoolConfig, host);
		return jedisPool;
	}

}