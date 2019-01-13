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
import com.yuan.miaosha.result.CodeMsg;
import com.yuan.miaosha.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public MiaoshaUser getById(Long id){
		return miaoshaUserDao.getById(id);
	}

	public Boolean login(LoginQo loginQo){
		String mobile = loginQo.getMobile();
		String formPass = loginQo.getPassword();

		MiaoshaUser miaoshaUser = getById(Long.valueOf(mobile));
		if (miaoshaUser == null){
			throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
		}
		String dbPass = miaoshaUser.getPassword();
		String salt = miaoshaUser.getSalt();
		String calcPass = MD5Util.formPassToDBPass(formPass, salt);
		if (!dbPass.equals(calcPass)){
			throw new GlobalException(CodeMsg.PASSWORD_ERROR);
		}
		return true;
	}
}