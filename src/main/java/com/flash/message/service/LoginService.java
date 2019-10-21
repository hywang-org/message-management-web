package com.flash.message.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.menu.Acl;
import com.flash.message.entity.role.Role;
import com.flash.message.entity.user.Login;
import com.flash.message.mapper.AclMapper;
import com.flash.message.mapper.LoginMapper;
import com.flash.message.mapper.RoleMapper;
import com.flash.message.redis.UserRedis;
import com.flash.message.utils.MD5Util;
import com.flash.message.utils.ResponseJson;
import com.flash.message.utils.StateCode;

/**
 * 
 * @author zzh
 *
 */
@Service
public class LoginService {

	@Resource
	private LoginMapper loginMapper;
	
	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private AclMapper aclMapper;

	@Value("${user.password}")
	private String resetPassword;

	@Value("${token.time.out}")
	private long tokenTimeout;

	@Resource
	private RoleService roleService;

	@Resource
	private UserRedis userRedis;
	
	/**
	 * 判断用户名是否存在
	 * 
	 * @param username 用户名
	 * @return 返回判断结果
	 */
	public int isExist(String loginName) {
		return loginMapper.isExist(loginName);
	}

	/**
	 * 登录信息的验证以及后续的菜单权限返回
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 */
	public JSONObject login(String loginName, String password) {
		JSONObject json = new JSONObject();
		// 判断用户是否存在
		int hasUser = this.isExist(loginName);
		// 用户不存在
		if (!Objects.equals(1, hasUser)) {
			json = ResponseJson.formErr2Json(StateCode.USER_NOT_EXIST.getDesc(), StateCode.USER_NOT_EXIST.getCode());
			return json;
		}
		password = MD5Util.getMD5(password);
		Login login = this.getLogin(loginName);
		// 验证密码
		if (!Objects.equals(password, login.getUserPwd())) {
			json = ResponseJson.formErr2Json(StateCode.PWD_ERROR.getDesc(), StateCode.PWD_ERROR.getCode());
			return json;
		}
		Role role = roleMapper.selectByPrimaryKey(login.getRoleId().longValue());
		// 验证通过后将权限信息发送给前端
		List<Acl> list = new ArrayList<Acl>();
		if(role.getType() != 1) {
			list = roleService.getRoleAcl(login.getRoleId());
		}else {
			list = aclMapper.queryAllAcl();
		}
		json = ResponseJson.resultForm();
		json.getJSONObject("data").put("tree", list);
		login.setUserPwd("");
		json.getJSONObject("data").put("user", login);

		String token = UUID.randomUUID().toString();

		json.getJSONObject("data").put("token", token);
		userRedis.set(login.getUserId(), token, tokenTimeout);

		return json;
	}

	public JSONObject logout(String loginName) {
		Login login = this.getLogin(loginName);
		if (login != null) {
			if (userRedis.hasKey(login.getUserId())) {
				userRedis.deleteKey(login.getUserId());
			}
		} else {
			return ResponseJson.formErr2Json(StateCode.USER_NOT_EXIST.getDesc(), StateCode.USER_NOT_EXIST.getCode());
		}
		return ResponseJson.resultForm();
	}

	public JSONObject getState(String userName) {
		Login login = this.getLogin(userName);
		JSONObject json = ResponseJson.resultForm();
		if (login != null) {
			if (userRedis.hasKey(login.getUserId())) {
				json.getJSONObject("data").put("state", true);
			} else {
				json.getJSONObject("data").put("state", false);
			}
		}
		return json;
	}

	/**
	 * 获取登录的信息
	 * 
	 * @param loginName
	 * @return
	 */
	public Login getLogin(String loginName) {
		return loginMapper.getLogin(loginName);
	}

	public JSONObject resetPassword(String userId) {
		JSONObject json = new JSONObject();
		resetPassword = MD5Util.getMD5(resetPassword);
		loginMapper.resetPassword(userId, resetPassword);
		return json;
	}

	/**
	 * 更新状态/单个/批量
	 * 
	 * @param userIds
	 * @return
	 */
	@Transactional
	public JSONObject updateStatus(String userIds, String status) {
		JSONObject json = ResponseJson.resultForm();
		if (!StringUtils.isEmpty(userIds)) {
			String[] idArr = userIds.split(",");
			for (String userId : idArr) {
				loginMapper.updateStatus(Integer.parseInt(status), userId);
			}
		}
		return json ;
	}
}
