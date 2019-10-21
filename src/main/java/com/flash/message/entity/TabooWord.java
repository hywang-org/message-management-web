package com.flash.message.entity;

import java.util.Date;

public class TabooWord {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String tabooWord;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 更新时间
     */
    private Date updatedDate;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return taboo_word 
     */
    public String getTabooWord() {
        return tabooWord;
    }

    /**
     * 
     * @param tabooWord 
     */
    public void setTabooWord(String tabooWord) {
        this.tabooWord = tabooWord == null ? null : tabooWord.trim();
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