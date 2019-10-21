package com.flash.message.entity.user;

import java.util.Date;

public class UserInfo {
    /**
     * 主键自增Id
     */
    private Long id;

    /**
     * 用户Id
     */
    private String userId;
    
    private String loginName;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 地址
     */
    private String address;

    /**
     * 对接人
     */
    private String contacter;

    /**
     * 付费类型
     */
    private Integer payType;

    /**
     * 账户状态，0：启用 1：禁用
     */
    private Integer userStatus;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 用户邮箱
     */
    private String email;
    
    /**
     * 创建时间
     */
    private Date createdDate;
    
    
    private Integer roleId;
    
    private String roleName;

    /**
     * 主键自增Id
     * @return id 主键自增Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键自增Id
     * @param id 主键自增Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户Id
     * @return user_id 用户Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户Id
     * @param userId 用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 用户名称
     * @return user_name 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名称
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    
    public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
     * 地址
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 对接人
     * @return contacter 对接人
     */
    public String getContacter() {
        return contacter;
    }

    /**
     * 对接人
     * @param contacter 对接人
     */
    public void setContacter(String contacter) {
        this.contacter = contacter == null ? null : contacter.trim();
    }

    public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	/**
     * 账户状态，0：启用 1：禁用
     * @return user_status 账户状态，0：启用 1：禁用
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 账户状态，0：启用 1：禁用
     * @param userStatus 账户状态，0：启用 1：禁用
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 用户手机号
     * @return mobile 用户手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 用户手机号
     * @param mobile 用户手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 用户邮箱
     * @return email 用户邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 用户邮箱
     * @param email 用户邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}