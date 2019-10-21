package com.flash.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@MapperScan("com.flash.message.mapper")
public class MessageWebManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(MessageWebManagementApplication.class, args);
	}
}
