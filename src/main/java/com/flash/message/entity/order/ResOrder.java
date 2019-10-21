package com.flash.message.entity.order;

import java.util.Date;

/**
 * @author 作者 :hywang
 *
 * @version 创建时间：2019年9月12日 下午4:21:42
 *
 * @version 1.0
 */
public class ResOrder {

    private String id;

    private String mySeqId;
    
    private String appId;

    private String spMsgId;
    
    private Date shareDate;

    public String getId() {
        return id;
    }

    /**
     * order_id
     * 
     * @param id
     *            order_id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMySeqId() {
        return mySeqId;
    }

    public void setMySeqId(String mySeqId) {
        this.mySeqId = mySeqId;
    }

    public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSpMsgId() {
        return spMsgId;
    }

    public void setSpMsgId(String spMsgId) {
        this.spMsgId = spMsgId;
    }
    
	public Date getShareDate() {
		return shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}
}
