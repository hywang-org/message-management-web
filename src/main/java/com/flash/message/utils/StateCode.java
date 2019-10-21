package com.flash.message.utils;

/**
 * @author 作者 :hywang
 *
 * @version 创建时间：2019年9月7日 下午5:19:52
 *
 * @version 1.0
 */
public enum StateCode {
    SUCCESS("000000", "添加成功!"),
	USER_NOT_EXIST("200001", "用户名不存在"),
	PWD_RESET_FAIL("200002", "重置密码失败"),
	ADD_USER_FAIL("200003", "添加用户失败"),
	ADD_APP_FAIL("200004", "添加App失败"),
	PWD_ERROR("200005", "密码输入错误"),
	ADD_CHANNEL_FAIL("200006", "添加通道失败"),
	CHANNEL_UPDATE_FAIL("200007", "更新通道失败"),
	RECHARGE_FAIL("200008", "充值失败"),
	ADD_MENU_FAILE("200009", "添加菜单失败"),
	MENU_ID_IS_NULL("200010", "菜单ID为空"),
	USER_NAME_EXIST("200011", "用户名已存在"),
	APP_NAME_EXIST("200012", "app名称已存在"),
	APP_UPDATE_FAIL("200013", "app更新失败"),
	ADD_ROLE_FAIL("200014", "添加角色失败"),
	IMG_CODE_ERROR("200015", "验证码输入错误"),
	INTERNAL_ERROR("999999", "内部错误");

    private String code;
    private String desc;

    private StateCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
