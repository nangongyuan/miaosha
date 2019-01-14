/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MiaoshaUserService
 * Author:   Administrator
 * Date:     2019/1/13 0013 21:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.service;

import com.yuan.miaosha.dao.MiaoshaUserDao;
import com.yuan.miaosha.domain.MiaoshaUser;
import com.yuan.miaosha.exception.GlobalException;
import com.yuan.miaosha.qo.LoginQo;
import com.yuan.miaosha.redis.MiaoshaUserPrefix;
import com.yuan.miaosha.redis.RedisService;
import com.yuan.miaosha.result.CodeMsg;
import com.yuan.miaosha.util.MD5Util;
import com.yuan.miaosha.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
@Service
public class MiaoshaUserService {

	@Autowired
	private MiaoshaUserDao miaoshaUserDao;

	@Autowired
	private RedisService redisService;

	public static final String COOKIE_NAME_TOKEN = "token";


	public MiaoshaUser getById(Long id){
		return miaoshaUserDao.getById(id);
	}

	public Boolean login(HttpServletResponse response, LoginQo loginQo){
		String mobile = loginQo.getMobile();
		String formPass = loginQo.getPassword();

		MiaoshaUser miaoshaUser = getById(Long.valueOf(mobile));
		//判断手机号是否存在
		if (miaoshaUser == null){
			throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
		}

		//验证密码是否正确
		String dbPass = miaoshaUser.getPassword();
		String salt = miaoshaUser.getSalt();
		String calcPass = MD5Util.formPassToDBPass(formPass, salt);
		if (!dbPass.equals(calcPass)){
			throw new GlobalException(CodeMsg.PASSWORD_ERROR);
		}

		addCookie(response, UUIDUtil.uuid(), miaoshaUser);
		return true;
	}

	public MiaoshaUser getByToken(HttpServletResponse response, String token){
		if (StringUtils.isEmpty(token)){
			return null;
		}
		MiaoshaUser miaoshaUser = redisService.get(MiaoshaUserPrefix.token, token, MiaoshaUser.class);
		if (miaoshaUser == null){
			return null;
		}
		addCookie(response, token, miaoshaUser);
		return miaoshaUser;
	}

	private void addCookie(HttpServletResponse response, String token, MiaoshaUser miaoshaUser){
		redisService.set(MiaoshaUserPrefix.token,token,miaoshaUser);
		Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
		cookie.setMaxAge(MiaoshaUserPrefix.token.getExpireSeconds());
		cookie.setPath("/");
		response.addCookie(cookie);
	}

}