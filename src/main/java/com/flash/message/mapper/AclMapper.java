package com.flash.message.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.flash.message.entity.menu.Acl;

@Repository
public interface AclMapper {

	Acl selectAclById(Long aclId);

	List<Acl> queryAllAcl();

	int insertSelective(Acl acl);

}