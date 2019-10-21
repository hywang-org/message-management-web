package com.flash.message.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.flash.message.entity.menu.Acl;
import com.flash.message.mapper.AclMapper;
import com.flash.message.utils.ResponseJson;

@Service
public class MenuService {

	private static final Log LOGGER = LogFactory.getLog(MenuService.class);

	@Resource
	private AclMapper aclMapper;

	public JSONObject queryAllMenu() {
		JSONObject json = ResponseJson.resultForm();
		List<Acl> acls = aclMapper.queryAllAcl();
		json.getJSONObject("data").put("acls", JSON.toJSON(acls));
		return json;
	}

	public JSONObject addAcl(Acl acl) {
		JSONObject json = ResponseJson.resultForm();
		try {
			if(acl != null && acl.getAclStatus() == null) {
				acl.setAclStatus(0);
			}
			aclMapper.insertSelective(acl);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
		}
		return json;

	}

}
