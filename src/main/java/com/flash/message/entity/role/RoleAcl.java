package com.flash.message.entity.role;

import java.util.Date;

public class RoleAcl {
    /**
     * 主键自增Id
     */
    private Long id;

    /**
     * roleId
     */
    private Long roleId;

    /**
     * aclId
     */
    private Long aclId;

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
     * roleId
     * @return role_id roleId
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * roleId
     * @param roleId roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * aclId
     * @return acl_id aclId
     */
    public Long getAclId() {
        return aclId;
    }

    /**
     * aclId
     * @param aclId aclId
     */
    public void setAclId(Long aclId) {
        this.aclId = aclId;
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