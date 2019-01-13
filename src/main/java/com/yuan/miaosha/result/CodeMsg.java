/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CodeMsg
 * Author:   Administrator
 * Date:     2019/1/13 0013 15:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CodeMsg {

	private Integer code;

	private String msg;

	//通用异常

	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
	public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常:%s");

	//登录模块

	public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "session不存在或者已经失效");
	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
	public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "登录手机号码不能为空");
	public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号码格式错误");
	public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号码不存在");
	public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");
	//商品模块

	//订单模块


	public CodeMsg fillArgs(Object... args){
		this.msg = String.format(this.msg, args);
		return this;
	}
}