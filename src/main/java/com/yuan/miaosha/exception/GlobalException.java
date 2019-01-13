/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GlobalException
 * Author:   Administrator
 * Date:     2019/1/14 0014 0:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.exception;

import com.yuan.miaosha.result.CodeMsg;
import lombok.Getter;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/14 0014
 * @since 1.0.0
 */
@Getter
public class GlobalException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	private CodeMsg codeMsg;

	public GlobalException(CodeMsg codeMsg){
		super(codeMsg.toString());
		this.codeMsg = codeMsg;
	}

}