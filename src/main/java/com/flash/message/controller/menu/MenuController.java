package com.flash.message.controller.menu;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.menu.Acl;
import com.flash.message.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Resource
	private MenuService menuService;

	@RequestMapping(value = "/getAllMenu", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryAllMenu() {
		return menuService.queryAllMenu();
	}

	@RequestMapping(value = "/addMenu", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addAcl(@RequestBody Acl acl) {
		JSONObject json = menuService.addAcl(acl);
		return json;
	}

}
