package com.flash.message.controller.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.user.UserInfo;
import com.flash.message.entity.user.UserRequest;
import com.flash.message.entity.user.UserStatus;
import com.flash.message.service.LoginService;
import com.flash.message.service.UserService;
import com.flash.message.utils.ExcelUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService user;

	@Resource
	private LoginService login;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	public Object addUser(@RequestBody UserRequest userReq) {
		return user.addUser(userReq);
	}

	@RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
	@ResponseBody
	public Object modifyUser(@RequestBody UserRequest userReq) {
		return user.modifyUser(userReq);
	}

	@RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
	@ResponseBody
	public Object modifyPassword(@RequestBody UserRequest userReq) {
		return user.modifyPassword(userReq.getUserId(), userReq.getPassword());
	}

	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllUser() {
		return user.getAllUser();
	}

	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getUserById(String userId) {
		JSONObject userReq = user.getUserById(userId);
		return userReq;
	}

	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updateStatus(@RequestBody UserStatus user) {
		return login.updateStatus(user.getUserIds(), user.getStatus());
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject resetPassword(String userId) {
		JSONObject json = login.resetPassword(userId);
		return json;
	};

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView exportExcel() throws Exception {
		List<Object[]> allUser = user.getAllUserArr();
		String[] titles = new String[] { "企业名称", "登录名", "用户状态", "对接人", "地址", "手机号", "邮箱" };
		return new ModelAndView(new ExcelUtil("用户信息.xlsx", allUser, titles));
	};
}
