/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: KeyPrefix
 * Author:   Administrator
 * Date:     2019/1/13 0013 17:24
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
public interface KeyPrefix {

	Integer getExpireSeconds();

	String getPrefix();

}
