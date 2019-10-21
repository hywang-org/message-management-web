package com.flash.message.controller.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.auth.LoginAuth;
import com.flash.message.service.LoginService;
import com.flash.message.utils.ResponseJson;
import com.flash.message.utils.StateCode;

@Controller
public class LoginController {

	@Resource
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject login(HttpServletRequest request, @RequestBody LoginAuth lg) {
		JSONObject json = new JSONObject();
		// 字符串全部转为小写
//		lg.setCheckCode(lg.getCheckCode().toLowerCase());
//		String yzm1 = request.getSession().getAttribute("code").toString().toLowerCase();
//		if (lg.getCheckCode().equals(yzm1)) {
			json = loginService.login(lg.getLoginName(), lg.getPassword());
//		} else {
//			json = ResponseJson.formErr2Json(StateCode.IMG_CODE_ERROR.getDesc(), StateCode.IMG_CODE_ERROR.getCode());
//		}
		return json;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject logout(@RequestBody LoginAuth lg) {
		return loginService.logout(lg.getLoginName());
	}
	
	@RequestMapping(value = "/queryState", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject queryState(@RequestBody LoginAuth lg) {
		return loginService.getState(lg.getLoginName());
	}

}
