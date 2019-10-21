package com.flash.message.entity.usage;

public class Usage {

	private String id;

	private String appId;

	private String appName;

	private String userId;

	private String channel;

	private long submitCount;

	private long onSendCount;

	private long successCount;

	private long failCount;

	private long unknownCount;

	private String dateTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public long getSubmitCount() {
		return submitCount;
	}

	public void setSubmitCount(long submitCount) {
		this.submitCount = submitCount;
	}

	public long getOnSendCount() {
		return onSendCount;
	}

	public void setOnSendCount(long onSendCount) {
		this.onSendCount = onSendCount;
	}

	public long getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(long successCount) {
		this.successCount = successCount;
	}

	public long getFailCount() {
		return failCount;
	}

	public void setFailCount(long failCount) {
		this.failCount = failCount;
	}

	public long getUnknownCount() {
		return unknownCount;
	}

	public void setUnknownCount(long unknownCount) {
		this.unknownCount = unknownCount;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	
}
