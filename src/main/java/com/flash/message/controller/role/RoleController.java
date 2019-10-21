package com.flash.message.controller.role;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.role.Role;
import com.flash.message.entity.role.RoleLinkParam;
import com.flash.message.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Resource
	private RoleService roleService;

	@RequestMapping(value = "/getAllRole", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllRole() {
		return roleService.getAllRole();
	}

	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addRole(@RequestBody Role role) {
		JSONObject json = roleService.addRole(role);
		return json;
	}

	@RequestMapping(value = "/roleLinkMenu", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject roleLinkMenu(@RequestBody RoleLinkParam params) {
		JSONObject json = roleService.roleLinkMenu(params.getRoleId(), params.getAclIds());
		return json;
	}

}
