/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GoodsController
 * Author:   Administrator
 * Date:     2019/1/14 0014 21:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.controller;

import com.yuan.miaosha.domain.MiaoshaUser;
import com.yuan.miaosha.service.GoodsService;
import com.yuan.miaosha.service.MiaoshaUserService;
import com.yuan.miaosha.vo.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/14 0014
 * @since 1.0.0
 */
@RequestMapping("/goods")
@Controller
@Slf4j
public class GoodsController {

	@Autowired
	private MiaoshaUserService miaoshaUserService;

	@Autowired
	private GoodsService goodsService;

	/** 
	* @Description: 手机端可能直接通过参数传token，或者直接放到请求头里
	* @Param:  
	* @return:  
	* @Author: yuan
	* @Date: 2019/1/14 0014 
	*/ 
	@RequestMapping("/to_list")
	public String toList(Model model, MiaoshaUser miaoshaUser){
		log.info("goods_list:" + miaoshaUser);
		model.addAttribute("miaoshaUser", miaoshaUser);
		List<GoodsVo> goodsVoList = goodsService.listGoodsVo();
		model.addAttribute("goodsVoList", goodsVoList);
		return "goods_list";
	}


}