/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MiaoshaUserDao
 * Author:   Administrator
 * Date:     2019/1/13 0013 21:14
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
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
@Data
public class MiaoshaUser {

	private Long id;

	private String nickname;

	private String password;

	private String salt;

	private String head;

	private Date registerDate;

	private Date lastLoginDate;

	private Integer loginCount;

}