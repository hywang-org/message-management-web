package com.flash.message.entity.menu;

import java.util.Date;

public class Acl {
    /**
     * 主键自增Id
     */
    private Long id;

    /**
     * 权限名称
     */
    private String aclName;

    /**
     * 菜单链接地址
     */
    private String menuUrl;

    /**
     * 1为顶层菜单 无父级菜单。2为子菜单
     */
    private Integer aclType;

    /**
     * 账户状态，0：启用 1：禁用
     */
    private Integer aclStatus;

    /**
     * 菜单顺序
     */
    private Integer aclSeq;

    /**
     * 父级Id
     */
    private Long parentId;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 更新时间
     */
    private Date updatedDate;

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
     * 权限名称
     * @return acl_name 权限名称
     */
    public String getAclName() {
        return aclName;
    }

    /**
     * 权限名称
     * @param aclName 权限名称
     */
    public void setAclName(String aclName) {
        this.aclName = aclName == null ? null : aclName.trim();
    }

    /**
     * 菜单链接地址
     * @return menu_url 菜单链接地址
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 菜单链接地址
     * @param menuUrl 菜单链接地址
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * 1为顶层菜单 无父级菜单。2为子菜单
     * @return acl_type 1为顶层菜单 无父级菜单。2为子菜单
     */
    public Integer getAclType() {
        return aclType;
    }

    /**
     * 1为顶层菜单 无父级菜单。2为子菜单
     * @param aclType 1为顶层菜单 无父级菜单。2为子菜单
     */
    public void setAclType(Integer aclType) {
        this.aclType = aclType;
    }

    /**
     * 账户状态，0：启用 1：禁用
     * @return acl_status 账户状态，0：启用 1：禁用
     */
    public Integer getAclStatus() {
        return aclStatus;
    }

    /**
     * 账户状态，0：启用 1：禁用
     * @param aclStatus 账户状态，0：启用 1：禁用
     */
    public void setAclStatus(Integer aclStatus) {
        this.aclStatus = aclStatus;
    }

    /**
     * 菜单顺序
     * @return acl_seq 菜单顺序
     */
    public Integer getAclSeq() {
        return aclSeq;
    }

    /**
     * 菜单顺序
     * @param aclSeq 菜单顺序
     */
    public void setAclSeq(Integer aclSeq) {
        this.aclSeq = aclSeq;
    }

    /**
     * 父级Id
     * @return parent_id 父级Id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父级Id
     * @param parentId 父级Id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 创建时间
     * @return created_date 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 创建时间
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 更新时间
     * @return updated_date 更新时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 更新时间
     * @param updatedDate 更新时间
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}