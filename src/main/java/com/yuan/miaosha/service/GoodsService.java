/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GoodsService
 * Author:   Administrator
 * Date:     2019/1/14 0014 23:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.service;

import com.yuan.miaosha.dao.GoodsDao;
import com.yuan.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/14 0014
 * @since 1.0.0
 */
@Service
public class GoodsService {

	@Autowired
	private GoodsDao goodsDao;

	public List<GoodsVo> listGoodsVo(){
		return goodsDao.listGoodsVo();
	}
}