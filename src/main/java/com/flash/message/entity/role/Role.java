package com.flash.message.entity.role;

import java.util.Date;

public class Role {
	/**
	 * roleId
	 */
	private Long id;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 角色描述
	 */
	private String roleDesc;

	/**
	 * 角色类型 1 为管理员 2 为普通用户
	 */
	private Integer type;

	/**
	 * 创建时间
	 */
	private Date createdDate;

	/**
	 * 更新时间
	 */
	private Date updatedDate;

	/**
	 * roleId
	 * 
	 * @return role_id roleId
	 */
	public Long getId() {
		return id;
	}

	/**
	 * roleId
	 * 
	 * @param roleId roleId
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 角色名称
	 * 
	 * @return role_name 角色名称
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 角色名称
	 * 
	 * @param roleName 角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	/**
	 * 角色描述
	 * 
	 * @return role_desc 角色描述
	 */
	public String getRoleDesc() {
		return roleDesc;
	}

	/**
	 * 角色描述
	 * 
	 * @param roleDesc 角色描述
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc == null ? null : roleDesc.trim();
	}

	/**
	 * 角色类型 1 为管理员 2 为普通用户
	 * 
	 * @return type 角色类型 1 为管理员 2 为普通用户
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 角色类型 1 为管理员 2 为普通用户
	 * 
	 * @param type 角色类型 1 为管理员 2 为普通用户
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}