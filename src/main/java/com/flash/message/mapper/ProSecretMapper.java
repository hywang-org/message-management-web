package com.flash.message.mapper;

import org.springframework.stereotype.Repository;

import com.flash.message.entity.app.ProSecret;

@Repository
public interface ProSecretMapper {

	int insertSelective(ProSecret secret);

	int resetPassword(String secret, String appId);

	String queryPassword(String appId);
}