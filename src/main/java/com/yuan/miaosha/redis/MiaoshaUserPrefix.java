/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MiaoshaUserPrefix
 * Author:   Administrator
 * Date:     2019/1/14 0014 21:12
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
 * @create 2019/1/14 0014
 * @since 1.0.0
 */
public class MiaoshaUserPrefix extends BasePrefix {

	private MiaoshaUserPrefix(String prefix) {
		super(prefix);
	}

	private MiaoshaUserPrefix(Integer expireSeconds, String prefix){
		super(expireSeconds, prefix);
	}

	public static MiaoshaUserPrefix token = new MiaoshaUserPrefix(60*120, "token");

}