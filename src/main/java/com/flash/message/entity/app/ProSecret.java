package com.flash.message.entity.app;

public class ProSecret {
	/**
	 * app_id
	 */
	private String appId;

	/**
	 * app_secret
	 */
	private String appSecret;


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

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

}