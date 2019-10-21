package com.flash.message.entity.order;

import java.util.Date;

/**
 * @author 作者 :hywang
 *
 * @version 创建时间：2019年9月12日 下午4:10:17
 *
 * @version 1.0
 */
public class TabooOrder {

    private String id;

    private String ownMsgId;

    private String clientSeqId;

    private String ownSeqId;

    private String channelId;

    private String serverId;

    private String protocol;

    /**
     * 收信人手机号
     */
    private String desId;

    /**
     * app_id
     */
    private String appId;

    /**
     * link_id
     */
    private String linkId;
    
    private Date shareDate;

    /**
     * order_id
     * 
     * @return id order_id
     */
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

    public String getOwnMsgId() {
        return ownMsgId;
    }

    public void setOwnMsgId(String ownMsgId) {
        this.ownMsgId = ownMsgId;
    }

    public String getClientSeqId() {
        return clientSeqId;
    }

    public void setClientSeqId(String clientSeqId) {
        this.clientSeqId = clientSeqId;
    }

    public String getOwnSeqId() {
        return ownSeqId;
    }

    public void setOwnSeqId(String ownSeqId) {
        this.ownSeqId = ownSeqId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * 收信人手机号
     * 
     * @return des_id 收信人手机号
     */
    public String getDesId() {
        return desId;
    }

    /**
     * 收信人手机号
     * 
     * @param desId
     *            收信人手机号
     */
    public void setDesId(String desId) {
        this.desId = desId == null ? null : desId.trim();
    }

    /**
     * app_id
     * 
     * @return app_id app_id
     */
    public String getAppId() {
        return appId;
    }

    /**
     * app_id
     * 
     * @param appId
     *            app_id
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId == null ? null : linkId.trim();
    }
    
	public Date getShareDate() {
		return shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}
}
