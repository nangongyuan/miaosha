/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MD5Util
 * Author:   Administrator
 * Date:     2019/1/13 0013 20:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.util;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
public class MD5Util {

	public static String md5(String src){
		return DigestUtils.md5Hex(src);
	}


	private static final String salt = "q[akfapla-0f2jf";

	public static String inputPassFormPass(String inputPass){
		String str = " " + salt.charAt(0) + salt.charAt(2) + inputPass + salt;
		return md5(str);
	}

	public static String formPassToDBPass(String formPass, String salt){
		return md5(salt + formPass);
	}

	public static String inputPassToDBPass(String input, String saltDB){
		String str = inputPassFormPass(input);
		return formPassToDBPass(str, saltDB);
	}

	public static void main(String[] args) {
		System.out.println(inputPassToDBPass("12345678", ".lakf["));
	}
}