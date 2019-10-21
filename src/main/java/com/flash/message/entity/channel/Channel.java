package com.flash.message.entity.channel;


public class Channel {
	/**
	 * 主键自增Id
	 */
	private Long id;

	/**
	 * 接入号
	 */
	private String spId;

	/**
	 * 通道名称
	 */
	private String spName;

	/**
	 * 通道类型
	 */
	private Integer spType;

	/**
	 * 状态，0:可用 1:不可用
	 */
	private Integer spStatus;

	/**
	 * 状态，0:可用 1:不可用
	 */
	private Integer spConnectStatus;

	/**
	 * 通道ip
	 */
	private String spIp;

	/**
	 * 通道端口
	 */
	private Integer spPort;

	/**
	 * 流速
	 */
	private Integer speedLimit;

	/**
	 * 登录名
	 */
	private String spLoginName;

	/**
	 * 登陆密码
	 */
	private String spLoginPwd;

	/**
	 * 主键自增Id
	 * 
	 * @return id 主键自增Id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 主键自增Id
	 * 
	 * @param id
	 *            主键自增Id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 接入号
	 * 
	 * @return sp_id 接入号
	 */
	public String getSpId() {
		return spId;
	}

	/**
	 * 接入号
	 * 
	 * @param spId
	 *            接入号
	 */
	public void setSpId(String spId) {
		this.spId = spId == null ? null : spId.trim();
	}

	/**
	 * 通道名称
	 * 
	 * @return sp_name 通道名称
	 */
	public String getSpName() {
		return spName;
	}

	/**
	 * 通道名称
	 * 
	 * @param spName
	 *            通道名称
	 */
	public void setSpName(String spName) {
		this.spName = spName == null ? null : spName.trim();
	}

	/**
	 * 通道类型
	 * 
	 * @return sp_type 通道类型
	 */
	public Integer getSpType() {
		return spType;
	}

	/**
	 * 通道类型
	 * 
	 * @param spType
	 *            通道类型
	 */
	public void setSpType(Integer spType) {
		this.spType = spType;
	}

	/**
	 * 状态，0:可用 1:不可用
	 * 
	 * @return sp_status 状态，0:可用 1:不可用
	 */
	public Integer getSpStatus() {
		return spStatus;
	}

	/**
	 * 状态，0:可用 1:不可用
	 * 
	 * @param spStatus
	 *            状态，0:可用 1:不可用
	 */
	public void setSpStatus(Integer spStatus) {
		this.spStatus = spStatus;
	}

	/**
	 * 状态，0:可用 1:不可用
	 * 
	 * @return sp_connect_status 状态，0:可用 1:不可用
	 */
	public Integer getSpConnectStatus() {
		return spConnectStatus;
	}

	/**
	 * 状态，0:可用 1:不可用
	 * 
	 * @param spConnectStatus
	 *            状态，0:可用 1:不可用
	 */
	public void setSpConnectStatus(Integer spConnectStatus) {
		this.spConnectStatus = spConnectStatus;
	}

	/**
	 * 通道ip
	 * 
	 * @return sp_ip 通道ip
	 */
	public String getSpIp() {
		return spIp;
	}

	/**
	 * 通道ip
	 * 
	 * @param spIp
	 *            通道ip
	 */
	public void setSpIp(String spIp) {
		this.spIp = spIp == null ? null : spIp.trim();
	}

	/**
	 * 通道端口
	 * 
	 * @return sp_port 通道端口
	 */
	public Integer getSpPort() {
		return spPort;
	}

	/**
	 * 通道端口
	 * 
	 * @param spPort
	 *            通道端口
	 */
	public void setSpPort(Integer spPort) {
		this.spPort = spPort;
	}

	/**
	 * 流速
	 * 
	 * @return speed_limit 流速
	 */
	public Integer getSpeedLimit() {
		return speedLimit;
	}

	/**
	 * 流速
	 * 
	 * @param speedLimit
	 *            流速
	 */
	public void setSpeedLimit(Integer speedLimit) {
		this.speedLimit = speedLimit;
	}

	/**
	 * 登录名
	 * 
	 * @return sp_login_name 登录名
	 */
	public String getSpLoginName() {
		return spLoginName;
	}

	/**
	 * 登录名
	 * 
	 * @param spLoginName
	 *            登录名
	 */
	public void setSpLoginName(String spLoginName) {
		this.spLoginName = spLoginName == null ? null : spLoginName.trim();
	}

	/**
	 * 登陆密码
	 * 
	 * @return sp_login_pwd 登陆密码
	 */
	public String getSpLoginPwd() {
		return spLoginPwd;
	}

	/**
	 * 登陆密码
	 * 
	 * @param spLoginPwd
	 *            登陆密码
	 */
	public void setSpLoginPwd(String spLoginPwd) {
		this.spLoginPwd = spLoginPwd == null ? null : spLoginPwd.trim();
	}

}