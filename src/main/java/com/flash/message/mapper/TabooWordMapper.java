package com.flash.message.mapper;

import com.flash.message.entity.TabooWord;

public interface TabooWordMapper {
    /**
     *
     * @mbg.generated 2019-10-10
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int insert(TabooWord record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int insertSelective(TabooWord record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    TabooWord selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int updateByPrimaryKeySelective(TabooWord record);

    /**
     *
     * @mbg.generated 2019-10-10
     */
    int updateByPrimaryKey(TabooWord record);
}