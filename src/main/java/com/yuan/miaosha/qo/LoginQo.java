/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoginQo
 * Author:   Administrator
 * Date:     2019/1/13 0013 20:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.qo;

import com.yuan.miaosha.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
@Data
public class LoginQo {

	@NotNull
	@IsMobile
	private String mobile;

	@NotNull
	@Length(min = 32)
	private String password;

}