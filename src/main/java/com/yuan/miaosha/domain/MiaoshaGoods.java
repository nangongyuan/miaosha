/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MiaoshaGoods
 * Author:   Administrator
 * Date:     2019/1/14 0014 23:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.domain;

import lombok.Data;

import java.util.Date;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/14 0014
 * @since 1.0.0
 */
@Data
public class MiaoshaGoods {

	private Long id;

	private Long goodsId;

	private Double miaoshaPrice;

	private Integer stockCount;

	private Date startDate;

	private Date endDate;

}