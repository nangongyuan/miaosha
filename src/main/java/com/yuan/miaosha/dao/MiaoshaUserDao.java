/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MiaoshaUserDao
 * Author:   Administrator
 * Date:     2019/1/13 0013 21:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.miaosha.dao;

import com.yuan.miaosha.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2019/1/13 0013
 * @since 1.0.0
 */
@Mapper
public interface MiaoshaUserDao {

	@Select("select id, nickname, password, salt, head, register_date, last_login_date, login_count from miaosha_user where id=#{id}")
	MiaoshaUser getById(Long id);

}
