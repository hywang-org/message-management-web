package com.flash.message.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.menu.Acl;
import com.flash.message.entity.role.Role;
import com.flash.message.entity.role.RoleAcl;
import com.flash.message.mapper.AclMapper;
import com.flash.message.mapper.RoleAclMapper;
import com.flash.message.mapper.RoleMapper;
import com.flash.message.utils.ResponseJson;

@Service
public class RoleService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(RoleService.class);

	@Resource
	private RoleMapper roleMapper;

	@Resource
	private RoleAclMapper roleAclMapper;

	@Resource
	private AclMapper aclMapper;

	/**
	 * 通过角色ID 获取菜单信息
	 * 
	 * @param roleId
	 * @return 返回菜单信息的list
	 */
	public List<Acl> getRoleAcl(int roleId) {
		List<Acl> aclList = new ArrayList<Acl>();
		// 先通过角色获取菜单id
		List<RoleAcl> list = roleAclMapper.selectByRoleId(roleId);
		for (RoleAcl roleAcl : list) {
			// 循环遍历获取所有的菜单信息
			Acl acl = aclMapper.selectAclById(roleAcl.getAclId());
			aclList.add(acl);
		}
		return aclList;
	};

	/**
	 * 获取所有的角色
	 * 
	 * @return
	 */
	public JSONObject getAllRole() {
		JSONObject result = ResponseJson.resultForm();
		List<Role> roles = roleMapper.getAllRole();
		result.getJSONObject("data").put("roles", JSON.toJSON(roles));
		return result;
	}

	public JSONObject addRole(Role role) {
		JSONObject json = ResponseJson.resultForm();
		try {
			roleMapper.insert(role);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
		}
		return json;
	}

	/**
	 * 角色关联菜单
	 * 
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	@Transactional
	public JSONObject roleLinkMenu(String roleId, String menuIds) {
		JSONObject json =ResponseJson.resultForm();
		if (!Objects.isNull(menuIds)) {
			String[] munuArr = menuIds.split(",");
			for (String menuId : munuArr) {
				RoleAcl ra = new RoleAcl();
				ra.setAclId(Long.parseLong(menuId));
				ra.setRoleId(Long.parseLong(roleId));
				roleAclMapper.insert(ra);
			}
		}
		return json;
	}
}
