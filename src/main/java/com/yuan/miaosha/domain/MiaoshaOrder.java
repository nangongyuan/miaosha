/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MiaoshaOrder
 * Author:   Administrator
 * Date:     2019/1/14 0014 23:18
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
public class MiaoshaOrder {

	private Long id;

	private Long userId;

	private Long orderId;

	private Long goodsId;

}