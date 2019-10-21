package com.flash.message.mapper;

import java.util.List;

import com.flash.message.entity.role.Role;

public interface RoleMapper {
    /**
     *
     * @mbg.generated 2019-10-10
     */
    int deleteByPrimaryKey(Long roleId);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int insert(Role record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int insertSelective(Role record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    Role selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int updateByPrimaryKey(Role record);
    
    List<Role> getAllRole();
}