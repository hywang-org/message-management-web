package com.flash.message.utils;

import java.security.MessageDigest;
import java.util.Base64;

public class MD5Util {
	/**
	 * 
	 * @param pwd
	 *            需要加密的字符
	 * @return
	 */
	public static String getMD5(String pwd) {
		String md5 = new String();
		try {
			// 创建加密对象
			MessageDigest md = MessageDigest.getInstance("md5");
			md5 = Base64.getEncoder().encodeToString(md.digest(pwd.getBytes("utf-8")));
			md5 = md5.toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("md5加密抛出异常！");
		}

		return md5;
	}

	public static void main(String[] args) throws Exception {
		String a = "qweasdzxc";
		String md5a = getMD5(a);
		System.out.println(md5a);
		System.out.println(md5a.length());
	}

}
