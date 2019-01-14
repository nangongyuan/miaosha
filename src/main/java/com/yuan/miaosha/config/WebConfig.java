/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: WebConfig
 * Author:   Administrator
 * Date:     2019/1/14 0014 22:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/14 0014
 * @since 1.0.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	@Autowired
	private UserArgumentResolver userArgumentResolver;

	@Override
	protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(userArgumentResolver);
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/static/");
	}
}