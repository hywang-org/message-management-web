package com.flash.message.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.flash.message.entity.user.Login;

@Repository
public interface LoginMapper {

	/**
	 * 判断用户名是否存在
	 * 
	 * @param username
	 * @return
	 */
	int isExist(@Param("loginName")String loginName);

	/**
	 * 重置客户密码
	 * 
	 * @param UserId
	 *            用户id
	 * @return 返回是否执行
	 */
	void resetPassword(@Param("userId")String userId, @Param("password")String password);

	/**
	 * 获取用户登录信息
	 * @param userId 用户id
	 * @return 返回密码信息
	 */
	Login getLogin(@Param("loginName")String loginName);

	int insert(Login login);

	Login getLoginByUserId(String userId);

	Login selectByPrimaryKey(Long id);

	void updateStatus(@Param("status")Integer status,@Param("userId")String userId);

	/**
	 * 更新登录表内容
	 * @param login
	 * @return
	 */
	int updateByUserId(Login login);
}