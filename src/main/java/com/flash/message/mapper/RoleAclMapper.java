package com.flash.message.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flash.message.entity.role.RoleAcl;

public interface RoleAclMapper {
    /**
     *
     * @mbg.generated 2019-10-10
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int insert(RoleAcl record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int insertSelective(RoleAcl record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    RoleAcl selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int updateByPrimaryKeySelective(RoleAcl record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int updateByPrimaryKey(RoleAcl record);
    
    List<RoleAcl> selectByRoleId(@Param("roleId") long roleId);
}