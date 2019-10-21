package com.flash.message.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.flash.message.entity.user.UserInfo;

@Repository
public interface UserInfoMapper {

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return 返回整数
	 */
	int addUser(UserInfo user);

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	int updateByUserId(UserInfo user);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	List<UserInfo> selectAll();

	UserInfo getUserById(@Param("userId") String userId);

	int resetPassword(String UserId);

	int modifyPassword(String UserId);

	int getUserByUserName(String userName);

}
