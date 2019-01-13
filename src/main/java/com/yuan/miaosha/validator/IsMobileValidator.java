/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IsMobileValidator
 * Author:   Administrator
 * Date:     2019/1/13 0013 21:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.validator;

import com.yuan.miaosha.util.ValidatorUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

	private boolean required =false;

	@Override
	public void initialize(IsMobile constraintAnnotation) {
		required = constraintAnnotation.required();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (required){
			return ValidatorUtil.isMobile(value);
		}else{
			if (StringUtils.isEmpty(value)){
				return true;
			}else{
				return ValidatorUtil.isMobile(value);
			}
		}
	}
}