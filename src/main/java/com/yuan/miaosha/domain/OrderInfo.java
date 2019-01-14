/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OrderInfo
 * Author:   Administrator
 * Date:     2019/1/14 0014 23:15
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
public class OrderInfo {

	private Long id;

	private Long userId;

	private Long goodsId;

	private Long deliveryAddr;

	private String goodsName;

	private Integer goodsCount;

	private Double goodsPrice;

	private Integer orderChanel;

	private Integer status;

	private Date createDate;

	private Date payDate;

}