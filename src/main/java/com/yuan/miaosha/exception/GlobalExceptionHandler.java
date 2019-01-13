/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GlobleExceptionHandler
 * Author:   Administrator
 * Date:     2019/1/13 0013 22:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.exception;

import com.yuan.miaosha.result.CodeMsg;
import com.yuan.miaosha.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
		if (e instanceof GlobalException){
			GlobalException globalException = (GlobalException) e;
			CodeMsg codeMsg = globalException.getCodeMsg();
			return Result.error(codeMsg);
		}else if (e instanceof BindException){
			BindException bindException = (BindException) e;
			List<ObjectError> errorList = bindException.getAllErrors();
			ObjectError error = errorList.get(0);
			String msg = error.getDefaultMessage();
			return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
		}else{
			return Result.error(CodeMsg.SERVER_ERROR);
		}
	}
}