/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BasePrefix
 * Author:   Administrator
 * Date:     2019/1/13 0013 17:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.redis;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
public abstract class BasePrefix implements KeyPrefix{

	private Integer expireSeconds;

	private String prefix;

	public BasePrefix(Integer expireSeconds, String prefix){
		this.expireSeconds = expireSeconds;
		this.prefix = prefix;
	}

	public BasePrefix(String prefix){
		this.expireSeconds = 0;
		this.prefix = prefix;
	}

	/**
	* @Description: 过期时间
	* @Param:
	* @return:  默认0永不过期,
	* @Author: yuan
	* @Date: 2019/1/13 0013
	*/
	@Override
	public Integer getExpireSeconds() {
		return expireSeconds;
	}

	@Override
	public String getPrefix() {
		String className = getClass().getSimpleName();
		return className + ":" + prefix;
	}
}