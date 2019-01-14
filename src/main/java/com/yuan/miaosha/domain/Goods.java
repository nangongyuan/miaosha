/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Goods
 * Author:   Administrator
 * Date:     2019/1/14 0014 23:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.domain;

import lombok.Data;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/14 0014
 * @since 1.0.0
 */
@Data
public class Goods {

	private Long id;

	private String goodsName;

	private String goodsTitle;

	private String goodsImg;

	private String goodsDetail;

	private double goodsPrice;

	private Integer goodsStock;

}