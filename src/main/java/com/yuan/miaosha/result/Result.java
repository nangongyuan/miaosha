/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Result
 * Author:   Administrator
 * Date:     2019/1/13 0013 15:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.result;

import lombok.Getter;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
@Getter
public class Result<T> {

	private Integer code;

	private String msg;

	private T data;

	private Result(T data){
		this.code = CodeMsg.SUCCESS.getCode();
		this.msg = CodeMsg.SUCCESS.getMsg();
		this.data = data;
	}

	private Result(CodeMsg codeMsg){
		if (codeMsg == null){
			return;
		}
		this.code = codeMsg.getCode();
		this.msg = codeMsg.getMsg();
	}

	/**
	* @Description: 成功是调用
	* @Param:
	* @return:
	* @Author: yuan
	* @Date: 2019/1/13 0013
	*/
	public static <T> Result<T> success(T data){
		return new Result<T>(data);
	}

	public static <T> Result<T> error(CodeMsg codeMsg){
		return new Result<T>(codeMsg);
	}
}