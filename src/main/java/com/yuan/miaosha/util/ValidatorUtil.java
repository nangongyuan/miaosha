/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ValidatorUtil
 * Author:   Administrator
 * Date:     2019/1/13 0013 21:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.util;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
public class ValidatorUtil {

	private static Pattern mobile_pattern = Pattern.compile("1\\d{10}");

	public static boolean isMobile(String mobile){
		if (StringUtils.isEmpty(mobile)){
			return false;
		}
		Matcher matcher = mobile_pattern.matcher(mobile);
		return matcher.matches();
	}


	public static void main(String[] args) {
		System.out.println(isMobile("1888864410"));
	}
}