package com.flash.message.entity.order;

import java.util.Date;

/**
 * @author 作者 :hywang
 *
 * @version 创建时间：2019年9月12日 下午4:24:49
 *
 * @version 1.0
 */
public class DelivOrder {

    private String id;

    private String spMsgId;

    private String ownMsgId;

    private String appId;

    private String msgState;
    
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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getSpMsgId() {
        return spMsgId;
    }

    public void setSpMsgId(String spMsgId) {
        this.spMsgId = spMsgId;
    }

    public String getOwnMsgId() {
        return ownMsgId;
    }

    public void setOwnMsgId(String ownMsgId) {
        this.ownMsgId = ownMsgId;
    }

    public String getMsgState() {
        return msgState;
    }

    public void setMsgState(String msgState) {
        this.msgState = msgState;
    }

	public Date getShareDate() {
		return shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}
}
