package com.flash.message.entity.user;

public class Login {
    /**
     * 主键自增Id
     */
    private Long id;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码（加密后存储）
     */
    private String userPwd;

    /**
     * 角色id
     */
    private Integer roleId;

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

    /**
     * 登录名
     * @return login_name 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 登录名
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 登录密码（加密后存储）
     * @return user_pwd 登录密码（加密后存储）
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 登录密码（加密后存储）
     * @param userPwd 登录密码（加密后存储）
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * 角色id
     * @return role_id 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

}