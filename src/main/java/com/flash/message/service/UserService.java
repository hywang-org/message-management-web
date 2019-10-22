package com.flash.message.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.role.Role;
import com.flash.message.entity.user.Login;
import com.flash.message.entity.user.UserInfo;
import com.flash.message.entity.user.UserRequest;
import com.flash.message.mapper.LoginMapper;
import com.flash.message.mapper.RoleMapper;
import com.flash.message.mapper.UserInfoMapper;
import com.flash.message.utils.MD5Util;
import com.flash.message.utils.PassWordUtil;
import com.flash.message.utils.ResponseJson;
import com.flash.message.utils.StateCode;

/**
 * 
 * @author zzh
 *
 */
@Service
public class UserService {

	private static final Log LOGGER = LogFactory.getLog(UserService.class);

	@Resource
	private UserInfoMapper userMapper;

	@Resource
	private LoginMapper loginMapper;
	
	@Resource
	private RoleMapper roleMapper;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	public JSONObject getAllUser() {
		JSONObject json = ResponseJson.resultForm();
		List<UserInfo> userList = userMapper.selectAll();
		for (UserInfo userInfo : userList) {
			Login login = loginMapper.getLoginByUserId(userInfo.getUserId());
			userInfo.setLoginName(login.getLoginName());
			Role role = roleMapper.selectByPrimaryKey(Long.valueOf(login.getRoleId()+""));
			userInfo.setRoleId(login.getRoleId());
			userInfo.setRoleName(role.getRoleName());
		}
		json.getJSONObject("data").put("users", JSON.toJSON(userList));
		return json;
	}

	/**
	 * 导出方法
	 * 
	 * @return
	 */
	public List<Object[]> getAllUserArr() {
		List<Object[]> result = new ArrayList<Object[]>();
		List<UserInfo> userList = userMapper.selectAll();
		for (UserInfo userInfo : userList) {
			Login login = loginMapper.getLoginByUserId(userInfo.getUserId());
			userInfo.setLoginName(login.getLoginName());
			Object[] obj = new Object[7];
			obj[0] = userInfo.getUserName();
			obj[1] = userInfo.getLoginName();
			obj[2] = userInfo.getUserStatus();
			obj[3] = userInfo.getContacter();
			obj[4] = userInfo.getAddress();
			obj[5] = userInfo.getMobile();
			obj[6] = userInfo.getEmail();
			result.add(obj);
		}
		return result;
	}

	/**
	 * 通过userid获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public JSONObject getUserById(String userId) {
		JSONObject json = ResponseJson.resultForm();
		try {
			UserInfo user = userMapper.getUserById(userId);
			Login login = loginMapper.getLoginByUserId(userId);
			UserRequest urq = new UserRequest();
			urq.setUserId(userId);
			urq.setLoginName(login.getLoginName());
			urq.setUserName(user.getUserName());
			urq.setUserId(userId);
			urq.setAddress(user.getAddress());
			urq.setContacter(user.getContacter());
			urq.setEmail(user.getEmail());
			urq.setMobile(user.getMobile());
			urq.setPayType(user.getPayType());
			urq.setUserStatus(user.getUserStatus());
			urq.setRoleId(login.getRoleId());
			json.getJSONObject("data").put("user", urq);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return json;
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	@Transactional
	public JSONObject addUser(UserRequest user) {
		JSONObject json = ResponseJson.resultForm();
		// 先判断重名问题
		int i = userMapper.getUserByUserName(user.getUserName());
		if (Objects.equals(1, i)) {
			return ResponseJson.formErr2Json(StateCode.USER_NAME_EXIST.getDesc(), StateCode.USER_NAME_EXIST.getCode());
		}
		String password = PassWordUtil.getPassword();
		String userId = UUID.randomUUID().toString();
		Login login = new Login();
		login.setUserId(userId);
		String loginPwd = MD5Util.getMD5(password);
		login.setUserPwd(loginPwd);
		login.setEmail(user.getEmail());
		login.setLoginName(user.getLoginName());
		login.setMobile(user.getMobile());
		login.setUserName(user.getUserName());
		login.setUserStatus(0);
		login.setRoleId(user.getRoleId());
		int lg = loginMapper.insert(login);
		if (1 == lg) {
			// 用户详情表
			UserInfo userInfo = new UserInfo();
			userInfo.setAddress(user.getAddress());
			userInfo.setUserId(userId);
			userInfo.setEmail(user.getEmail());
			// 新增时默认状态为正常
			userInfo.setUserStatus(0);
			userInfo.setPayType(user.getPayType());
			userInfo.setContacter(user.getContacter());
			userInfo.setMobile(user.getMobile());
			userInfo.setUserName(user.getUserName());
			int us = userMapper.addUser(userInfo);
			if (1 != us) {
				return ResponseJson.formErr2Json(StateCode.ADD_USER_FAIL.getDesc(), StateCode.ADD_USER_FAIL.getCode());
			}
			json.getJSONObject("data").put("loginName", user.getLoginName());
			json.getJSONObject("data").put("password", password);
		}
		return json;
	}

	/**
	 * 修改用户信息
	 * 
	 * @return
	 */
	@Transactional
	public JSONObject modifyUser(UserRequest user) {
		JSONObject json = ResponseJson.resultForm();
		Login login = new Login();
		login.setUserId(user.getUserId());
		login.setEmail(user.getEmail());
		login.setLoginName(user.getLoginName());
		login.setMobile(user.getMobile());
		login.setUserName(user.getUserName());
		login.setUserStatus(user.getUserStatus());
		login.setRoleId(user.getRoleId());
		int lg = loginMapper.updateByUserId(login);
		if (1 == lg) {
			// 用户详情表
			UserInfo userInfo = new UserInfo();
			userInfo.setAddress(user.getAddress());
			userInfo.setUserId(user.getUserId());
			userInfo.setEmail(user.getEmail());
			// 新增时默认状态为正常
			userInfo.setUserStatus(user.getUserStatus());
			userInfo.setPayType(user.getPayType());
			userInfo.setContacter(user.getContacter());
			userInfo.setMobile(user.getMobile());
			userInfo.setUserName(user.getUserName());
			int us = userMapper.updateByUserId(userInfo);
			if (1 != us) {
				return ResponseJson.formErr2Json(StateCode.APP_UPDATE_FAIL.getDesc(),
						StateCode.APP_UPDATE_FAIL.getCode());
			}
		}
		return json;
	}

	/**
	 * 用户修改自己的密码
	 * 
	 * @param userId
	 * @param password
	 * @return JSONObject
	 */
	public JSONObject modifyPassword(String userId, String password) {
		JSONObject json = ResponseJson.resultForm();
		try {
			password = MD5Util.getMD5(password);
			loginMapper.resetPassword(userId, password);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return json;
	}
}
