/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoginController
 * Author:   Administrator
 * Date:     2019/1/13 0013 20:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.controller;

import com.yuan.miaosha.qo.LoginQo;
import com.yuan.miaosha.result.CodeMsg;
import com.yuan.miaosha.result.Result;
import com.yuan.miaosha.service.MiaoshaUserService;
import com.yuan.miaosha.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
@RequestMapping("/login")
@Controller
@Slf4j
public class LoginController {

	@Autowired
	private MiaoshaUserService miaoshaUserService;

	@RequestMapping("/to_login")
	public String toLogin(){
		return "login";
	}

	@RequestMapping("/do_login")
	@ResponseBody
	public Result doLogin(@Valid LoginQo loginQo){
		log.info("用户登录："+ loginQo);
		miaoshaUserService.login(loginQo);
		return Result.success(CodeMsg.SUCCESS);
	}
}