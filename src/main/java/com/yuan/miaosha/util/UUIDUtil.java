/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UUIDUtil
 * Author:   Administrator
 * Date:     2019/1/14 0014 21:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.util;

import java.util.UUID;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/14 0014
 * @since 1.0.0
 */
public class UUIDUtil {

	public static String uuid(){
		return UUID.randomUUID().toString().replace("-", "");
	}


	public static void main(String[] args) {
		System.out.println(uuid());
		System.out.println(UUIDUtil.class.getSimpleName());
	}
}